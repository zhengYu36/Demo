package com.classTest.test;

public class TestEntity {
	private String name;
	private int age;
	
	public void Say(){
		System.out.println(this.getClass().getSimpleName()+":this is say");
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
	
}
