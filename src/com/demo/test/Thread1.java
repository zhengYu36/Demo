package com.demo.test;

/***
 * 关于线程的测试(好久没有写搞忘了)
 * @author lenovo
 *
 */

public class Thread1 {
	public static void main(String[] args) {
		System.out.println("关于线程的demo例子");
		A t1 = new A();
		A t2 = new A();
		t1.start();
		t2.start();
		System.out.println("//////////////");
	}
	
	
}

class A extends Thread{
	@Override
	public void run() {
		for(int i=0;i<6;i++){
			System.out.println("ttt");
		}
	}
}
