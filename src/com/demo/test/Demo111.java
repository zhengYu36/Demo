package com.demo.test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class Demo111 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println("ttttttttt");
		String st1 = "%E4%B8%B9%E9%BA%A6";
		String st2 = "";
		//st2 = URLDecoder.decode(st1,"UTF-8");
		st2 = URLDecoder.decode(st1,"gbk");
		System.out.println("xxxx:"+st2);
	}
}
