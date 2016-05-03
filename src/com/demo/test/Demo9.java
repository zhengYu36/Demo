package com.demo.test;

/**
 * 关于数字前面补零
 * eg:  1 ,变成 00001
 * @author zhengYu
 *
 */
public class Demo9 {
	public static void main(String[] args) {
		//String getString = frontCompWithZore(15,6);
		//System.out.println("getString:"+getString);
		
		  String newString = String.format("%05d", 5);  
		  System.out.println(newString);
		  
		  int n=6;
		  String s="abc";
		  System.out.println("%1$0"+(n-s.length())+"d");
		  System.out.println(s+String.format("%1$0"+(n-s.length())+"d",0));
		  
		  System.out.println("--------");
		  String aaString = addZeroForNum("3774",6);
		  System.out.println("aaString:"+aaString);
	}
	
	/** 
	  * 将元数据前补零，补后的总长度为指定的长度，以字符串的形式返回 
	  * @param sourceDate 
	  * @param formatLength 
	  * @return 重组后的数据 
	  */  
	 public static String frontCompWithZore(int sourceDate,int formatLength)  
	 {  
	  /* 
	   * 0 指前面补充零 
	   * formatLength 字符总长度为 formatLength 
	   * d 代表为正数。 
	   */  
	  String newString = String.format("%0"+formatLength+"d", sourceDate);  
	  return  newString;  
	 }  
	 
	 
	 //前补0和后补0 (自动来添加0)
	 public static String addZeroForNum(String str, int strLength) {
	     int strLen = str.length();
	     StringBuffer sb = null;
	     while (strLen < strLength) {
	           sb = new StringBuffer();
	         //  sb.append("0").append(str);// 左(前)补0
	         sb.append(str).append("0");//右(后)补0
	           str = sb.toString();
	           strLen = str.length();
	     }
	     return str;
	 }
}
