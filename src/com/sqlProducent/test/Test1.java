package com.sqlProducent.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


/**
 * 关于测试得到文件里面的数据
 * @author zhengYu
 *
 */
public class Test1 {
	public static void main(String[] args) {
		System.out.println("测试从电脑里面得到数据");
		String name = "sql";
		String theFileOfRawSql = "D:\\json.txt";
		try {
			//我这个是电脑的操作系统是英文的，所以我要改变为gbk才行
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(theFileOfRawSql),"gbk")); 
			String data = "";
		    StringBuilder sb = new StringBuilder();
			while((data = br.readLine()) != null){
				 sb.append(data);   //把值放到sb里面去
			}
			//return sb.toString(); //返回json格式的字符串
			System.out.println("得到数据");
			System.out.println("json:"+sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
