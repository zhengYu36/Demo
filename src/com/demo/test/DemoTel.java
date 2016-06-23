package com.demo.test;

/**
 * 网上的一道题，来求电话号码
 * @author zhengYu
 *
 */

public class DemoTel {
	public static void main(String[] args) {
		int[] arr = new int[]{8,2,1,0,3};
		int[] index = new int[]{2,0,3,2,4,0,1,3,2,3,3};
		String tel = "";
		for(int i:index){
			tel+=arr[i];
		}
		
		//这里这个断点，可以点击上面的resume就可以跳转到下面这个断点来
		System.out.println("tel:"+tel);  
		System.out.println("tel1:"+tel);
		System.out.println("tel2:"+tel);
	}
}
