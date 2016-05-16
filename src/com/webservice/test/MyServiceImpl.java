package com.webservice.test;

import javax.jws.WebService;  



import net.sf.json.JSONObject;


  
/**  
 * @className:MyServiceImpl.java 
 * @Desc:定义：SIB service implemention bean 
 * @author:lizhuang 
 * @createTime:2012-12-21 上午01:01:22 
 */  

@WebService(endpointInterface="com.webservice.test.IMyservice")  
public class MyServiceImpl implements IMyservice {  
	
	JSONObject res = new JSONObject();
	
	public String sayHello(){
		// 输出的json字符串构造
		res.put("message", "成功");
		res.put("result", "haha");

		return JSONObject.toBean(res).toString();
	//	return JSONObject.toJSONString(res, features);
	}
	
    public int add(int a, int b) {  
        System.out.println("a+b="+(a+b));  
        return a+b;  
    }  
  
    public int minus(int a, int b) {  
        System.out.println("a-b="+(a-b));  
        return a-b;  
    } 
	}  