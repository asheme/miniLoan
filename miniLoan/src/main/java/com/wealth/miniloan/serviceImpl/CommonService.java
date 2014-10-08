package com.wealth.miniloan.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CommonService extends BaseService<Object> {
	public static final String flag = "1";

	public String getAppNo(String date) {
		String sql = "SELECT APP_NO FROM ML_APP_NO WHERE APP_NO LIKE '" + date + "%'";
		List<Map<String, Object>> list = super.queryForList(sql);
		String prefix = "0000001";
		String appNo = "";
		if (list != null && list.size() > 0) {
			Long l0 = Long.valueOf(list.get(0).get("APP_NO").toString());
			appNo = String.valueOf(l0 + 1);
		} else {
			appNo = date + prefix;
		}

		String updateSql = "UPDATE ML_APP_NO SET APP_NO = '" + appNo + "'";
		super.update(updateSql);

		return appNo;
	}
}
