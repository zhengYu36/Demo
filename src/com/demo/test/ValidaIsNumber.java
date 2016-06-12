package com.demo.test;

/**
 * 验证是否是数字
 * 资源，网上找的方法 - 这个是用异常的操作来进行的
 * @author zhengYu
 *
 */
public class ValidaIsNumber {
	public static void main(String[] args) {
		System.out.println("验证String是否是数字----start");
		//boolean isok = isNumber("36.59897983405301");  // 异常的方式
		boolean isok = isNum("-3644");  //正则表达式方式 -- 这个代码比较简单
		System.out.println("isok:"+isok);
	}
	
	//这个是用正则表达式的方式来进行的
	public static boolean isNum(String str){
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	}
	
	/**
	  * 判断字符串是否是整数
	  */
	 public static boolean isInteger(String value) {
	  try {
	   Integer.parseInt(value);
	   return true;
	  } catch (NumberFormatException e) {
	   return false;
	  }
	 }

	 /**
	  * 判断字符串是否是浮点数
	  */
	 public static boolean isDouble(String value) {
	  try {
	   Double.parseDouble(value);
	   if (value.contains("."))
		   return true;
	   return false;
	  } catch (NumberFormatException e) {
	   return false;
	  }
	 }

	 /**
	  * 判断字符串是否是数字
	  */
	 public static boolean isNumber(String value) {
	  return isInteger(value) || isDouble(value);
	 }
}
