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
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		String yesterday = new SimpleDateFormat("yyyyMMdd ").format(cal
				.getTime());
		System.out.println(yesterday);
	}
}
