package com.javaben.test;

/**
 * 关于通过序列化的时候去把实体中为空的给去掉
 * @author zhengYu
 *
 */
public class DemoBean {

	private String id;
	private String name;
	private String age;
	private String like;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public String getLike() {
		return like;
	}
	public void setLike(String like) {
		this.like = like;
	}
	
	
}
