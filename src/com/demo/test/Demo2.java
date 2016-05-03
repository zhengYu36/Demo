package com.demo.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo2 {
	public static void main(String[] args) throws Exception {

		Demo2 demo2 = new Demo2(); // 去获取自己本身的方法
		// 正则表达式的测试
		demo2.testPattern(); // 测试表达式
	}

	public void testPattern() {
		//1. ^ 和 $ 的用法查找以aaaa开头,bbb结尾的字符串
		//Pattern pattern = Pattern.compile("^aaaa.*bbb$"); //以aaaa开头， 以bbb结尾的 
		//Matcher matcher = pattern.matcher("aaaa不是人bbb");  //下面这样的就是可以得
		
		//2.[] 和 {} 的用法 ,以0-9的一个数字开头   有1-5的数量，  然后后面是zy后面是任意一个字符，然后以sb结尾
		//Pattern pattern = Pattern.compile("^[0-9]{1,5}zy.sb$"); //
		//Matcher matcher = pattern.matcher("3zy4sb");  // t:2zya.sb   f:azya.sb
		
		//3.[^0-9]  非0-9
		//Pattern pattern = Pattern.compile("[^a-z]aa"); 
		//Matcher matcher = pattern.matcher("8aa"); 
		
		//a或b
		//Pattern pattern = Pattern.compile("[a|b]aa"); // Matcher matcher = pattern.matcher("caa");  // t:2zya.sb   f:azya.sb
		
		//J或者JA出现  eg: JAB? JA 或者JAB 出现
		//Pattern pattern = Pattern.compile("JA?");
		//Matcher matcher = pattern.matcher("J");

		//boolean b = matcher.matches();
		// 当条件满足时，将返回true，否则返回false
		//System.out.println(b);
		
		Pattern pattern = Pattern.compile("正则表达式");
		Matcher matcher = pattern.matcher("正则表达式 Hello World,正则表达式 Hello World");
		//替换第一个符合正则的数据
		System.out.println(matcher.replaceFirst("Java"));
	}
}
