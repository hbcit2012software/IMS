/**
* Copyright(C) 2014
*
* 模块名称：     
* 子模块名称：   
*
* 备注：
*
* 修改历史：
* 2014-6-13	1.0		李振杰		新建
*/
package cn.edu.hbcit.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
/**
 * 校历类
 * 简要说明:处理校历时间
 * @author 李振杰
 * @version 1.00  2014-6-13下午06:50:22	新建
 */

public class CalenderUtil {

	/**
	 * 返回当前时间年
	 * 返回当前时间月
	 * 返回该月的总天数
	 * 返回这个月一号所对应星期几
	 * @return
	 */
	public static LinkedHashMap<String, Integer> getYearMonthDaysWeek(){
		Calendar ca = Calendar.getInstance();
		int year = ca.get(Calendar.YEAR);// 得到当前时间年
		int month = ca.get(Calendar.MONTH);// 得到当前时间月
		ca.set(Calendar.YEAR, year);// 设置时间是当前年
		ca.set(Calendar.MONTH, month);// 设置时间是当前月
		ca.set(Calendar.DAY_OF_MONTH, 1);// 设置每个月从一号开始
		int monthDays = ca.getActualMaximum(Calendar.DAY_OF_MONTH);// 得到该月的总天数
		// 得到这个月一号在星期几
		int week = ca.get(Calendar.DAY_OF_WEEK)-1;
		LinkedHashMap<String, Integer> map=new LinkedHashMap<String, Integer>();
		map.put("year", year);
		map.put("month", month+1);
		map.put("day", monthDays);
		map.put("week", week);
		return map;
	}
	/**
	 * 返回学年和返回上半学期和下班学期
	 * semester 学期
	 * schoolyear 学年
	 * @param date
	 * @return
	 */
	public static String  getSemesterschoolyear() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd",
				Locale.CHINESE);
	//1、首先获得当前时间
		Calendar caNow=Calendar.getInstance();
		//当前时间的年
		int year =caNow.get(Calendar.YEAR);
		Calendar c2=Calendar.getInstance();
		c2.set(year, 2,1);
		Calendar c3=Calendar.getInstance();
		c3.set(year, 7,1);
		if(caNow.after(c2)&&caNow.before(c3))
		{
			int yea=year-1;
			return yea+"\t-\t"+year+"学年"+"\t"+"第二学期";
		}
	    c2.set(year+1, 0,1);
	    if(caNow.after(c3)&&caNow.before(c2))
	    {
	    	int lastYear=year+1;
			return year+"\t-\t"+lastYear+"学年"+"\t"+"第一学期";
	    }else 
	    	return null;
		
	
	}
	/**
	 * 设置开学时间 ，返回第几周
	 * 传入开学日期
	 * @param date
	 * @return
	 */
	public static int getWeekend(String date){
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd",
					Locale.CHINESE);
			// 开始时间
			Calendar begin = Calendar.getInstance();
			begin.setTime(format.parse(date));
			Calendar now = Calendar.getInstance();
			// 如果输入的时间在当前时间之前
			if (begin.before(now)) {
				int day = getIntervalDaysOfExitDate(begin.getTime(),
						now.getTime());
				int weekdays = (int) (day / 7.0) + 1;
				//return "第" + d + "周";
				return weekdays;
			} else
			// 如果输入的时间在开始时间之后
			if (begin.after(now)) {
				int day = getIntervalDaysOfExitDate(now.getTime(),
						begin.getTime());
				int weekdays = (int) (day / 7.0);
				return (Integer) null;
			} else {
				return (Integer) null;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
		/**
		 *  设置开学时间 ，返回第几周
		 * 
		 * @param date  传入开学日期
		 * @throws ParseException
		 */
		public static String getWeekends(String date) {
		return 	"第"+getWeekend(date)+"周";
		}
	/**
	 * 日期相减计算方法
	 * 
	 * @param exitDateFrom开始时间
	 *            （小）
	 * @param exitDateTo结束时间
	 *            （大）
	 * @return
	 */
	@SuppressWarnings("unused")
	private static int getIntervalDaysOfExitDate(Date exitDateFrom,Date exitDateTo) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(exitDateFrom);
		int dayFrom = cal.get(Calendar.DAY_OF_YEAR);
		cal.setTime(exitDateTo);
		int dayTo = cal.get(Calendar.DAY_OF_YEAR);
		return dayTo - dayFrom;
	}
}
