package com.wealth.miniloan.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CommonService extends BaseService<Object> {
	public static final String flag = "1";

	public String getKey(String date,String subject) {
		String sql = "SELECT KEY_NO FROM ML_MAIN_KEY WHERE KEY_NO LIKE '" + date + "%' and KEY_TYPE='"+subject+"'";
		List<Map<String, Object>> list = super.queryForList(sql);
		String suffix = "0000001";
		String key = "";
		if (list != null && list.size() > 0) {
			Long l0 = Long.valueOf(list.get(0).get("KEY_NO").toString());
			key = String.valueOf(l0 + 1);
		} else {
			key = date + suffix;
		}

		String updateSql = "UPDATE ML_MAIN_KEY SET KEY_NO = '" + key + "' where KEY_TYPE='"+subject+"'";
		super.update(updateSql);

		return key;
	}
}
