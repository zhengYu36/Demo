package com.demo.test;

/**
 * replace 的简单用法
 * @author zhengYu
 *
 */
public class Demo4 {
	public static void main(String[] args) {
		String a = "xiaoyu//xxxx";
		String b = a.replace("//", "---");
		System.out.println("111--------------");
		System.out.println(a);
		System.out.println("222--------------");
		System.err.println(b);
	}
}
