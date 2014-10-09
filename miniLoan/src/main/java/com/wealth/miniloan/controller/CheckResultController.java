package com.wealth.miniloan.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.wealth.miniloan.entity.MlAppCheckResult;
import com.wealth.miniloan.entity.MlAppCheckResultExample;
import com.wealth.miniloan.entity.MlAppCheckResultExample.Criteria;
import com.wealth.miniloan.serviceImpl.CheckResultServiceImpl;
import com.wealth.miniloan.utils.key.KeyGenerator;

@Controller
@RequestMapping(value = "/app/checkresult")
@SessionAttributes("user")
public class CheckResultController extends BaseController {
	private CheckResultServiceImpl checkResultService = null;

	@Autowired
	public void setCheckResultService(CheckResultServiceImpl checkResultService) {
		this.checkResultService = checkResultService;
	}

	/*
	 * 表单提交日期绑定
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value = "getCheckResult")
	@ResponseBody
	public MlAppCheckResult getCheckResult(String appNo, String checkType) {
		MlAppCheckResultExample example = new MlAppCheckResultExample();
		Criteria c = example.createCriteria();
		c.andAppNoEqualTo(appNo);
		if (StringUtils.isNotEmpty(checkType)) {
			c.andCheckTypeEqualTo(checkType);
		}
		MlAppCheckResult cr = (MlAppCheckResult) this.checkResultService.getByExample(example);

		return cr;
	}

	@RequestMapping(value = "saveCheckResult")
	@ResponseBody
	public Map<String, Object> saveCheckResult(String appNo, MlAppCheckResult checkResult) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if (checkResult.getCheckId() == null) {
				MlAppCheckResult ar = new MlAppCheckResult();
				ar.setAppNo(appNo);
				ar.setCheckId(KeyGenerator.getNextKey("ML_APP_CHECK_RESULT", "CHECK_ID"));
				ar.setCheckResult(checkResult.getCheckResult());
				ar.setCheckType(checkResult.getCheckType());
				ar.setCheckObj(checkResult.getCheckObj());
				ar.setCheckDesc(checkResult.getCheckDesc());
				this.checkResultService.create(ar);
			} else {
				this.checkResultService.update(checkResult);
			}
			result.put("success", true);
			result.put("msg", "审核信息保存成功！");

		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "服务器端出现异常！");
		}

		return result;
	}

	@RequestMapping(value = "getCheckResultList")
	public List<MlAppCheckResult> getCheckResultList(String appNo, String checkType) {
		MlAppCheckResultExample example = new MlAppCheckResultExample();
		Criteria c = example.createCriteria();
		c.andAppNoEqualTo(appNo);
		if (StringUtils.isNotEmpty(checkType)) {
			c.andCheckTypeEqualTo(checkType);
		}
		List<MlAppCheckResult> crList = this.checkResultService.getAllList(example);

		return crList;
	}
}
