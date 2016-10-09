package com.demo.test;

/***
 * 关于线程的测试(好久没有写搞忘了)
 * @author lenovo
 *
 */

public class Thread2 {
	public static void main(String[] args) {
		System.out.println("关于线程的demo例子");
		B t1 = new B();
		B t2 = new B();
		Thread thread = new Thread(t1);
		Thread thread1 = new Thread(t2);
		thread.start();
		thread1.start();
		System.out.println("//////////////");
	}
	
	
}

class B implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<6;i++){
			System.out.println("ttt222");
		}
	}
	
}
