package com.demo.test;

/**
 * 尝试下通过long来和int或double进行相加
 * @author zhengYu
 *
 */
public class Demo13 {
	
	public static void main(String[] args) {
		long l1 = 4l;
		int i2 = 5;
		System.out.println("he1:"+(l1+i2)); //哈哈这里是可以相加的
		
		double d3 = 4.9d;  //这里可以加一个d,也是可以不加的，呵呵
		System.out.println("he2:"+(i2+d3));// 这里也是可以的
		
		//float f4 = 3.6f;  //注意下哈，这里的f只是来表示它是float类型，没有其他什么意思了
		float f4 = (float)3.7; //当然这样写也是可用的，不过怎么说呢，没有上面那一个简洁
		System.out.println("he3:"+(i2+f4));
		
		//注意:有的数据类型 是在后面再加的
	}
}
