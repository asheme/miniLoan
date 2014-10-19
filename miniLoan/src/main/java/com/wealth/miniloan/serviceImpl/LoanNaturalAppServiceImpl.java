package com.wealth.miniloan.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.dao.AppCheckResultDao;
import com.wealth.miniloan.dao.AppSummaryDao;
import com.wealth.miniloan.dao.MortgageInfoDao;
import com.wealth.miniloan.dao.NaturalAppDao;
import com.wealth.miniloan.dao.NaturalAttachDao;
import com.wealth.miniloan.dao.NaturalCreditDao;
import com.wealth.miniloan.entity.MlAppCheckResultExample;
import com.wealth.miniloan.entity.MlAppSummaryExample;
import com.wealth.miniloan.entity.MlAppSummaryExample.Criteria;
import com.wealth.miniloan.entity.AppSummaryExtend;
import com.wealth.miniloan.entity.MlMortgageInfoExample;
import com.wealth.miniloan.entity.MlNaturalApp;
import com.wealth.miniloan.entity.MlNaturalAppExample;
import com.wealth.miniloan.entity.MlNaturalAttachExample;
import com.wealth.miniloan.entity.MlNaturalCreditExample;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.LoanNaturalAppServiceI;
import com.wealth.miniloan.utils.Constant;
import com.wealth.miniloan.utils.SysUtil;

@Service
public class LoanNaturalAppServiceImpl implements LoanNaturalAppServiceI {
	private NaturalAppDao naturalAppDao = null;
	private AppSummaryDao appSummaryDao = null;
	private AppCheckResultDao appCheckResultDao = null;
	private NaturalAttachDao naturalAttachDao = null;
	private NaturalCreditDao naturalCreditDao = null;
	private MortgageInfoDao mortgageInfoDao = null;
	private final String _ORDER_ATTRS = "appNo";
	private final String _ORDER_FIELDS = "APP_NO";

	@Autowired
	public void setNaturalAppDao(NaturalAppDao naturalAppDao) {
		this.naturalAppDao = naturalAppDao;
	}

	@Autowired
	public void setAppSummaryDao(AppSummaryDao appSummaryDao) {
		this.appSummaryDao = appSummaryDao;
	}
	
	@Autowired
	public void setAppCheckResultDao(AppCheckResultDao appCheckResultDao) {
		this.appCheckResultDao = appCheckResultDao;
	}
	
	@Autowired
	public void setNaturalAttachDao(NaturalAttachDao naturalAttachDao) {
		this.naturalAttachDao = naturalAttachDao;
	}
	
	@Autowired
	public void setNaturalCreditDao(NaturalCreditDao naturalCreditDao) {
		this.naturalCreditDao = naturalCreditDao;
	}
	
	@Autowired
	public void setMortgageInfoDao(MortgageInfoDao mortgageInfoDao) {
		this.mortgageInfoDao = mortgageInfoDao;
	}
	
	@Override
	public PageList<AppSummaryExtend> getSummaryPageList(Page paramPage, MlNaturalApp obj) {
		MlAppSummaryExample asExample = new MlAppSummaryExample();
		Criteria c = asExample.createCriteria();
		List<String> endStatusList=new ArrayList<String>();
		endStatusList.add(Constant.APP_STATUS_REJECT);
		endStatusList.add(Constant.APP_STATUS_APPROVE);
		c.andAppTypeEqualTo(Constant.APP_TYPE_NATURAL).andCurrStepEqualTo(Constant.STEP_LOAN_APP).andStatusNotIn(endStatusList);
		String order = SysUtil.dealOrderby(paramPage, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!order.equals("")) {
			asExample.setOrderByClause(order);
		}
		return this.appSummaryDao.getPageList(SysUtil.convertPage(paramPage), asExample);
	}

	@Override
	public int create(MlNaturalApp obj) {
		return this.naturalAppDao.save(obj);
	}

	@Override
	public int update(MlNaturalApp obj) {
		return this.naturalAppDao.update(obj);
	}

	@Override
	public int delete(String ids) {
		String[] idArray = ids.split(",");
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < idArray.length; i++) {
			list.add(idArray[i]);
		}
		//删除概况信息
		MlAppSummaryExample example1 = new MlAppSummaryExample();
		example1.createCriteria().andAppNoIn(list);
		this.appSummaryDao.deleteByExample(example1);
		
		////删除审核信息
		MlAppCheckResultExample example2 = new MlAppCheckResultExample();
		example2.createCriteria().andAppNoIn(list);
		this.appCheckResultDao.deleteByExample(example2);
		
		//删除基本信息
		MlNaturalAppExample example3 = new MlNaturalAppExample();
		example3.createCriteria().andAppNoIn(list);
		this.naturalAppDao.deleteByExample(example3);
		
		//删除征信信息
		MlNaturalCreditExample example4 = new MlNaturalCreditExample();
		example4.createCriteria().andAppNoIn(list);
		this.naturalCreditDao.deleteByExample(example4);
		
		//删除附件信息
		MlNaturalAttachExample example5 = new MlNaturalAttachExample();
		example5.createCriteria().andAppNoIn(list);
		this.naturalAttachDao.deleteByExample(example5);
		
		// 删除押品信息
		MlMortgageInfoExample example6 = new MlMortgageInfoExample();
		example6.createCriteria().andAppNoIn(list);
		this.mortgageInfoDao.deleteByExample(example6);
		
		return 0;
	}

	@Override
	public MlNaturalApp getByPriKey(MlNaturalApp obj) {
		return (MlNaturalApp) this.naturalAppDao.getById(obj.getAppNo());
	}

	@Override
	public Object getByExample(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageList<MlNaturalApp> getPageList(Page paramPage, MlNaturalApp obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
