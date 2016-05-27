package com.tostring.test;

/**
 * 测试toString()方法的实体
 * @author zhengYu
 *
 */
public class TestEntity {
	private String name;
	private String age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public TestEntity(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	public TestEntity() {
		super();
	}
/*	@Override
	public String toString() {  //这个方法类似于我在实例化后输出该实体类的时候，打印出来的值
		return "TestEntity [name=" + name + ", age=" + age + "]";
	}*/
	
	
}
