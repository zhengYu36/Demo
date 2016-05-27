package com.demo.test;

/**
 * 测试断点的知识 - 看断点怎样从一个for跑到另外一个for里面去
 * @author zhengYu
 *
 */
public class Demo14 {
	public static void main(String[] args) {
		System.out.println("----test 断点   start----");
		
		for(int i=0;i<100;i++){
			System.out.println("haha1:---"+(i+1));
		}
		
		System.out.println("-------第一阶段测试完成------");
		
		
		for(int i=0;i<100;i++){
			System.out.println("haha2:---"+(i+1));
		}
		
		
		/**
		 * 总结：如果跑错了，我就按resume 就回来了
		 * 如果我想跑到另外一个for该怎么办？我把上一个的那个断点给去掉，然后按resume就下去了
		 */
		
	}
}
