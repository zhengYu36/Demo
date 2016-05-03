package com.demo.test;

/**
 * @description 关于测试int 和 long 的区别的问题
 * @author zhengYu
 *
 */
public class Demo7 {
	public static void main(String[] args) {
		String str = "20160411164015";
		//int stri = Integer.parseInt(str); //这里会报错，因为 20160411164015 的长度大于int的存储的范围了
		long stri = Long.parseLong(str);  // 如果有Long的话是可以的，因为long的长度是可以存储的
		System.out.println("str:"+str); 
		System.out.println("stri:"+stri);
		
	//	System.out.println("-------------");
	//	long aa = 1;
	//	long bb = 4;
	//	System.out.println(aa+bb);   //同时Long 还是可以进行加减的操作
		long strii = 20160411164016l;
		if(stri<stri){
			System.out.println("fsdfs");
		}
		System.out.println(stri);
	}
}
