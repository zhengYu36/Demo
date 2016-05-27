package com.demo.test;

import java.security.MessageDigest;

/**
 * MD5 32位加密的和16位加密的
 * @author zhengYu
 *
 */
public class TestMD5 {
	
	private static void Md5(String plainText) { 
		try { 
		MessageDigest md = MessageDigest.getInstance("MD5"); 
		md.update(plainText.getBytes()); 
		byte b[] = md.digest(); 

		int i; 

		StringBuffer buf = new StringBuffer(""); 
		for (int offset = 0; offset < b.length; offset++) { 
		i = b[offset]; 
		if(i<0) i+= 256; 
		if(i<16) 
		buf.append("0"); 
		buf.append(Integer.toHexString(i)); 
		} 

		System.out.println("result: " + buf.toString());//32位的加密 

		System.out.println("result: " + buf.toString().substring(8,24));//16位的加密 

		} catch (Exception e) { 
		// TODO Auto-generated catch block 
		e.printStackTrace(); 
		} 
		} 
	
	//这样就生成了md5这个数据了
	public static void main(String[] args) {
		String strUserInfoJson = "{\"name\":\"xiaoyu\",\"like\":\"pinping\"}";
		String str= "1" + strUserInfoJson + "wagcd";
		Md5(str); 
	}
}
