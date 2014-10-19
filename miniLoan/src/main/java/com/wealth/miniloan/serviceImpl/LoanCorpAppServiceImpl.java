package com.wealth.miniloan.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.dao.AppCheckResultDao;
import com.wealth.miniloan.dao.AppSummaryDao;
import com.wealth.miniloan.dao.CorpAppDao;
import com.wealth.miniloan.dao.CorpAttachDao;
import com.wealth.miniloan.dao.CorpCreditDao;
import com.wealth.miniloan.dao.MortgageInfoDao;
import com.wealth.miniloan.dao.ShareholderDao;
import com.wealth.miniloan.entity.AppSummaryExtend;
import com.wealth.miniloan.entity.MlAppCheckResultExample;
import com.wealth.miniloan.entity.MlAppSummaryExample;
import com.wealth.miniloan.entity.MlCorpApp;
import com.wealth.miniloan.entity.MlCorpAppExample;
import com.wealth.miniloan.entity.MlCorpAttachExample;
import com.wealth.miniloan.entity.MlCorpCreditExample;
import com.wealth.miniloan.entity.MlMortgageInfoExample;
import com.wealth.miniloan.entity.MlShareholderExample;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.LoanCorpAppServiceI;
import com.wealth.miniloan.utils.Constant;
import com.wealth.miniloan.utils.SysUtil;

@Service
public class LoanCorpAppServiceImpl implements LoanCorpAppServiceI {
	private CorpAppDao corpAppDao = null;
	private AppSummaryDao appSummaryDao = null;
	private AppCheckResultDao appCheckResultDao = null;
	private CorpAttachDao corpAttachDao = null;
	private CorpCreditDao corpCreditDao = null;
	private MortgageInfoDao mortgageInfoDao = null;
	private ShareholderDao shareholderDao = null;
	private final String _ORDER_ATTRS = "appNo";
	private final String _ORDER_FIELDS = "APP_NO";

	@Autowired
	public void setCorpAppDao(CorpAppDao corpAppDao) {
		this.corpAppDao = corpAppDao;
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
	public void setCorpAttachDao(CorpAttachDao corpAttachDao) {
		this.corpAttachDao = corpAttachDao;
	}
	
	@Autowired
	public void setCorpCreditDao(CorpCreditDao corpCreditDao) {
		this.corpCreditDao = corpCreditDao;
	}
	
	@Autowired
	public void setMortgageInfoDao(MortgageInfoDao mortgageInfoDao) {
		this.mortgageInfoDao = mortgageInfoDao;
	}
	
	@Autowired
	public void setShareholderDao(ShareholderDao shareholderDao) {
		this.shareholderDao = shareholderDao;
	}

	@Override
	public PageList<AppSummaryExtend> getSummaryPageList(Page paramPage, MlCorpApp obj) {
		MlAppSummaryExample asExample = new MlAppSummaryExample();
		com.wealth.miniloan.entity.MlAppSummaryExample.Criteria c = asExample.createCriteria();
		c.andAppTypeEqualTo(Constant.APP_TYPE_CORP);
		c.andCurrStepEqualTo(Constant.STEP_LOAN_APP);
		String order = SysUtil.dealOrderby(paramPage, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!order.equals("")) {
			asExample.setOrderByClause(order);
		}
		return this.appSummaryDao.getPageList(SysUtil.convertPage(paramPage), asExample);
	}

	@Override
	public int create(MlCorpApp obj) {
		return this.corpAppDao.save(obj);
	}

	@Override
	public int update(MlCorpApp obj) {
		return this.corpAppDao.update(obj);
	}

	@Override
	public int delete(String ids) {
		String[] idArray = ids.split(",");
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < idArray.length; i++) {
			list.add(idArray[i]);
		}
		// 删除概况信息
		MlAppSummaryExample example1 = new MlAppSummaryExample();
		example1.createCriteria().andAppNoIn(list);
		this.appSummaryDao.deleteByExample(example1);

		// //删除审核信息
		MlAppCheckResultExample example2 = new MlAppCheckResultExample();
		example2.createCriteria().andAppNoIn(list);
		this.appCheckResultDao.deleteByExample(example2);

		// 删除基本信息
		MlCorpAppExample example3 = new MlCorpAppExample();
		example3.createCriteria().andAppNoIn(list);
		this.corpAppDao.deleteByExample(example3);

		// 删除征信信息
		MlCorpCreditExample example4 = new MlCorpCreditExample();
		example4.createCriteria().andAppNoIn(list);
		this.corpCreditDao.deleteByExample(example4);

		// 删除附件信息
		MlCorpAttachExample example5 = new MlCorpAttachExample();
		example5.createCriteria().andAppNoIn(list);
		this.corpAttachDao.deleteByExample(example5);

		// 删除押品信息
		MlMortgageInfoExample example6 = new MlMortgageInfoExample();
		example6.createCriteria().andAppNoIn(list);
		this.mortgageInfoDao.deleteByExample(example6);
		
		// 删除股东信息
		MlShareholderExample example7 = new MlShareholderExample();
		example7.createCriteria().andAppNoIn(list);
		this.shareholderDao.deleteByExample(example7);
		
		return 0;
	}

	@Override
	public MlCorpApp getByPriKey(MlCorpApp obj) {
		return (MlCorpApp) this.corpAppDao.getById(obj.getAppNo());
	}

	@Override
	public PageList<MlCorpApp> getLoanCorpAppPageList(Page paramPage, MlCorpApp corpApp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getByExample(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
