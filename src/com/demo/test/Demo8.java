package com.demo.test;

/**
 * @description 关于测试int 和 long 的区别的问题
 * @author zhengYu
 *
 */
public class Demo8 {
	public static void main(String[] args) {
		String str = "20160411164015";

		
		//double sa = "20160411164015";
		/*int a = 568;
		int b = 58;
		if(a>b){
			System.out.println("1111");
		}else {
			System.out.println("2222");
		}*/

		//long可以比较数据的嘛，嗯，是的
		String a = "2016041413";
		String b = "2016041412";
		
		long a1 = Long.parseLong(a);
		long b1= Long.parseLong(b);
		
		System.out.println(a1<=b1);
	}
}
