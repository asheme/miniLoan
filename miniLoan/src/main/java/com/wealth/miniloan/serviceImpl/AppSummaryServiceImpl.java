package com.wealth.miniloan.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.dao.AppCheckResultDao;
import com.wealth.miniloan.dao.AppSummaryDao;
import com.wealth.miniloan.entity.AppSummaryExtend;
import com.wealth.miniloan.entity.MlAppSummary;
import com.wealth.miniloan.entity.MlAppSummaryExample;
import com.wealth.miniloan.entity.MlRole;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.entity.UnionAppExample;
import com.wealth.miniloan.entity.UnionLoanApp;
import com.wealth.miniloan.entity.User;
import com.wealth.miniloan.service.AppSummaryServiceI;
import com.wealth.miniloan.utils.Constant;
import com.wealth.miniloan.utils.SysUtil;

@Service
public class AppSummaryServiceImpl implements AppSummaryServiceI {
	private AppSummaryDao appSummaryDao;
	private AppCheckResultDao appCheckResultDao;
	private final String _ORDER_ATTRS = "appNo,appType,name,addr,loanAppAmount,appTime,status,currApproveLvl,enterTime,previousStep,currStep,nextStep,handler,finishTime,manualResult,loanLimit,loanRate,reasonCode,reasonDesc,currUser,operTime";
	private final String _ORDER_FIELDS = "APP_NO,APP_TYPE,NAME,ADDR,LOAN_APP_AMOUNT,APP_TIME,STATUS,CURR_APPROVE_LVL,ENTER_TIME,PREVIOUS_STEP,CURR_STEP,NEXT_STEP,HANDLER,FINISH_TIME,MANUAL_RESULT,LOAN_LIMIT,LOAN_RATE,REASON_CODE,REASON_DESC,CURR_USER,OPER_TIME";

	@Autowired
	public void setAppSummaryDao(AppSummaryDao appSummaryDao) {
		this.appSummaryDao = appSummaryDao;
	}

	@Autowired
	public void setAppCheckResultDao(AppCheckResultDao appCheckResultDao) {
		this.appCheckResultDao = appCheckResultDao;
	}

	@Override
	public PageList<UnionLoanApp> getLoanAppPageList(Page page, UnionLoanApp unionLoanApp, User user) {
		UnionAppExample example=new UnionAppExample();
		UnionAppExample.Criteria criteria = example.createCriteria();
		String appType=unionLoanApp.getAppType();
		String appNo = unionLoanApp.getAppNo();
		String name = unionLoanApp.getName();
		String addr = unionLoanApp.getAddr();
		if (appType != null && !"".equals(appType)) {
			criteria.andAppTypeEqualTo(appType);
		}
		if (appNo != null && !"".equals(appNo)) {
			criteria.andAppNoLike("%" + appNo + "%");
		}
		if (name != null && !"".equals(name)) {
			criteria.andNameLike("%" + name + "%");
		}
		if (addr != null && !"".equals(addr)) {
			criteria.andAddrLike("%" + addr + "%");
		}
		criteria.andCurrStepEqualTo(unionLoanApp.getCurrStep());
		if(Constant.STEP_APP_APPR.equals(unionLoanApp.getCurrStep())){
			Integer approvalLevel = getApprovalLevel(user);
			if(approvalLevel != null){
				criteria.andCurrApproveLvlEqualTo(approvalLevel);
			}
		}
		criteria.andStatusNotIn(new ArrayList<String>(){{add(Constant.APP_STATUS_REJECT);add(Constant.APP_STATUS_APPROVE);}});
		String order = SysUtil.dealOrderby(page, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!order.equals("")) {
			example.setOrderByClause(order);
		}

		return this.appSummaryDao.queryLoanAppPageList(SysUtil.convertPage(page),example);
		
	}
	
