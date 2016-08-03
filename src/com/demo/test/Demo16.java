package com.demo.test;

import com.json.test.ReadJsonFileUtil;

public class Demo16 {
	
	public static void main(String[] args) {
		System.out.println("通过文件路径，去获取文件里面的数据");
/*		String jsonFileName = "src/sources/JsonValue.txt";
		String str = ReadJsonFileUtil.returnJson(jsonFileName);
		System.out.println("str:"+str);*/
		
		String str = "343";
		str=str.replace("\"", "");
		System.out.println("str:"+str);
	}
}
