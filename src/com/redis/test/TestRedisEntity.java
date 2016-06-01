package com.redis.test;

/**
 * 存redis数据的实体
 * @author zhengYu
 *
 */
public class TestRedisEntity {
	private String name; //名字
	private int age;  //年龄
	private int number;  //编号 ->这个是一个状态编号
	
	private String keyname; //这个我要记录Key的名字，主要是为了方便hash里面就像数据的修改
	
	@Override
	public String toString() {
		return "TestRedisEntity [name=" + name + ", age=" + age + ", number="
				+ number + ", keyname=" + keyname + "]";
	}
	public String getKeyname() {
		return keyname;
	}
	public void setKeyname(String keyname) {
		this.keyname = keyname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
}