	@Override
	public PageList<UnionLoanApp> queryLoanAppPageList(Page page,
			UnionLoanApp unionLoanApp) {
		UnionAppExample example=new UnionAppExample();
		UnionAppExample.Criteria criteria = example.createCriteria();
		String appType=unionLoanApp.getAppType();
		String appNo = unionLoanApp.getAppNo();
		String name = unionLoanApp.getName();
		String addr = unionLoanApp.getAddr();
		if (appType != null && !"".equals(appType)) {
			criteria.andAppTypeEqualTo(appType);
		}
		if (appNo != null && !"".equals(appNo)) {
			criteria.andAppNoLike("%" + appNo + "%");
		}
		if (name != null && !"".equals(name)) {
			criteria.andNameLike("%" + name + "%");
		}
		if (addr != null && !"".equals(addr)) {
			criteria.andAddrLike("%" + addr + "%");
		}
		String order = SysUtil.dealOrderby(page, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!order.equals("")) {
			example.setOrderByClause(order);
		}

		return this.appSummaryDao.queryLoanAppPageList(SysUtil.convertPage(page),example);
	}

	@Override
	public int create(MlAppSummary obj) {
		return this.appSummaryDao.save(obj);
	}

	@Override
	public int update(MlAppSummary obj) {
		return this.appSummaryDao.update(obj);
	}

	@Override
	public int delete(String ids) {
		String[] idArray = ids.split(",");
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < idArray.length; i++) {
			list.add(idArray[i]);
		}
		MlAppSummaryExample example = new MlAppSummaryExample();
		example.createCriteria().andAppNoIn(list);
		return this.appSummaryDao.deleteByExample(example);
	}

	@Override
	public MlAppSummary getByPriKey(MlAppSummary obj) {
		return (MlAppSummary) this.appSummaryDao.getById(obj.getAppNo());
	}

	@Override
	public Object getByExample(Object obj) {
		return this.appCheckResultDao.findOne(obj);
	}

	@Override
	public PageList<AppSummaryExtend> getAllPageList(Page paramPage, AppSummaryExtend appSummary) {
		String order_attrs = "appNo,appType,idNo,name,enterTime,status";
		String order_fields_0 = "APP_NO,APP_TYPE, , ,ENTER_TIME,STATUS";
		String order_fields_1 = " , ,ID_NO,NAME, , ";
		String order_fields_2 = " , ,LP_ID_NO,COMP_NAME, , ";

		String order = "";
		String order0 = SysUtil.dealOrderby(paramPage, order_attrs, order_fields_0);
		String order1 = SysUtil.dealOrderby(paramPage, order_attrs, order_fields_1);
		String order2 = SysUtil.dealOrderby(paramPage, order_attrs, order_fields_2);

		if (!order0.equals("")) {
			order += order0;
		}

		HashMap<String, String> map = new HashMap<String, String>();
		if (StringUtils.isNotEmpty(appSummary.getAppType())) {
			map.put("appType", appSummary.getAppType());
			if (Constant.APP_TYPE_NATURAL.equals(appSummary.getAppType())) {
				map.put("idNo", appSummary.getNaturalApp().getIdNo());
				map.put("name", appSummary.getNaturalApp().getName());
				if (!order1.equals("")) {
					if (!order.equals("")) {
						order += " , " + order1;
					} else {
						order += order1;
					}
				}
			} else {
				map.put("lpIdNo", appSummary.getCorpApp().getLpIdNo());
				map.put("compName", appSummary.getCorpApp().getCompName());
				if (!order2.equals("")) {
					if (!order.equals("")) {
						order += " , " + order2;
					} else {
						order += order1;
					}
				}
			}
		}
		if (StringUtils.isNotEmpty(appSummary.getAppNo())) {
			map.put("appNo", appSummary.getAppNo());
		}

		if (StringUtils.isNotEmpty(appSummary.getCurrStep())) {
			map.put("currStep", appSummary.getCurrStep());
		}

		map.put("order", order);
		return this.appSummaryDao.getPageList(SysUtil.convertPage(paramPage), map);
	}
	
	public Integer getApprovalLevel (User user){
		MlRole currRole = user.getCurrRole();
		Integer currApprovalLevel = currRole.getApproveLvl();
		return currApprovalLevel;
	}

}
