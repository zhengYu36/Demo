package com.demo.test;


/**
 * 关于StringUtils.isNotBlank 的一些简单用法
 * @author zhengYu
 *
 */
public class Demo5 {
	public static void main(String[] args) {
		String testString = " a b c ";  //注意：这里的空格也会占位置
		//boolean isok = StringUtils.isNotBlank();
		System.out.println("length:"+testString.length());  // length:7
		
		//lengthOutTrim:5 这里的trim只会去掉两边的空格，所以长度就为5了
		System.out.println("lengthOutTrim:"+testString.toString().trim().length());
	}
}
