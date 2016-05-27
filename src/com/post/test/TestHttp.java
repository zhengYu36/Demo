package com.post.test;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 自己来写关于http的测试工程
 * @author zhengYu
 *
 */
public class TestHttp {
	public static void main(String[] args) {
		try {
			System.out.println("测试http的url开始");
			URL url = new URL("http://www.baidu.com");
			
			//打开连接
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			System.out.println("url:"+url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
