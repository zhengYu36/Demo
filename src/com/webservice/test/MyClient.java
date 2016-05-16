package com.webservice.test;
import java.net.MalformedURLException;  
import java.net.URL;  
  

import javax.xml.namespace.QName;  
import javax.xml.ws.Service;  
  

import net.sf.json.JSONObject;

import com.webservice.test.IMyservice;  
  
/** 
 * @className:MyClient.java 
 * @Desc:访问发布的服务 
 * @author:lizhuang 
 * @createTime:2012-12-21 上午01:23:57 
 */  
public class MyClient {  
    public static void main(String[] args) {  
  
        try {  
            //服务WSDL Document的地址  
            URL url = new URL("http://localhost:7777/tudou?wsdl");  
            //Qnameqname是qualified name 的简写  
            //2.构成：由名字空间(namespace)前缀(prefix)以及冒号(:),还有一个元素名称构成  
            //由发布的wsdl可知namespace为http://server.ws.platform.whaty.com/， 
            //com.webservice.test
            QName qname=new QName("http://test.webservice.com/","MyServiceImplService");  
            Service service=Service.create(url, qname);  
            IMyservice ms=service.getPort(IMyservice.class);  
            ms.add(1, 4);  
            ms.minus(1, 4);  
            String ssString=ms.sayHello();  //提供json格式
            System.out.println("str:"+ssString);
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        }  
    }  
}  