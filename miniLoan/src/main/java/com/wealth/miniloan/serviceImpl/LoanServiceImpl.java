package com.wealth.miniloan.serviceImpl;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.dao.AppSummaryDao;
import com.wealth.miniloan.dao.CorpAppDao;
import com.wealth.miniloan.dao.CorpCustDao;
import com.wealth.miniloan.dao.LoanDao;
import com.wealth.miniloan.dao.NaturalAppDao;
import com.wealth.miniloan.dao.NaturalCustDao;
import com.wealth.miniloan.entity.MlAppSummary;
import com.wealth.miniloan.entity.MlAppSummaryExample;
import com.wealth.miniloan.entity.MlCorpApp;
import com.wealth.miniloan.entity.MlCorpCustInfo;
import com.wealth.miniloan.entity.MlCorpCustInfoExample;
import com.wealth.miniloan.entity.MlLoanInfo;
import com.wealth.miniloan.entity.MlNaturalApp;
import com.wealth.miniloan.entity.MlNaturalCustInfo;
import com.wealth.miniloan.entity.MlNaturalCustInfoExample;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.entity.UnionLoanInfo;
import com.wealth.miniloan.entity.User;
import com.wealth.miniloan.service.LoanServiceI;
import com.wealth.miniloan.utils.Constant;
import com.wealth.miniloan.utils.key.KeyGenerator;

@Service
public class LoanServiceImpl implements LoanServiceI {
	private NaturalAppDao naturalAppDao;
	private CorpAppDao corpAppDao;
	private AppSummaryDao appSummaryDao;
	private NaturalCustDao naturalCustDao;
	private CorpCustDao corpCustDao;
	private LoanDao loanDao;
	private GetMainKeyService getMainKeyService;
	

	@Autowired
	public void setNaturalAppDao(NaturalAppDao naturalAppDao) {
		this.naturalAppDao = naturalAppDao;
	}

	@Autowired
	public void setCorpAppDao(CorpAppDao corpAppDao) {
		this.corpAppDao = corpAppDao;
	}

	@Autowired
	public void setAppSummaryDao(AppSummaryDao appSummaryDao) {
		this.appSummaryDao = appSummaryDao;
	}

	@Autowired
	public void setNaturalCustDao(NaturalCustDao naturalCustDao) {
		this.naturalCustDao = naturalCustDao;
	}

	@Autowired
	public void setCorpCustDao(CorpCustDao corpCustDao) {
		this.corpCustDao = corpCustDao;
	}

	@Autowired
	public void setLoanDao(LoanDao loanDao) {
		this.loanDao = loanDao;
	}
	
	@Autowired
	public void setGetMainKeyService(GetMainKeyService getMainKeyService) {
		this.getMainKeyService = getMainKeyService;
	}

