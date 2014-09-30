package com.wealth.miniloan.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wealth.miniloan.utils.DateUtils;

@Service
public class GetAppNoService {

	private CommonService commonService;

	@Autowired
	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}
	
	public String getAppNo(){
		String date = DateUtils.getDTStr("yyyyMMdd");
		String appNo = "";
		synchronized (CommonService.flag){
			appNo = commonService.getAppNo(date);
		}
		
		return appNo;
	}
	
}
