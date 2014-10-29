package com.wealth.miniloan.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.wealth.miniloan.entity.AppSummaryExtend;
import com.wealth.miniloan.entity.MlDictExample;
import com.wealth.miniloan.entity.MlMortgageInfoExample;
import com.wealth.miniloan.entity.MlNaturalApp;
import com.wealth.miniloan.entity.MlNaturalAppExample;
import com.wealth.miniloan.entity.MlNaturalAttachExample;
import com.wealth.miniloan.entity.MlNaturalCreditExample;
import com.wealth.miniloan.entity.NaturalAppExample;
import com.wealth.miniloan.entity.NaturalAppInfo;
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
	private final String _ORDER_ATTRS = "appNo,name,idType,idNo,idSignDate,idExpireDate,gender,birthday,age,nation,educationLvl,politicsStatus,marriageStatus,mobile,homePhone,email,industryType,company,position,workYears,currJobStDate,compAddr,compPhone,compZip,homeAddr,homeZip,residentStatus,liveStartTime,carBrand,carNo,carStatus,carBuyDate,deposit,stockValue,monthIncome,spouseMonthIncome,homeIncome,liabilities,hasDowryContract,spouseName,spouseIdType,spouseIdNo,spouseIdSignDate,spouseIdExpireDate,spouseIndustryType,spouseCompany,spousePosition,spouseCompAddr,spouseCompZip,spouseMobile,spouseHomePhone,spouseEmail,linkmanName,linkmanIdType,linkmanIdNo,linkmanIdSignDate,linkmanIdExpireDate,linkmanIndustryType,linkmanCompany,linkmanPosition,linkmanCompAddr,linkmanCompZip,linkmanMobile,linkmanHomePhone,linkmanEmail,guarantee,guarBusiLicenseNo,guarLegalPerson,guarCompOpenDate,guarCompAddr,guarPhone,guarCapital,guarCreditRate,hostageType,hostageNo,hostageOwner,depositAccount,loanUse,loanProduct,loanAmount,loanCycle,payMethod,lendAccount,payAccount,operator,opTime,appType,currApproveLvl,enterTime,previousStep,currStep,nextStep,status,handler,finishTime,manualResult,loanLimit,loanRate,reasonCode,reasonDesc,currUser,operTime";
	private final String _ORDER_FIELDS = "APP_NO,NAME,ID_TYPE,ID_NO,ID_SIGN_DATE,ID_EXPIRE_DATE,GENDER,BIRTHDAY,AGE,NATION,EDUCATION_LVL,POLITICS_STATUS,MARRIAGE_STATUS,MOBILE,HOME_PHONE,EMAIL,INDUSTRY_TYPE,COMPANY,POSITION,WORK_YEARS,CURR_JOB_ST_DATE,COMP_ADDR,COMP_PHONE,COMP_ZIP,HOME_ADDR,HOME_ZIP,RESIDENT_STATUS,LIVE_START_TIME,CAR_BRAND,CAR_NO,CAR_STATUS,CAR_BUY_DATE,DEPOSIT,STOCK_VALUE,MONTH_INCOME,SPOUSE_MONTH_INCOME,HOME_INCOME,LIABILITIES,HAS_DOWRY_CONTRACT,SPOUSE_NAME,SPOUSE_ID_TYPE,SPOUSE_ID_NO,SPOUSE_ID_SIGN_DATE,SPOUSE_ID_EXPIRE_DATE,SPOUSE_INDUSTRY_TYPE,SPOUSE_COMPANY,SPOUSE_POSITION,SPOUSE_COMP_ADDR,SPOUSE_COMP_ZIP,SPOUSE_MOBILE,SPOUSE_HOME_PHONE,SPOUSE_EMAIL,LINKMAN_NAME,LINKMAN_ID_TYPE,LINKMAN_ID_NO,LINKMAN_ID_SIGN_DATE,LINKMAN_ID_EXPIRE_DATE,LINKMAN_INDUSTRY_TYPE,LINKMAN_COMPANY,LINKMAN_POSITION,LINKMAN_COMP_ADDR,LINKMAN_COMP_ZIP,LINKMAN_MOBILE,LINKMAN_HOME_PHONE,LINKMAN_EMAIL,GUARANTEE,GUAR_BUSI_LICENSE_NO,GUAR_LEGAL_PERSON,GUAR_COMP_OPEN_DATE,GUAR_COMP_ADDR,GUAR_PHONE,GUAR_CAPITAL,GUAR_CREDIT_RATE,HOSTAGE_TYPE,HOSTAGE_NO,HOSTAGE_OWNER,DEPOSIT_ACCOUNT,LOAN_USE,LOAN_PRODUCT,LOAN_AMOUNT,LOAN_CYCLE,PAY_METHOD,LEND_ACCOUNT,PAY_ACCOUNT,OPERATOR,OP_TIME,APP_TYPE,CURR_APPROVE_LVL,ENTER_TIME,PREVIOUS_STEP,CURR_STEP,NEXT_STEP,STATUS,HANDLER,FINISH_TIME,MANUAL_RESULT,LOAN_LIMIT,LOAN_RATE,REASON_CODE,REASON_DESC,CURR_USER,OPER_TIME";
	
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
	public PageList<NaturalAppInfo> getNatrualAppPageList(Page paramPage,
			NaturalAppInfo naturalAppInfo) {
		NaturalAppExample example=new NaturalAppExample();
		NaturalAppExample.Criteria criteria = example.createCriteria();
		String idNo = naturalAppInfo.getIdNo();
		String name = naturalAppInfo.getName();
		String appNo = naturalAppInfo.getAppNo();
		if (idNo != null && !"".equals(idNo)) {
			criteria.andIdNoLike("%" + idNo + "%");
		}
		if (name != null && !"".equals(name)) {
			criteria.andNameLike("%" + name + "%");
		}
		if (appNo != null && !"".equals(appNo)) {
			criteria.andAppNoLike("%" + appNo + "%");
		}
		criteria.andCurrStepEqualTo(Constant.STEP_LOAN_APP);
		criteria.andStatusNotIn(new ArrayList<String>(){{add(Constant.APP_STATUS_REJECT);add(Constant.APP_STATUS_APPROVE);}});
		String order = SysUtil.dealOrderby(paramPage, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!order.equals("")) {
			example.setOrderByClause(order);
		}

		return this.appSummaryDao.queryNatrualAppPageList(SysUtil.convertPage(paramPage),example);
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
