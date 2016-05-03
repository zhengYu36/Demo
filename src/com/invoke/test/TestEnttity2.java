package com.invoke.test;

import java.lang.reflect.Method;

/**
	这个是测试实体看看是不是可以的
 * @author zhengYu
 *
 */
public class TestEnttity2 {
	
	public TestEnttity2(String all_Lines1, String successful_Numbers1,
			String failed_Numbers1) {
		super();
		All_Lines1 = all_Lines1;
		Successful_Numbers1 = successful_Numbers1;
		Failed_Numbers1 = failed_Numbers1;
	}
	//这是些测试的数据
	private String All_Lines1; //总行数
	private String Successful_Numbers1; //解析成功数
	private String Failed_Numbers1; //解析失败数
	public String getAll_Lines1() {
		return All_Lines1;
	}
	public void setAll_Lines1(String all_Lines1) {
		All_Lines1 = all_Lines1;
	}
	public String getSuccessful_Numbers1() {
		return Successful_Numbers1;
	}
	public void setSuccessful_Numbers1(String successful_Numbers1) {
		Successful_Numbers1 = successful_Numbers1;
	}
	public String getFailed_Numbers1() {
		return Failed_Numbers1;
	}
	public void setFailed_Numbers1(String failed_Numbers1) {
		Failed_Numbers1 = failed_Numbers1;
	}
	
	
	
}