	@Override
	public boolean saveLoanInfo(String appNo, String appType,User user) {
		boolean result = false;
		MlNaturalApp naturalApp = null;
		MlAppSummary appSummary=null;
		MlCorpApp corpApp = null;
		MlNaturalCustInfo naturalCustInfo=null;
		MlCorpCustInfo corpCustInfo = null;
		MlLoanInfo loanInfo=null;
		String custNo=null;
		
		try{
			//查询审批结果
			MlAppSummaryExample summaryExample=new MlAppSummaryExample();
			summaryExample.createCriteria().andAppNoEqualTo(appNo);
			appSummary=this.appSummaryDao.findOne(summaryExample);
			
			//保存客户信息
			if(Constant.APP_TYPE_NATURAL.equals(appType)){
				naturalApp=this.naturalAppDao.getById(appNo);
				naturalCustInfo=findNaturalCust(naturalApp);
				if(naturalCustInfo==null){
					naturalCustInfo= new MlNaturalCustInfo();
					custNo=getMainKeyService.getKey(Constant.KEY_TYPE_CUST_NO);
					naturalCustInfo.setCustNo(custNo);
					naturalCustInfo.setName(naturalApp.getName());
					naturalCustInfo.setIdType(naturalApp.getIdType());
					naturalCustInfo.setIdNo(naturalApp.getIdNo());
					naturalCustInfo.setGender(naturalApp.getGender());
					naturalCustInfo.setBirthday(naturalApp.getBirthday());
					naturalCustInfo.setAge(naturalApp.getAge());
					naturalCustInfo.setNation(naturalApp.getNation());
					naturalCustInfo.setEducationLvl(naturalApp.getEducationLvl());
					naturalCustInfo.setPoliticsStatus(naturalApp.getPoliticsStatus());
					naturalCustInfo.setMobile(naturalApp.getMobile());
					naturalCustInfo.setHomePhone(naturalApp.getHomePhone());
					naturalCustInfo.setEmail(naturalApp.getEmail());
					naturalCustInfo.setIndustryType(naturalApp.getIndustryType());
					naturalCustInfo.setCompany(naturalApp.getCompany());
					naturalCustInfo.setPosition(naturalApp.getPosition());
					naturalCustInfo.setWorkYears(naturalApp.getWorkYears());
					naturalCustInfo.setCurrJobStDate(naturalApp.getCurrJobStDate());
					naturalCustInfo.setCompAddr(naturalApp.getCompAddr());
					naturalCustInfo.setCompZip(naturalApp.getCompZip());
					naturalCustInfo.setHomeAddr(naturalApp.getHomeAddr());
					naturalCustInfo.setHomeZip(naturalApp.getHomeZip());
					naturalCustInfo.setResidentStatus(naturalApp.getResidentStatus());
					naturalCustInfo.setLiveStartTime(naturalApp.getLiveStartTime());
					naturalCustInfo.setCarBrand(naturalApp.getCarBrand());
					naturalCustInfo.setCarNo(naturalApp.getCarNo());
					naturalCustInfo.setCarStatus(naturalApp.getCarStatus());
					naturalCustInfo.setCarBuyDate(naturalApp.getCarBuyDate());
					naturalCustInfo.setDeposit(naturalApp.getDeposit());
					naturalCustInfo.setStockValue(naturalApp.getStockValue());
					naturalCustInfo.setMonthIncome(naturalApp.getMonthIncome());
					naturalCustInfo.setLoanAmount(appSummary.getLoanLimit());
					naturalCustInfo.setRemainAmount(appSummary.getLoanLimit());
					naturalCustInfo.setPayAmount(BigDecimal.valueOf(0));
					naturalCustInfo.setOfferLoan(BigDecimal.valueOf(0));
					naturalCustInfo.setDelinqStatus(Constant.DELI_STATUS_N);
					naturalCustInfo.setStatus(Constant.CUST_STATUS_NORMAL);
					naturalCustInfo.setOper(user.getUserId());
					naturalCustInfo.setOperTime(new Date());
					this.naturalCustDao.save(naturalCustInfo);
				}else{
					custNo=naturalCustInfo.getCustNo();
					float loanAmount=naturalCustInfo.getLoanAmount()==null?0:naturalCustInfo.getLoanAmount().floatValue();
					loanAmount+=appSummary.getLoanLimit()==null?0:appSummary.getLoanLimit().floatValue();
					float remainAmount=naturalCustInfo.getRemainAmount()==null?0:naturalCustInfo.getRemainAmount().floatValue();
					remainAmount+=appSummary.getLoanLimit()==null?0:appSummary.getLoanLimit().floatValue();
					naturalCustInfo.setLoanAmount(BigDecimal.valueOf(loanAmount));
					naturalCustInfo.setRemainAmount(BigDecimal.valueOf(remainAmount));
					naturalCustInfo.setOper(user.getUserId());
					naturalCustInfo.setOperTime(new Date());
					this.naturalCustDao.updateSelective(naturalCustInfo);
				}
				
				
			} else if(Constant.APP_TYPE_CORP.equals(appType)){
				corpApp = this.corpAppDao.getById(appNo);
				corpCustInfo = findCorpCust(corpApp);
				if(corpCustInfo==null){
					corpCustInfo= new MlCorpCustInfo();
					custNo=getMainKeyService.getKey(Constant.KEY_TYPE_CUST_NO);
					corpCustInfo.setCustNo(custNo);
					corpCustInfo.setCompName(corpApp.getCompName());
					corpCustInfo.setRegAddr(corpApp.getRegAddr());
					corpCustInfo.setCompType(corpApp.getCompType());
					corpCustInfo.setEstablishDate(corpApp.getEstablishDate());
					corpCustInfo.setLegalPerson(corpApp.getLegalPerson());
					corpCustInfo.setLpIdType(corpApp.getLpIdType());
					corpCustInfo.setLpIdNo(corpApp.getLpIdNo());
					corpCustInfo.setLpNative(corpApp.getLpNative());
					corpCustInfo.setLpAddr(corpApp.getLpAddr());
					corpCustInfo.setBusiScope(corpApp.getBusiScope());
					corpCustInfo.setLastYearAssets(corpApp.getLastYearAssets());
					corpCustInfo.setLastYearLiabilities(corpApp.getLastYearLiabilities());
					corpCustInfo.setLastYearSalesAmount(corpApp.getLastYearSalesAmount());
					corpCustInfo.setLastYearProfit(corpApp.getLastYearProfit());
					corpCustInfo.setLastYearPayTax(corpApp.getLastYearPayTax());
					corpCustInfo.setAvgCashFlowInSixmth(corpApp.getAvgCashFlowInSixmth());
					corpCustInfo.setLoanAmount(appSummary.getLoanLimit());
					corpCustInfo.setRemainAmount(appSummary.getLoanLimit());
					corpCustInfo.setPayAmount(BigDecimal.valueOf(0));
					corpCustInfo.setOfferLoan(BigDecimal.valueOf(0));
					corpCustInfo.setDelinqStatus(Constant.DELI_STATUS_N);
					corpCustInfo.setStatus(Constant.CUST_STATUS_NORMAL);
					corpCustInfo.setOper(user.getUserId());
					corpCustInfo.setOperTime(new Date());
					this.corpCustDao.save(corpCustInfo);
				}else{
					custNo=corpCustInfo.getCustNo();
					float loanAmount=corpCustInfo.getLoanAmount()==null?0:corpCustInfo.getLoanAmount().floatValue();
					loanAmount+=appSummary.getLoanLimit()==null?0:appSummary.getLoanLimit().floatValue();
					float remainAmount=corpCustInfo.getRemainAmount()==null?0:corpCustInfo.getRemainAmount().floatValue();
					remainAmount+=appSummary.getLoanLimit()==null?0:corpApp.getLoanAmount().floatValue();
					corpCustInfo.setLoanAmount(BigDecimal.valueOf(loanAmount));
					corpCustInfo.setRemainAmount(BigDecimal.valueOf(remainAmount));
					corpCustInfo.setOper(user.getUserId());
					corpCustInfo.setOperTime(new Date());
					this.corpCustDao.updateSelective(corpCustInfo);
				}
			}
			
			//保存贷款信息
			loanInfo=new MlLoanInfo();
			loanInfo.setLoanId(KeyGenerator.getNextKey("ML_LOAN_INFO", "LOAN_ID"));
			loanInfo.setCustNo(custNo);
			loanInfo.setAppNo(appSummary.getAppNo());
			loanInfo.setLoanAmount(appSummary.getLoanLimit());
			loanInfo.setLoanRate(appSummary.getLoanRate());
			loanInfo.setOfferLoan(BigDecimal.valueOf(0));
			loanInfo.setPayAmount(BigDecimal.valueOf(0));
			loanInfo.setRemainAmount(appSummary.getLoanLimit());
			loanInfo.setCurrDelinquency(0);
			loanInfo.setStatus(Constant.LOAN_STATUS_START);
			loanInfo.setOper(user.getUserId());
			loanInfo.setOperTime(new Date());
			this.loanDao.save(loanInfo);
			
			result=true;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}

	/**
	 * 在客户表中查找客户信息-自然人
	 * @param naturalApp
	 * @return
	 */
	private MlNaturalCustInfo findNaturalCust(MlNaturalApp naturalApp){
		MlNaturalCustInfo naturalCustInfo=null;
		
		try{
			MlNaturalCustInfoExample example=new MlNaturalCustInfoExample();
			example.createCriteria().andIdTypeEqualTo(naturalApp.getIdType()).andIdNoEqualTo(naturalApp.getIdNo());
			naturalCustInfo=this.naturalCustDao.findOne(example);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return naturalCustInfo;
	}
	
	/**
	 * 在客户表中查找客户信息-公司
	 * @param naturalApp
	 * @return
	 */
	private MlCorpCustInfo findCorpCust(MlCorpApp corpApp){
		MlCorpCustInfo corpCustInfo = null;
		
		try{
			MlCorpCustInfoExample example=new MlCorpCustInfoExample();
			example.createCriteria().andCompNameEqualTo(corpApp.getCompName());
			corpCustInfo=this.corpCustDao.findOne(example);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return corpCustInfo;
	}

	@Override
	public PageList<UnionLoanInfo> getLoanPageList(Page page, UnionLoanInfo unionLoanInfo) {
		return null;
	}
}
