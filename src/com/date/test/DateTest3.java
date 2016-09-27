package com.date.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 得到昨天的日期
 * 
 * @author zhengYu
 *
 */
public class DateTest3 {
	public static void main(String[] args) {
		System.out.println("打印得到昨天的日期哈");
		/*Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		String yesterday = new SimpleDateFormat("yyyyMMdd ").format(cal
				.getTime());
		System.out.println(yesterday);*/
		
		Calendar cal = Calendar.getInstance();
		//今天
		cal.add(Calendar.DATE, 0);   //注意：这里 -1 是昨天  0是今天  1是明天(当时这个也要考虑我的操作系统哦，目前我的是英文的好吧)
		String todayday = new SimpleDateFormat("yyyy/MM/dd ").format(cal
				.getTime());
		System.out.println("today is:"+todayday);
	}
}
