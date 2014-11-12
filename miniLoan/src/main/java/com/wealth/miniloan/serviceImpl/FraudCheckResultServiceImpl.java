package com.wealth.miniloan.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.dao.FraudCheckResultDao;
import com.wealth.miniloan.dao.NameListDao;
import com.wealth.miniloan.dao.NaturalAppDao;
import com.wealth.miniloan.dao.NaturalCreditDao;
import com.wealth.miniloan.entity.MlFraudCheckResult;
import com.wealth.miniloan.entity.MlFraudCheckResultExample;
import com.wealth.miniloan.entity.MlNameList;
import com.wealth.miniloan.entity.MlNameListExample;
import com.wealth.miniloan.entity.MlNaturalApp;
import com.wealth.miniloan.entity.MlNaturalAppExample;
import com.wealth.miniloan.entity.MlNaturalCredit;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.FraudCheckResultServiceI;
import com.wealth.miniloan.utils.Constant;
import com.wealth.miniloan.utils.FraudCheckUtil;
import com.wealth.miniloan.utils.IdCardValidator;
import com.wealth.miniloan.utils.key.KeyGenerator;

@Service
public class FraudCheckResultServiceImpl implements FraudCheckResultServiceI {
	private FraudCheckResultDao fraudCheckResultDao;
	private NaturalAppDao naturalAppDao;
	private NameListDao nameListDao;
	private NaturalCreditDao naturalCreditDao;

	@Autowired
	public void setNaturalCreditDao(NaturalCreditDao naturalCreditDao) {
		this.naturalCreditDao = naturalCreditDao;
	}

	@Autowired
	public void setNameListDao(NameListDao nameListDao) {
		this.nameListDao = nameListDao;
	}

	@Autowired
	public void setNaturalAppDao(NaturalAppDao naturalAppDao) {
		this.naturalAppDao = naturalAppDao;
	}

	@Autowired
	public void setFraudCheckResultDao(FraudCheckResultDao fraudCheckResultDao) {
		this.fraudCheckResultDao = fraudCheckResultDao;
	}

