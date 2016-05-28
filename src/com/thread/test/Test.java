package com.thread.test;

/**
 * 这个类是来执行实现的哈
 * @author zhengYu
 * 其实我觉得哈，线程的执行一步应该和定时器在一起执行，这样感觉比较好一点
 * 
 * 详细:可访问以下链接
 * http://blog.csdn.net/aboy123/article/details/38307539
 */
public class Test {
	public static void main(String[] args) {
		
		// thread的方式,这样就表示开启了两个线程哈，然后就在执行了
	/*	TestThread t1 = new TestThread();
		TestThread t2 = new TestThread();
		t1.start();
		t2.start();*/
		
		//runable的方式,runable的方式有点点麻烦，需要先实例化，然后还要放到thread中，然后才 
		TestRunable testRunable = new TestRunable();
		Thread thread = new Thread(testRunable);
		thread.start();
	}
}
