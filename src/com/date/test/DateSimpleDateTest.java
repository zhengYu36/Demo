package com.date.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 关于时间类型的格式化
 * 
 * @author zhengYu
 *
 */
public class DateSimpleDateTest {
	public static void main(String[] args) {
		SimpleDateFormat sp =new SimpleDateFormat("yyyyMMdd"); //这个是一个时间模板
		Date d = new Date();
		System.out.println("simpledate:"+sp.format(d)); //这个把时间格式给转换成什么的模板
		
		System.out.println("关于时间的转换--------");
		
		//String --->date
		SimpleDateFormat sp1 =new SimpleDateFormat("yyyyMMdd HH:mm:ss"); //这个是一个时间模板
		Date d1 = null;
		String str1 = "20090214 12:00:00"; //这个是时间格式
		try {
			d1 = sp1.parse(str1);
			System.out.println("d1:"+d1.getDate()); //打印出时间
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//date->String,现在我们还是用上面的那个d1
		String str2 = sp1.format(d1); //这样时间格式就成了字符串了
		System.out.println("str2:"+str2);
	
		
	}
}
