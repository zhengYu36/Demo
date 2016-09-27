package com.demo.test;

/****
 * @des 测试  += 的 ++== 哈
 * @author ZY
 * 
 * 
 * http://www.zybang.com/question/5f905eea5720f9512a128d03b1644d5e.html
 * 
 * 因为&&的级别比||高,所以我们先做x--==1&&y++==1,&&左边部分的意思是x的值是否等于1,
 * 然后x的值再减一,右边的意思是y的值是否等于1,然后y再加一,如果两者都成立,这个表达式的值为true,否则为false,z++==1的意思是z的值是否为1,
 * 然后z加1,如果为1,则表达式的值为true,否则为false,因为是或,所以如果这个两个表达式中只要有一个为真,就可以执行if后面的语句,如果两个都为假,则不能满足
 *
 */
public class TestJJDD {
	public static void main(String[] args) {
		System.out.println("测试关于+=这个方法哈");
		int a = 3;
		int b = 2;
		a += b;
		System.out.println("a is:"+a);
		System.out.println("//////////////");
		System.out.println("测试关于++==这个方法哈");
		int a1 = 3;
		int b1 = 2;
		//a1 ++== b1;
		if(a1 --== 1){
			System.out.println("======="+a1);
		}
		System.out.println("a1 is:"+a1);
	}
}
