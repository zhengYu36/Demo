package com.webservice.test;
import javax.jws.WebService;

/**
 * @className:IMyservice.java
 * @Desc:定义：SEI service endpoint interface
 * @author:lizhuang
 * @createTime:2012-12-21 上午12:57:18
 */
//JAX-WS注解，表示java api xml for webservice。JDK自带API的XML格式的webservice
@WebService
public interface IMyservice {
	
	int add(int a, int b);

	int minus(int a, int b);
	
	String sayHello();
}
