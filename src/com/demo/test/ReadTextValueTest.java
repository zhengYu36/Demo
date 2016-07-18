package com.demo.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import net.sf.json.JSONObject;

import com.redis.test.RedisUtil;

/**
 * 测试读取 xxx.txt文件里面的值
 * 因为我在用java测json数据的时候，我每次都要在前面加 \太麻烦了，现在我通过读取文件就不用就爱\了，是不是特别安逸哈
 * @author zhengYu
 *
 */
public class ReadTextValueTest {
	public static void main(String[] args) {
		try {
			System.out.println("读取里面的文件哈");
			
			//这里在读文件的时候要考虑下相对路径和绝对路径的问题哈
			
			//1:绝对路径
			//BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("d:/temp/file/addfile.txt"),"utf-8")); 
			//2.redis的方式
			//BufferedReader br=new BufferedReader(new InputStreamReader(RedisUtil.class.getResourceAsStream("/sources/JsonValue.txt"))); 
			//3:相对路径
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("src/sources/JsonValue.txt"),"utf-8")); 
			String data = "";
			
			 String line;  //每一行
		     StringBuilder sb = new StringBuilder();
			while((data = br.readLine()) != null){
				System.out.println(data);
				 sb.append(data);   //把值放到sb里面去
			}
			
			System.out.println("sb:"+sb);
			//下面来打印看看哈
			
			//测试的哈..................
			String testdataString = "{\"a\":\"a1\",\"b\":\"b1\"}";  //得到json数据
			System.out.println("sssx:"+testdataString);
			//String -> JSON
			JSONObject json1 = JSONObject.fromObject(testdataString);
			String ss1 = json1.getString("a");
			System.out.println("ss a is :"+ss1);
			
			//打印文件里面的哈
			JSONObject json = JSONObject.fromObject(sb.toString());  //我日哦，刚刚这个因为是stringBuffer，所以要转换一次才行，晕死了
			String ss = json.getString("name");
			System.out.println("name:"+ss);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
