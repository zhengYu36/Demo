package com.demo.test;
/**
 * 测试断点的执行，f5表示会进入到方法里面去，f6会跳过方法，往下面执行
 * @author zhengYu
 *
 */
public class Demo1 {
	public static void main(String[] args) {
		int a1 = 3;
		for(int i=0;i<9;i++){
			System.out.println("000000");
		}
		aaa(a1);
		System.out.println("tttt");
	}

	private static void aaa(int num) {
		int a = 1;
		int b;
		b = a+num;
		bbb(b);
	}

	private static void bbb(int num) {
		System.out.println("------");
		System.out.println(num++);
	}
}