	@Override
	public PageList<MlFraudCheckResult> getPageList(Page paramPage, MlFraudCheckResult obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(MlFraudCheckResult obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(MlFraudCheckResult obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MlFraudCheckResult getByPriKey(MlFraudCheckResult obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(String ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getByExample(Object obj) {
		MlFraudCheckResultExample example = new MlFraudCheckResultExample();
		example.createCriteria().andAppNoEqualTo((String) obj);
		return this.fraudCheckResultDao.findAll(example);
//		if (list != null && list.size() > 0) {
//			return list;
//		} else {
//			dealFraudCheck((String) obj);
//			return this.fraudCheckResultDao.findAll(example);
//		}

	}
	
	@Override
	public void deleteFraudCheck(String appNo){
		MlFraudCheckResultExample example = new MlFraudCheckResultExample();
		example.createCriteria().andAppNoEqualTo(appNo);
		this.fraudCheckResultDao.deleteByExample(example);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void dealFraudCheck(String appNo) {
		MlNaturalApp naturalApp = this.naturalAppDao.getById(appNo);
		MlNaturalAppExample example = null;
//		com.wealth.miniloan.entity.MlNaturalAppExample.Criteria c = example.createCriteria();
		List<MlNaturalApp> temp = null;
		String result = Constant.NO;
		try {

			example = new MlNaturalAppExample();
			example.createCriteria().andIdTypeEqualTo(naturalApp.getIdType()).andIdNoEqualTo(naturalApp.getIdNo())
					.andAppNoNotEqualTo(appNo);
			temp = this.naturalAppDao.findAll(example);
			if (temp != null && temp.size() > 0) {
				result = Constant.YES;
			}
			saveFraudCheckResult(appNo, FraudCheckUtil.ITEM_CODE_101, result);
			result = Constant.NO;

			example = new MlNaturalAppExample();
			example.createCriteria().andMobileEqualTo(naturalApp.getMobile()).andAppNoNotEqualTo(appNo);
			temp = this.naturalAppDao.findAll(example);
			if (temp != null && temp.size() > 0) {
				result = Constant.YES;
			}
			saveFraudCheckResult(appNo, FraudCheckUtil.ITEM_CODE_102, result);
			result = Constant.NO;

			example = new MlNaturalAppExample();
			example.createCriteria().andHomePhoneEqualTo(naturalApp.getHomePhone()).andAppNoNotEqualTo(appNo);
			temp = this.naturalAppDao.findAll(example);
			if (temp != null && temp.size() > 0) {
				result = Constant.YES;
			}
			saveFraudCheckResult(appNo, FraudCheckUtil.ITEM_CODE_103, result);
			result = Constant.NO;

			example = new MlNaturalAppExample();
			example.createCriteria().andEmailEqualTo(naturalApp.getEmail()).andAppNoNotEqualTo(appNo);
			temp = this.naturalAppDao.findAll(example);
			if (temp != null && temp.size() > 0) {
				result = Constant.YES;
			}
			saveFraudCheckResult(appNo, FraudCheckUtil.ITEM_CODE_104, result);
			result = Constant.NO;

			example = new MlNaturalAppExample();
			example.createCriteria().andCompAddrEqualTo(naturalApp.getCompAddr()).andAppNoNotEqualTo(appNo);
			temp = this.naturalAppDao.findAll(example);
			if (temp != null && temp.size() > 0) {
				result = Constant.YES;
			}
			saveFraudCheckResult(appNo, FraudCheckUtil.ITEM_CODE_105, result);
			result = Constant.NO;

			example = new MlNaturalAppExample();
			example.createCriteria().andHomeAddrEqualTo(naturalApp.getHomeAddr()).andAppNoNotEqualTo(appNo);
			temp = this.naturalAppDao.findAll(example);
			if (temp != null && temp.size() > 0) {
				result = Constant.YES;
			}
			saveFraudCheckResult(appNo, FraudCheckUtil.ITEM_CODE_106, result);
			result = Constant.NO;

			Date birthDay = naturalApp.getBirthday();
			String birthDayStr = "";
			if (birthDay != null) {
				birthDayStr = new SimpleDateFormat("yyyy-MM-dd").format(birthDay);
			}
			if (!birthDayStr.equals(IdCardValidator.getBirthDayFromID(naturalApp.getIdNo()))) {
				result = Constant.YES;
			}
			saveFraudCheckResult(appNo, FraudCheckUtil.ITEM_CODE_201, result);
			result = Constant.NO;

			if (naturalApp.getGender() != null
					&& !naturalApp.getGender().equals(IdCardValidator.getSexFromID(naturalApp.getIdNo()))) {
				result = Constant.YES;
			}
			saveFraudCheckResult(appNo, FraudCheckUtil.ITEM_CODE_202, result);
			result = Constant.NO;

			if (naturalApp.getHomePhone() != null && naturalApp.getHomePhone().equals(naturalApp.getCompPhone())) {
				result = Constant.YES;
			}
			saveFraudCheckResult(appNo, FraudCheckUtil.ITEM_CODE_203, result);
			result = Constant.NO;

			int liveYears = 0;
			if (naturalApp.getLiveStartTime() != null) {
				liveYears = new Date().getYear() - naturalApp.getLiveStartTime().getYear();
				if (naturalApp.getAge() != null && naturalApp.getAge() < liveYears) {
					result = Constant.YES;
				}
			}
			saveFraudCheckResult(appNo, FraudCheckUtil.ITEM_CODE_204, result);
			result = Constant.NO;

			String educationLvl = "";
			if (naturalApp.getEducationLvl() != null) {
				educationLvl = naturalApp.getEducationLvl();
				if (Constant.EDUCATION_LVL_DOCTOR.equals(educationLvl)) {
					if (naturalApp.getAge() != null && naturalApp.getAge() < 22) {
						result = Constant.YES;
					}
				}
				if (Constant.EDUCATION_LVL_MASTER.equals(educationLvl)) {
					if (naturalApp.getAge() != null && naturalApp.getAge() < 19) {
						result = Constant.YES;
					}
				}
				if (Constant.EDUCATION_LVL_REGULARCOLLEGE.equals(educationLvl)) {
					if (naturalApp.getAge() != null && naturalApp.getAge() < 18) {
						result = Constant.YES;
					}
				}
			}
			saveFraudCheckResult(appNo, FraudCheckUtil.ITEM_CODE_205, result);
			result = Constant.NO;

			int workYears = 0;
			if (naturalApp.getWorkYears() != null) {
				workYears = naturalApp.getWorkYears().intValue();
			}
			if (naturalApp.getAge() != null && naturalApp.getAge() - workYears < 16) {
				result = Constant.YES;
			}
			saveFraudCheckResult(appNo, FraudCheckUtil.ITEM_CODE_206, result);
			result = Constant.NO;

			int currJobWorkYears = 0;
			if (naturalApp.getCurrJobStDate() != null) {
				currJobWorkYears = new Date().getYear() - naturalApp.getCurrJobStDate().getYear();
			}
			int yearIncome = naturalApp.getMonthIncome() == null ? 0 : naturalApp.getMonthIncome().intValue() * 12;
			if (currJobWorkYears <= 2 && yearIncome > 100000) {
				result = Constant.YES;
			}
			if (currJobWorkYears <= 5 && yearIncome > 200000) {
				result = Constant.YES;
			}
			if (currJobWorkYears <= 10 && yearIncome > 500000) {
				result = Constant.YES;
			}
			if (currJobWorkYears <= 20 && yearIncome > 750000) {
				result = Constant.YES;
			}
			if (yearIncome > 100000) {
				result = Constant.YES;
			}
			saveFraudCheckResult(appNo, FraudCheckUtil.ITEM_CODE_207, result);
			result = Constant.NO;

			String idNo = naturalApp.getIdNo();
			if (idNo != null) {
				if (!IdCardValidator.isValidatedAllIdcard(idNo)) {
					result = Constant.YES;
				}
			}
			saveFraudCheckResult(appNo, FraudCheckUtil.ITEM_CODE_301, result);
			result = Constant.NO;

			List<MlNameList> nList = null;
			MlNameListExample nlExmaple = new MlNameListExample();
			nlExmaple.createCriteria().andPhoneNumberEqualTo(naturalApp.getMobile()).andNameTypeEqualTo(Constant.NAME_TYPE_BLACK);
			nList = this.nameListDao.findAll(nlExmaple);
			if (nList != null && nList.size() > 0) {
				result = Constant.YES;
			}
			saveFraudCheckResult(appNo, FraudCheckUtil.ITEM_CODE_302, result);
			result = Constant.NO;

			nlExmaple = new MlNameListExample();
			nlExmaple.createCriteria().andEmailEqualTo(naturalApp.getEmail()).andNameTypeEqualTo(Constant.NAME_TYPE_BLACK);
			nList = this.nameListDao.findAll(nlExmaple);
			if (nList != null && nList.size() > 0) {
				result = Constant.YES;
			}
			saveFraudCheckResult(appNo, FraudCheckUtil.ITEM_CODE_303, result);
			result = Constant.NO;

			nlExmaple = new MlNameListExample();
			nlExmaple.createCriteria().andIdTypeEqualTo(naturalApp.getIdType()).andIdNoEqualTo(naturalApp.getIdNo())
					.andNameEqualTo(naturalApp.getName()).andNameTypeEqualTo(Constant.NAME_TYPE_BLACK);
			nList = this.nameListDao.findAll(nlExmaple);
			if (nList != null && nList.size() > 0) {
				result = Constant.YES;
			}
			saveFraudCheckResult(appNo, FraudCheckUtil.ITEM_CODE_304, result);
			result = Constant.NO;

			if (naturalApp.getAge() != null) {
				if (naturalApp.getAge() < 18 || naturalApp.getAge() > 65) {
					result = Constant.YES;
				}
			}
			saveFraudCheckResult(appNo, FraudCheckUtil.ITEM_CODE_401, result);
			result = Constant.NO;

			MlNaturalCredit credit = this.naturalCreditDao.getById(idNo);
			if (credit != null && credit.getLoanCurrDeliq() != null && credit.getLoanCurrDeliq() > 3) {
				result = Constant.YES;
			}
			saveFraudCheckResult(appNo, FraudCheckUtil.ITEM_CODE_501, result);
			result = Constant.NO;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveFraudCheckResult(String appNo, String itemCode, String result) {
		MlFraudCheckResult fcr = new MlFraudCheckResult();
		fcr.setCheckId(KeyGenerator.getNextKey("ML_FRAUD_CHECK_RESULT", "CHECK_ID"));
		fcr.setAppNo(appNo);
		fcr.setAppType(Constant.APP_TYPE_NATURAL);
		fcr.setItemType(FraudCheckUtil.itemsMap.get(itemCode)[0]);
		fcr.setItemCode(itemCode);
		fcr.setItemDesc(FraudCheckUtil.itemsMap.get(itemCode)[1]);
		fcr.setMemo(FraudCheckUtil.itemsMap.get(itemCode)[2]);
		fcr.setCheckResult(result);
		fcr.setOpTime(new Date());

		this.fraudCheckResultDao.save(fcr);
	}

}
