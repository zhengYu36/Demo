package com.demo.test;

/**
 * 关于地址栏中中文的转换
 * @author zhengYu
 *
 */
public class Demo11 {
	public static void main(String[] args) {
		//转换成ASCII 码
		System.out.println(java.net.URLEncoder.encode("绵A"));  
	}
}
