package com.json.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


/**
 * 关于读文件(文件里面的格式为json格式)
 * 这里采用的是相对路径哈
 * @author zhengYu
 *
 */
public class ReadJsonFileUtil {
	
	/**
	 * 
	 * @param jsonFileName 包含json格式的文件名  (注：这里包含了路径的哈)
	 * eg:src/sources/JsonValue.txt 这种就是文件名，加上路径名哈
	 * @return
	 */
	public static String returnJson(String jsonFileName){
		System.out.println("文件路径为~~~~:"+jsonFileName);
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(jsonFileName),"utf-8")); 
			String data = "";
		    StringBuilder sb = new StringBuilder();
			while((data = br.readLine()) != null){
				 sb.append(data);   //把值放到sb里面去
			}
			return sb.toString(); //返回json格式的字符串
		} catch (Exception e) {
			e.printStackTrace();
			return null;  
		}
		
	}
}
