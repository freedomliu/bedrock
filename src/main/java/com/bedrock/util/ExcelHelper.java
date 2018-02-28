package com.bedrock.util;

import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.bedrock.constant.DateFormat;

/**
 * 导出Excel帮助类
 * @author liuxiangtao90
 *
 */
public class ExcelHelper 
{

	/**
	 * Excel导出
	 * @param response
	 * @param sheetName sheet页
	 * @param list 输出集合
	 * @param itemKey 标题列字段名
	 * @param itemValue 标题列名称
	 * @return
	 * @throws Exception
	 */
	public static Object exportExcel(HttpServletResponse response,String sheetName,List<? extends Serializable> list,String itemKey[],String itemValue[],DateFormat ...enmu) throws Exception{
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/vnd.ms-excel");
		String param2 =TimeHelper.now2Str(DateFormat.S2);
		response.addHeader("Content-Disposition","attachment;   filename=\"" + param2 + ".xls" + "\"");
		// 声明输出流对象
		OutputStream os = null;
		// 实例流对象
		os = response.getOutputStream();
		// 创建工作簿和sheet表
		WritableFont wf2=new WritableFont(WritableFont.createFont("微软雅黑"),12,WritableFont.NO_BOLD, false );
		WritableCellFormat wcfF2 = new WritableCellFormat(wf2);
		// 设置单元格格式
		wcfF2.setAlignment(jxl.format.Alignment.LEFT);
		// 声明工作簿
		WritableWorkbook wwb = Workbook.createWorkbook(os);		
		// 设置sheet名称
		WritableSheet sheet = wwb.createSheet(sheetName, 0);
		for (int i = 0; i < itemValue.length; i++) {
			//宽度设置
			sheet.setColumnView(i, 40);
			// 设置列名
			sheet.addCell(new Label(i, 0, itemValue[i], wcfF2));
		}
		sheet.setRowView(0, 500);
		for (int i = 1;i < list.size()+1; i++) {
			Serializable ta = list.get(i-1);
			for(int j=0;j<itemKey.length;j++)
			{
				// get 驼峰
				String name = itemKey[j].substring(0, 1).toUpperCase() + itemKey[j].substring(1);
				Method m = ta.getClass().getMethod("get" + name);
				Class<?> type= m.getReturnType();
				Object value= m.invoke(ta);
                if(enmu.length!=0 && type==Date.class)
                {
                	value= TimeHelper.format(enmu[0], value);
                } 
				sheet.addCell(new Label(j, i,value==null?"":value.toString(), wcfF2));	
			}
		}
		wwb.write();
		wwb.close();
		os.close();
		return null;
	}

}
