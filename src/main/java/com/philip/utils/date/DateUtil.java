package com.philip.utils.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	/**
	 * 得到本周第一天
	 * 
	 * @return date
	 */
	public static Date getFirstDateThisWeek() {
		Calendar cal = Calendar.getInstance();
		int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 2;
		cal.add(Calendar.DATE, -day_of_week);
		return cal.getTime();
	}
	
	/**
	 * desc：Date时间转换为格式化后的Date时间
	 * 
	 * @param date
	 *            需要转换的date
	 * @param format
	 *            格式字符串
	 * @return 返回按照格式转化后的Date 如：DateUtil.getDate(new Date(),"yyyy-MM-dd")
	 */
	public static Date getDate(Date date, String format) throws ParseException {
		if (date == null)
			return null;
		SimpleDateFormat dateformatter = new SimpleDateFormat(format);
		return dateformatter.parse(dateformatter.format(date));
	}
	
	/**
	 * 获取周一的零点
	 * @return
	 * @throws ParseException
	 */
	public static Date getFirstDayZeroOfWeek() throws ParseException {
		Date thisMonday = DateUtil.getFirstDateThisWeek();
		Date zeroMonday = DateUtil.getDate(thisMonday, "yyyy-MM-dd");
		return zeroMonday;
	}
	
	/**
	 * 根据指定时间获取
	 * @param baseDate
	 * @return
	 */
	public static Date getMondayFirstOfWeek(Date baseDate){
		int dayofweek = DateUtil.getDayOfWeekForDate(baseDate);
		dayofweek=dayofweek==1?dayofweek+7:dayofweek;
		return DateUtil.getDateAfterDays(baseDate, 2-dayofweek);
	}
	
	/**
	 * 获取指定日期的星期序列（星期日开始）
	 * @param day
	 * @return
	 */
	public static int getDayOfWeekForDate(Date day) {
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTime(day);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}
	
	/**
	 * desc：获得格式化时间，时间为距几天天数
	 * 
	 * @param date
	 *            转换前的时间
	 * @param add_days
	 *            天数
	 * @return 返回增加天数之后的Date 如：DateUtil.getDateAfterDays(new Date(),-1) 一天前的时间
	 */
	public static Date getDateAfterDays(Date date, int add_days) {
		Calendar time = Calendar.getInstance();
		time.setTime(date);
		time.add(Calendar.DATE, add_days);
		return time.getTime();
	}

}
