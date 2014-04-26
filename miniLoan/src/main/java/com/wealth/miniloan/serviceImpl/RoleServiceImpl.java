package com.wealth.miniloan.serviceImpl;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.dao.AuthorityDao;
import com.wealth.miniloan.dao.RescDao;
import com.wealth.miniloan.dao.RoleDao;
import com.wealth.miniloan.entity.MlRole;
import com.wealth.miniloan.entity.MlRoleExample;
import com.wealth.miniloan.entity.MlRoleExample.Criteria;
import com.wealth.miniloan.entity.MlSysAuthority;
import com.wealth.miniloan.entity.MlSysAuthorityExample;
import com.wealth.miniloan.entity.MlSysResc;
import com.wealth.miniloan.entity.MlSysRescExample;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.entity.RescAuthModel;
import com.wealth.miniloan.service.RoleServiceI;
import com.wealth.miniloan.utils.SysUtil;
import com.wealth.miniloan.utils.key.KeyGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("roleService")
public class RoleServiceImpl implements RoleServiceI {
	private RoleDao roleDao = null;
	private RescDao rescDao = null;
	private AuthorityDao authorityDao=null;
	private final String _ORDER_ATTRS = "roleName,status";
	private final String _ORDER_FIELDS = "ROLE_NAME,STATUS";

	public RoleDao getRoleDao() {
		return this.roleDao;
	}

	@Autowired
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public RescDao getRescDao() {
		return rescDao;
	}

	@Autowired
	public void setRescDao(RescDao rescDao) {
		this.rescDao = rescDao;
	}

	public AuthorityDao getAuthorityDao() {
		return authorityDao;
	}

	@Autowired
	public void setAuthorityDao(AuthorityDao authorityDao) {
		this.authorityDao = authorityDao;
	}

	public PageList<MlRole> getRolePageList(Page page, MlRole role) {
		MlRoleExample example = new MlRoleExample();
		String roleName = role.getRoleName();
		String roleDesc = role.getRoleDesc();
		MlRoleExample.Criteria criteria = example.createCriteria();
		if ((roleName != null) && (!"".equals(roleName))) {
			criteria.andRoleNameLike("%" + roleName + "%");
		}
		if ((roleDesc != null) && (!"".equals(roleDesc))) {
			criteria.andRoleDescLike("%" + roleDesc + "%");
		}

		String order = SysUtil.dealOrderby(page, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!"".equals(order)) {
			example.setOrderByClause(order);
		}

		return this.roleDao.findPage(SysUtil.convertPage(page), example);
	}

	public MlRole getRoleByPrikey(MlRole role) {
		return (MlRole) this.roleDao.getById(role.getRoleId());
	}

	public int createRole(MlRole role) {
		role.setRoleId(KeyGenerator.getNextKey("ML_ROLE", "ROLE_ID"));
		return this.roleDao.save(role);
	}

	public int updateRoleByPriKey(MlRole role) {
		return this.roleDao.update(role);
	}

	public int deleteRoleByPriKey(long id) {
		return this.roleDao.deleteById(Long.valueOf(id));
	}

	@Override
	public List<RescAuthModel> loadRoleAuthTree(MlRole role) {
		// 得到所有的模块
		MlSysRescExample rescExample = new MlSysRescExample();
		MlSysRescExample.Criteria rescCriteria = rescExample.createCriteria();
		rescCriteria.andRescTypeEqualTo("M");
		rescCriteria.andRescStatusEqualTo("1");
		rescExample.setOrderByClause("RESC_ID");
		List<MlSysResc> allRescList = this.rescDao.findAll(rescExample);
		
		//得到所有的权限列表
		List<MlSysAuthority> allAuthList = this.authorityDao.getAll();

		return null;
	}
}