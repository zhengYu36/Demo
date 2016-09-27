package com.testclass.test;

/***
 * 关于class类相关的知识
 * @author zhengYu
 *
 */
public class Demo1 {
	public Demo1() {
		System.out.println("Demo1\n");
	}
	
	public static void main(String[] args) {
		System.out.println("关于类相关的知识");
		Demo1 d1 = new Demo1();
		d1.test1();
	}
	public void test1(){
		System.out.println("test1 method!");
		System.out.println(this.getClass().getName()+"\n");  // 包名 都会打印出来
		System.out.println(this.getClass().getSimpleName()+"\n");  //只打印方法名
	}
}
