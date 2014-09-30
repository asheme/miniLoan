package com.wealth.miniloan.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	public static Date parseDate(String date, DateFormat format) {
		try {
			return format.parse(date);
		} catch (Exception e) {
			return null;
		}
	}

	public static Date parseDate(String date, String format) {
		DateFormat df = new SimpleDateFormat(format);
		try {
			return df.parse(date);
		} catch (Exception e) {
			return null;
		}
	}

	public static Date parseDate(String date) {
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		try {
			return df.parse(date);
		} catch (Exception e) {
			return null;
		}
	}

	public static String getDTStr() {
		return getDTStr("yyyy-MM-dd");
	}

	public static String getTimeStr() {
		return getDTStr("yyyy-MM-dd HH:mm:ss");
	}

	public static String getDTStr(String format) {
		SimpleDateFormat sf = new SimpleDateFormat(format);
		return sf.format(new Date());
	}

	public static String getDTStr(String format, Date date) {
		SimpleDateFormat sf = new SimpleDateFormat(format);
		return sf.format(date);
	}

	public static java.sql.Date getNow() {
		return new java.sql.Date(System.currentTimeMillis());
	}

	public static boolean isLastDayOfMonth(String dateStr) {
		Date date = parseDate(dateStr);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DATE, (cal.get(Calendar.DATE) + 1));
		if (cal.get(Calendar.DAY_OF_MONTH) == 1) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isSpecificDayInMonth(String day){
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		if(day !=null && day.equals(sdf.format(new Date()))){
			return true;
		} else {
			return false;
		}
	}
	
	public static String getBeforeDay(String dateStr) {
		Date date = parseDate(dateStr);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DATE, (cal.get(Calendar.DATE) - 1));
		return getDTStr("yyyyMMdd", cal.getTime());
	}

	public static String getNextDay(String dateStr) {
		Date date = parseDate(dateStr);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DATE, (cal.get(Calendar.DATE) + 1));
		return getDTStr("yyyyMMdd", cal.getTime());
	}
	
	//add by taocx start 20121031
	/**
	 * 得到参数currDate所在周的周一日期
	 * @param currDate
	 * @return
	 */
	public static String getFirstDayForWeek(String currDate) {
		Date curr = getDateFromStr(currDate);
		int day = curr.getDay();
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(curr);
		if (day == 0)
			calendar.add(Calendar.DAY_OF_YEAR, -6);
		else
			calendar.add(Calendar.DAY_OF_YEAR, -(day - 1));
		return f.format(calendar.getTime());
	}

	/**
	 * 得到参数date所在季度的第一天日期
	 * @param date
	 * @return
	 */
	public static String getFirstDayForQuarter(String date) {
		Date d = getCurrentQuarterStartTime(date);
		return getStrFromDate(d, null);
	}

	/**
	 * 得到参数date所在月份的第一天日期
	 * @param date
	 * @return
	 */
	public static String getFirstDayForMonth(String date) {
		return date.substring(0, 6) + "01";
	}
	
	/**
	 * 得到参数date所在年份的第一天日期
	 * @param date
	 * @return
	 */
	public static String getFirstDayForYear(String date) {
		return date.substring(0, 4) + "0101";
	}


	private static Date getCurrentQuarterStartTime(String currDate) {
		Calendar c = Calendar.getInstance();
		c.setTime(getDateFromStr(currDate));
		int currentMonth = c.get(Calendar.MONTH) + 1;
		Date now = null;
		try {
			if (currentMonth >= 1 && currentMonth <= 3)
				c.set(Calendar.MONTH, 0);
			else if (currentMonth >= 4 && currentMonth <= 6)
				c.set(Calendar.MONTH, 3);
			else if (currentMonth >= 7 && currentMonth <= 9)
				c.set(Calendar.MONTH, 6);
			else if (currentMonth >= 10 && currentMonth <= 12)
				c.set(Calendar.MONTH, 9);
			c.set(Calendar.DATE, 1);
			now = c.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * String(yyyyMMdd)类型 -> Date类型
	 * @param dateStr
	 * @return
	 */
	public static Date getDateFromStr(String dateStr) {
		DateFormat format = new SimpleDateFormat("yyyyMMdd");
		try {
			return format.parse(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
			return new Date();
		}
	}

	/**
	 * Date类型 -> String(yyyyMMdd)类型
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getStrFromDate(Date date, DateFormat format) {
		String result = "";
		if (date != null) {
			if (format == null) {
				format = new SimpleDateFormat("yyyyMMdd");
			}
			result = format.format(date);
		}
		return result;
	}
	
    /**
     * 得到17位当前时间-yyyyMMddHHmmssSSS
     * 
     * @return
     */
	public static String getCurrFullDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return formatter.format(date);
	}
	
	//add by taocx end 20121031
}
