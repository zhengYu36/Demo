
package com.post.test;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class HttpURLConnectionPost {

 /**
  * @param args
  * @throws IOException 
  */
 public static void main(String[] args) throws IOException {

  System.out.println("--1---");
  readContentFromPost();
  System.out.println("--2---");
 }
 public static void readContentFromPost(){
	 try {

	        // Post请求的url，与get不同的是不需要带参数
	        //URL postUrl = new URL("http://10.37.18.6:8080/sharing/rs/v1/Test6");
		 URL postUrl = new URL("http://10.37.18.6:8080/sharing/rs/v1/Test6");
	        // 打开连接
	        HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
	      
	        // 设置是否向connection输出，因为这个是post请求，参数要放在
	        // http正文内，因此需要设为true
	        connection.setDoOutput(true);
	        // Read from the connection. Default is true.
	        connection.setDoInput(true);
	        // 默认是 GET方式
	        connection.setRequestMethod("POST");
	       
	        // Post 请求不能使用缓存
	        connection.setUseCaches(false);
	       
	        connection.setInstanceFollowRedirects(true);
	       
	        // 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的
	        // 意思是正文是urlencoded编码过的form参数，下面我们可以看到我们对正文内容使用URLEncoder.encode
	        // 进行编码
	        connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
	        // 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成，
	        // 要注意的是connection.getOutputStream会隐含的进行connect。
	        connection.connect();
	        DataOutputStream out = new DataOutputStream(connection
	                .getOutputStream());
	        // The URL-encoded contend
	        // 正文，正文内容其实跟get的URL中 '? '后的参数字符串一致
	/*        String content = "account=" + URLEncoder.encode("一个大肥人", "UTF-8");
	        content +="&pswd="+URLEncoder.encode("两个个大肥人", "UTF-8");*/
	        String content = "id=" + URLEncoder.encode("55t", "UTF-8");
	   //     content +="&like="+URLEncoder.encode("两个个大肥人444aa", "UTF-8");
	        // DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写到流里面
	        out.writeBytes(content);

	        out.flush();
	        out.close(); 
	        
	        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        String line;
	        
	        while ((line = reader.readLine()) != null){
	            System.out.println(line);
	        }
	      
	        reader.close();
	        connection.disconnect();

	} catch (Exception e) {
		e.printStackTrace();
	}
 }

}

/*在接收端，这样获取参数：
String name = request.getParameter("account");
String pswd = request.getParameter("pswd");
 
 System.out.println(new String(name.getBytes("iso-8859-1"),"UTF-8")); 
 System.out.println(new String(pswd.getBytes("iso-8859-1"),"UTF-8")); */