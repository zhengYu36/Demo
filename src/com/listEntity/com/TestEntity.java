package com.listEntity.com;

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
