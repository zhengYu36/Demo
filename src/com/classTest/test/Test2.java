package com.classTest.test;

import java.lang.reflect.*;

/**
 * 测试类的deom2，随便写写的哈
 * @author zy
 *
 */

public class Test2 {
	public static void main(String[] args) {
		System.out.println("测试class的方法哈");
		Test2 t = new Test2();
		t.testx();
	}
	
	
	public void testx(){
		//Field[] fields = this.getClass().getFields();
		//这里去调取测试类，看看是否可以得到那些方法哈
		TestEntity  t1 = new TestEntity();
		//System.out.println("tt:"+t1.getClass().get);
		
		
		
		Field[] fields = t1.getClass().getDeclaredFields();  
		Method[] method =  t1.getClass().getMethods();
		System.out.println("f length：");
		for(int i=0;i<fields.length;i++){
			System.out.println(fields[i].getName());
		}
	}
}
