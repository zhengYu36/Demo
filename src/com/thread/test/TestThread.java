package com.thread.test;

/**
 * 关于线程的demo  ,以前写过，不过现在忘记了，所以我重新开始学习哈
 * 
 * 线程的实现由两种方式哈，首先是我们的第一种哈,是thread --其实thread的内部它也是实现了runable的，只是它封装了一次的
 * 
 * public
class Thread implements Runnable  -- 这就是他内部的哈
 * 
 * 
 * @author zhengYu
 *
 */
public class TestThread extends Thread{
	@Override
	public void run() {  //run方法，是thread要执行的一个方法
		System.out.println("我是thread线程哦");
	}
}
