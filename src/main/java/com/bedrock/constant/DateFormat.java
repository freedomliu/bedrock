package com.bedrock.constant;

/**
 * 日期格式枚举
 * @author liuxiangtao90
 *
 */
public enum DateFormat
{
	// 命名为日期格式最后一级 按照常用分为1 2 3...
	D1("yyyy-MM-dd"),
	D2("yyyy/MM/dd"),
	S1("yyyy-MM-dd HH:mm:ss"),
	S2("yyyyMMddHHmmss");
	
	private String dateFormat;
	
	private DateFormat(String dateFormat)
	{
		this.dateFormat=dateFormat;
	}
	 
	public String getFormat()
	{
		return this.dateFormat;
	}
}
