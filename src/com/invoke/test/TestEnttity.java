package com.invoke.test;

import java.lang.reflect.Method;

/**
	这个是测试实体看看是不是可以的
 * @author zhengYu
 *
 */
public class TestEnttity {
	
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

	public TestEnttity(String all_Lines, String successful_Numbers,
			String failed_Numbers) {
		super();
		All_Lines = all_Lines;
		Successful_Numbers = successful_Numbers;
		Failed_Numbers = failed_Numbers;
	}
	
	
}
