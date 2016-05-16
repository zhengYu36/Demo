package com.json.test;

import net.sf.json.JSONObject;

/**
 * 关于测试json格式的数据
 * @author zhengYu
 *
 */
public class Test1 {
	public static void main(String[] args) {
		System.out.println("测试json----start");
		String testdataString = "{\"a\":\"a1\",\"b\":\"b1\"}";  //得到json数据
		
		
		//JSONObject jsStr = JSONObject.fromObject(params); //将字符串{“id”：1}
		//int jsID = Integer.parseInt(jsStr.getString("id"));//获取id的值
		//String -> JSON
		JSONObject json = JSONObject.fromObject(testdataString);
		String ss = json.getString("a");
		System.out.println("ss:"+ss);
		
		
	}
}
