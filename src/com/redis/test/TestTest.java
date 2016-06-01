package com.redis.test;

/**
 * 关于测试
 * @author zhengYu
 *
 */
public class TestTest {
	
	public static void main(String[] args) {
		String str = "3,,5";  //最后一个,的后面必须有值才行，不然会报错的
		String[] sts =str.split(",");
		System.out.println("size:"+sts.length);
		System.out.println("str1:"+sts[0]);
		System.out.println("str2:"+sts[1]);
		System.out.println("str3:"+sts[sts.length-1]);
		System.out.println("ccccc");
	}
}
