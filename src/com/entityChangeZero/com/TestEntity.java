package com.entityChangeZero.com;

/**
 * @description 这个是一个测试实体，如果有的参数为null，那么我要改变成相应的数字
 * @author zhengYu
 *
 */
public class TestEntity {
	
	private String name;  //姓名
	private String like;  //爱好
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLike() {
		return like;
	}
	public void setLike(String like) {
		this.like = like;
	}
	public TestEntity(String name, String like) {
		super();
		this.name = name;
		this.like = like;
	}
	
	
	

}
