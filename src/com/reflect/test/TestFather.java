package com.reflect.test;

/**
 * 测试实体的父类
 * @author zhengYu
 *
 */
public class TestFather {
	
	//这里是private的也是可以得到的
	private String city;
	private String name;

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
