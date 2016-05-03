package com.demo.test;

/**
 * 在win10 64 bit系统下
 * 关于测试数据类型的值
 * @author zhengYu
 *
 */
public class Demo12 {
	public static void main(String[] args) {
		
		//int的最大和最小值
		int  itmax = Integer.MAX_VALUE; // 这个是取到了int的最大数，注意这里只是针对当前系统的，不同的系统值肯能不一样
		int  itmin = Integer.MIN_VALUE;
		System.out.println("itmax:"+itmax);
		System.out.println("itmin:"+itmin);
		
		//long的最大和最小值
		long lmax = Long.MAX_VALUE;
		long lmin = Long.MIN_VALUE;
		System.out.println("lmax:"+lmax);
		System.out.println("lmin:"+lmin);
		
		double dmax = Double.MAX_VALUE;
		double dmin = Double.MIN_VALUE;
		System.out.println("dmax:"+dmax);
		System.out.println("dmin:"+dmin);
		
		/**
		    dmax:1.7976931348623157E308
			dmin:4.9E-324
			特别说明:4.9E-324是科学计数法表示4.9乘以10的-324次方 ,dmax是一个道理
		 */
		// 至于其他的数据类型都差不多的，这里就不写了，可以自己去尝试看看很有意思的
	}
}
