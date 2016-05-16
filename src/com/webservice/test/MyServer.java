package com.webservice.test;
import javax.xml.ws.Endpoint;  
  
/** 
 * @className:MyServer.java 
 * @Desc:发布服务 
 * @author:lizhuang 
 * @createTime:2012-12-21 上午01:02:39 
 */  
public class MyServer {  
    public static void main(String[] args) {  
        //访问方式：http://localhost:7777/tudou?wsdl 
    	System.out.println("service----start");
        String address="http://localhost:7777/tudou";  
        Endpoint.publish(address, new MyServiceImpl());  
    }  
}  