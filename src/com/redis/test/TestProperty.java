package com.redis.test;

import java.io.InputStream;
import java.util.Properties;

/**
 * 测试读取配置文件
 * @author zhengYu
 *
 */
public class TestProperty {
	public static void main(String[] args) {
		try {
			System.out.println("测试读取配置文件哈!");
			 Properties prop = new Properties();   
	    	 
			 // 特别要注意下这里的配置文件的路径，目前我只知道可以放到src下面，然后前面一定要加/，这样就可以读到配置文件了
			 //sources是我自己创建的一个文件夹哈
	    	 InputStream in = RedisUtil.class.getResourceAsStream("/sources/db.properties"); 
	         prop.load(in);   
	         String str = prop.getProperty("redis_addr").trim();   
	         System.out.println("str:"+str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
