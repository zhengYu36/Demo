package com.demo.test;

/**
 * @descritipn 测试toString 的方法
 * @author zhengYu
 *
 */
public class Demo3 {
	
	String name;
	int age;
	public Demo3(String name,int age){
		this.name = name;
        this.age = age;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		//return super.toString();  //调用父类的toString()方法
		return "my name is "+name+",i'm "+age+" years old";
	}
	
	public static void main(String[] args) {
		//Demo3 demo3 = new Demo3("xiaoyu",24);
		System.out.println(new Demo3("Jack",16));  //这里通过new的方法就可以打印出Demo3的信息
	}

}
