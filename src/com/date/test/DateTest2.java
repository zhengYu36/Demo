package com.date.test;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description 关于java date的测试，这里的date是指java.util.工具包的
 * 这里一个是
 * @author zhengYu
 *
 */
public class DateTest2 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Date date = new Date();  
        
        /* 
         * DateFormat会依电脑上的区域设定显示时间格式，EE表示星期，MM表示月份、dd表示日期，而yyyy是西元，每个字元的设定都各有其意义 
         * 从Date-->String 
         */  
        DateFormat dateFormat = new SimpleDateFormat("EE-MM-dd-yyyy");  
        System.out.println(dateFormat.format(date));  
          
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");  
        System.out.println(format1.format(date));  
          
        DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        System.out.println(format2.format(date));  
      
        /* 
         * 从String-->Date 
         */  
        String dateStr = "2011-7-19";  
        try {  
            Date dateTrans = format1.parse(dateStr);  
            //System.out.println(dateTrans.toString());   
            System.out.println(dateTrans.toLocaleString());  //转换为本地的形式  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
	}
}
