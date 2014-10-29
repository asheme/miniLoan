package com.wealth.miniloan.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.wealth.miniloan.entity.CorpAppExample;
import com.wealth.miniloan.entity.CorpAppInfo;
import com.wealth.miniloan.entity.MlAppCheckResultExample;
import com.wealth.miniloan.entity.MlAppSummaryExample;
import com.wealth.miniloan.entity.MlCorpApp;
import com.wealth.miniloan.entity.MlCorpAppExample;
import com.wealth.miniloan.entity.MlCorpAttachExample;
import com.wealth.miniloan.entity.MlCorpCreditExample;
import com.wealth.miniloan.entity.MlMortgageInfoExample;
import com.wealth.miniloan.entity.MlShareholderExample;
import com.wealth.miniloan.entity.NaturalAppExample;
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
	private final String _ORDER_ATTRS = "appNo,borrower,loanAmount,loanPeriod,compName,regAddr,compType,establishDate,legalPerson,lpIdType,lpIdNo,lpNative,lpAddr,busiScope,lastYearAssets,lastYearLiabilities,lastYearSalesAmount,lastYearProfit,lastYearPayTax,avgCashFlowInSixmth,guaranteeType,houseType,landStatus,houseLocation,houseCertificationNo,buildingArea,isRent,monthlyRent,purchaseValue,estimatedValue,inventoryType,storagePlace,hasContract,unit,unitPrice,marketPrice,repertory,lowestRepertoryLastYear,hasSpecialStorageRequire,ensureCompName,ensureCompRegCapital,ensureCompAssets,ensureCompNetAssets,guarantor,guarantorIdType,guarantorIdNo,guarantorNation,guarantorHomeAddr,loanUse,loanProduct,loanAmount2,loanCycle,payMethod,lendAccount,payAccount,operator,opTime,appType,currApproveLvl,enterTime,previousStep,currStep,nextStep,status,handler,finishTime,manualResult,loanLimit,loanRate,reasonCode,reasonDesc,currUser,operTime,hostageType,hostageNo,hostageOwner,depositAccount,loanUse,loanProduct,loanAmount,loanCycle,payMethod,lendAccount,payAccount,operator,opTime,appType,currApproveLvl,enterTime,previousStep,currStep,nextStep,status,handler,finishTime,manualResult,loanLimit,loanRate,reasonCode,reasonDesc,currUser,operTime";
	private final String _ORDER_FIELDS = "APP_NO,BORROWER,LOAN_AMOUNT,LOAN_PERIOD,COMP_NAME,REG_ADDR,COMP_TYPE,ESTABLISH_DATE,LEGAL_PERSON,LP_ID_TYPE,LP_ID_NO,LP_NATIVE,LP_ADDR,BUSI_SCOPE,LAST_YEAR_ASSETS,LAST_YEAR_LIABILITIES,LAST_YEAR_SALES_AMOUNT,LAST_YEAR_PROFIT,LAST_YEAR_PAY_TAX,AVG_CASH_FLOW_IN_SIXMTH,GUARANTEE_TYPE,HOUSE_TYPE,LAND_STATUS,HOUSE_LOCATION,HOUSE_CERTIFICATION_NO,BUILDING_AREA,IS_RENT,MONTHLY_RENT,PURCHASE_VALUE,ESTIMATED_VALUE,INVENTORY_TYPE,STORAGE_PLACE,HAS_CONTRACT,UNIT,UNIT_PRICE,MARKET_PRICE,REPERTORY,LOWEST_REPERTORY_LAST_YEAR,HAS_SPECIAL_STORAGE_REQUIRE,ENSURE_COMP_NAME,ENSURE_COMP_REG_CAPITAL,ENSURE_COMP_ASSETS,ENSURE_COMP_NET_ASSETS,GUARANTOR,GUARANTOR_ID_TYPE,GUARANTOR_ID_NO,GUARANTOR_NATION,GUARANTOR_HOME_ADDR,LOAN_USE,LOAN_PRODUCT,LOAN_AMOUNT2,LOAN_CYCLE,PAY_METHOD,LEND_ACCOUNT,PAY_ACCOUNT,OPERATOR,OP_TIME,APP_TYPE,CURR_APPROVE_LVL,ENTER_TIME,PREVIOUS_STEP,CURR_STEP,NEXT_STEP,STATUS,HANDLER,FINISH_TIME,MANUAL_RESULT,LOAN_LIMIT,LOAN_RATE,REASON_CODE,REASON_DESC,CURR_USER,OPER_TIME,HOSTAGE_TYPE,HOSTAGE_NO,HOSTAGE_OWNER,DEPOSIT_ACCOUNT,LOAN_USE,LOAN_PRODUCT,LOAN_AMOUNT,LOAN_CYCLE,PAY_METHOD,LEND_ACCOUNT,PAY_ACCOUNT,OPERATOR,OP_TIME,APP_TYPE,CURR_APPROVE_LVL,ENTER_TIME,PREVIOUS_STEP,CURR_STEP,NEXT_STEP,STATUS,HANDLER,FINISH_TIME,MANUAL_RESULT,LOAN_LIMIT,LOAN_RATE,REASON_CODE,REASON_DESC,CURR_USER,OPER_TIME";
	
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
	public PageList<CorpAppInfo> getCorpAppPageList(Page page, CorpAppInfo corpAppInfo) {
		CorpAppExample example=new CorpAppExample();
		CorpAppExample.Criteria criteria = example.createCriteria();
		String borrower = corpAppInfo.getBorrower();
		String compName = corpAppInfo.getCompName();
		String appNo = corpAppInfo.getAppNo();
		if (borrower != null && !"".equals(borrower)) {
			criteria.andBorrowerLike("%" + borrower + "%");
		}
		if (compName != null && !"".equals(compName)) {
			criteria.andCompNameLike("%" + compName + "%");
		}
		if (appNo != null && !"".equals(appNo)) {
			criteria.andAppNoLike("%" + appNo + "%");
		}
		criteria.andCurrStepEqualTo(Constant.STEP_LOAN_APP);
		criteria.andStatusNotIn(new ArrayList<String>(){{add(Constant.APP_STATUS_REJECT);add(Constant.APP_STATUS_APPROVE);}});
		String order = SysUtil.dealOrderby(page, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!order.equals("")) {
			example.setOrderByClause(order);
		}

		return this.appSummaryDao.queryCorpAppPageList(SysUtil.convertPage(page),example);
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
	public Object getByExample(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
