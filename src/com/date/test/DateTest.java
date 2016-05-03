package com.date.test;

import java.util.Calendar;
import java.util.Date;

/**
 * @description 关于java date的测试，这里的date是指java.util.工具包的
 * 这里一个是date 一个是calender类
 * @author zhengYu
 *
 */
public class DateTest {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//System.err.println("dfsd");  //用err那么打印出的信息会变红
		
		//执行结果会显示从1970年1月1日开始到取得系统时间为止所经过的毫秒数
		//System.out.println(System.currentTimeMillis()); 
		
		Date date = new Date();
		System.out.println("data.toString:"+date.toString());  //Thu Apr 21 12:33:12 IRKT 2016
		System.out.println("date:"+date.getDate());  //一个月的第几天
		System.out.println("day:"+date.getDay());  // 当前周的第几天
		System.out.println("hour:"+date.getHours()); 
		System.out.println("minutes: " + date.getMinutes());  
        System.out.println("month: " + (date.getMonth() + 1));  
        System.out.println("seconds: " + date.getSeconds());  
        System.out.println("time: " + date.getTime());  
        System.out.println("timezone: " + date.getTimezoneOffset());  
        System.out.println("year: " + (date.getYear() + 1900)); 
        
        Calendar calendar = Calendar.getInstance();  //实例化,Calendar是静态类，不能被实例化
        int year = calendar.get(Calendar.YEAR); //里面的参数可以用calendar提供的变量
        int month = calendar.get(Calendar.MONTH) + 1;  
        int day = calendar.get(Calendar.DATE);  
        int hour = calendar.get(Calendar.HOUR);  
        int minute = calendar.get(Calendar.MINUTE);  
        int second = calendar.get(Calendar.SECOND);  
          
        System.out.println("----------Calendar-------");  
        System.out.println("year: " + year);  
        System.out.println("month: " + month);  
        System.out.println("day: " + day);  
        System.out.println("hour: " + hour);  
        System.out.println("minute: " + minute);  
        System.out.println("second: " + second);
        
       // 用date获得时间的值，如时、分、秒、月、日、年得方法已经过时，需要改用Calendar的方法来获取时间的值
	}
	
}
