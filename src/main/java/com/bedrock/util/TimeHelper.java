package com.bedrock.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bedrock.constant.DateFormat;

public class TimeHelper 
{
	/**
	 * 比较两个日期
	 * @param pattern 日期格式
	 * @param time1	
	 * @param time2
	 * @return
	 * @throws ParseException
	 */
	public static int compare(String pattern,String time1,String time2) throws ParseException
	{
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Date date1= format.parse(time1);
		Date date2= format.parse(time2);
		return date1.compareTo(date2);
	}
	
	/**
	 * 和当前日期做比较
	 * @param pattern 日期格式
	 * @param time 时间
	 * @return
	 * @throws ParseException
	 */
	public static int compareToNow(String pattern,String time) throws ParseException
	{
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Date date1= format.parse(time);
		Date now=new Date();
		return date1.compareTo(now);
	}
	
	/**
	 * 日期格式化
	 * @param pattern
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String format(DateFormat pattern,Object date)
	{
		SimpleDateFormat format = new SimpleDateFormat(pattern.getFormat());
		String dateStr= format.format(date);
		return dateStr;
	}
	
	
	/**
	 * 时间戳转字符串
	 * @param pattern 字符串格式
	 * @param timeStamp 时间戳
	 * @return
	 */
	public static String timeStamp2Str(DateFormat pattern,long timeStamp)
	{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern.getFormat());
        Date date = new Date(timeStamp);
        return simpleDateFormat.format(date);
	}
	
	/**
	 * 格式化当前日期
	 * @param pattern
	 * @return
	 */
	public static String now2Str(DateFormat pattern)
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern.getFormat());
        Date date = new Date();
        return simpleDateFormat.format(date);
	}

}
