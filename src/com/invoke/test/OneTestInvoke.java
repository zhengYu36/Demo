package com.invoke.test;

import java.lang.reflect.Method;

/**
 * 自己来测试下invode的神奇
 * 我来看看可不可以取得类里面的方法，恩，是的
 * @author zhengYu
 *
 */
public class OneTestInvoke {
	
	//这是些测试的数据
	private String All_Lines; //总行数
	private String Successful_Numbers; //解析成功数
	private String Failed_Numbers; //解析失败数
	
	public String getAll_Lines() {
		return All_Lines;
	}

	public void setAll_Lines(String all_Lines) {
		All_Lines = all_Lines;
	}

	public String getSuccessful_Numbers() {
		return Successful_Numbers;
	}

	public void setSuccessful_Numbers(String successful_Numbers) {
		Successful_Numbers = successful_Numbers;
	}

	public String getFailed_Numbers() {
		return Failed_Numbers;
	}

	public void setFailed_Numbers(String failed_Numbers) {
		Failed_Numbers = failed_Numbers;
	}

	public static void main(String[] args) throws Exception{
		
		//Class<?>  ？ - 表示不确定的java类型
		Class<?> classType = OneTestInvoke.class;//得到测试类
		Object invokeInstance = classType.newInstance(); //得到实例化
		
		String str = "All_Lines";
		
		//获取set类---先set这样才有值
		Method setMethod = classType.getMethod("set"+str,new Class[]{String.class});
		//去调取set的方法
		Object resultSetObject = setMethod.invoke(invokeInstance, new Object[]{"346"});
		System.out.println("setXXX:"+(String)resultSetObject);
		
		//获取get类---这样可以得到值
		Method getMethod = classType.getMethod("get"+str, new Class[]{});
		//调取
		Object resultGetObject = getMethod.invoke(invokeInstance, new Object[]{});
		System.out.println("getXXX:"+(String)resultGetObject);
		
	}
}
