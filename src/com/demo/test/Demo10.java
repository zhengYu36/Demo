package com.demo.test;

/**
 * 关于java前补0和后补0
 * 注意在方法2中，补什么，是可以自定义的
 * 
 * @author zhengYu
 *
 */
public class Demo10 {
	public static void main(String[] args) {
		
		 //方法1：
		 String getString = frontCompWithZore(15,6,1);
		 System.out.println("getString:"+getString);
		 
		 //方法2：
		 String getString2 = addZeroForNum("15",6,1,"1");
		 System.out.println("getString2:"+getString2);
	}

	/**
	 * 方法1：
	 * 将元数据前补零，补后的总长度为指定的长度，以字符串的形式返回
	 * 
	 * @param sourceDate
	 *            -- 以前的数据 eg:0
	 * @param formatLength
	 *            -- 长度
	 * @param position
	 *            -- 是前补 还是后补, 输入的如果是0 是前面补,输入的是1 是后补，
	 * @return 重组后的数据
	 */
	public static String frontCompWithZore(int sourceDate, int formatLength,
			int position) {
		/*
		 * 0 指前面补充零 formatLength 字符总长度为 formatLength d 代表为正数。
		 */
		
		String newString = "";
		if (position == 0) {
			  newString = String.format("%0"+formatLength+"d", sourceDate);  
		} else if (position == 1) {
			  String sourceDates = sourceDate + "";
			  newString =sourceDates + String.format("%1$0" + (formatLength - sourceDates.length()) + "d", 0);
		}
		
		 return  newString;  

	}
	
	
	 /* 方法2：
	  * 前补0和后补0 (自动来添加0)
	  * 同时方法2可以自定义符号，就是说可以是前面补0，也可以是其他
	  */
	 public static String addZeroForNum(String str, int strLength,int position,String mark) {
	     int strLen = str.length();
	     StringBuffer sb = null;
	     while (strLen < strLength) {
	           sb = new StringBuffer();
		 		if (position == 0) {
		 			sb.append(mark).append(str);// 左(前)补mark
				} else if (position == 1) {
					sb.append(str).append(mark);//右(后)补mark
				}
	           str = sb.toString();
	           strLen = str.length();
	     }
	     return str;
	 }

}
