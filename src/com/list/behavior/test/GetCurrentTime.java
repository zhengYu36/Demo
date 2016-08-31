package com.list.behavior.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GetCurrentTime {
	public static void main(String[] args) {

		  	System.out.println("得到昨天的时间");
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -1);
			String yesterday = new SimpleDateFormat("yyyyMMdd ").format(cal
					.getTime());
			System.out.println("昨天:"+yesterday);
			System.out.println("======");
			cal.add(Calendar.DATE, 1);
			String todayday = new SimpleDateFormat("yyyyMMdd ").format(cal
					.getTime());
			System.out.println("今天:"+todayday);
		}

}
