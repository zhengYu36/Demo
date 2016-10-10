package com.demo.test;

import org.apache.log4j.Logger;



/***
 * 很多时候我们要测试一个方法所用的时间，都是用开始时间减去结束来得到的，所以我们一般会有一个参考的模式
 * eg:详细请参考 psafety项目中的 
 * com.asion.kpi.roam.relationNetwork.RelationNetworkQuartzJob 类中的方法哈
 * @author lenovo
 *
 */
public class DemoStartJQEndTime {
	private static Logger log = Logger.getLogger(DemoStartJQEndTime.class);  //这里好像log有问题哈
	
	public static void main(String[] args) {
		//log.info("-----------测试开始执行-------------------");  
		System.out.println("-----------测试开始执行-------------------");
		long start = System.currentTimeMillis();  //得到系统当前时间
		
		test1();   //具体要执行的方法
		
		Long end = System.currentTimeMillis();  //系统最后的时间
		//log.info("-----------任务执行成功！用时:（" + (end - start) + "）-------------------");
		System.out.println("-----------任务执行成功！用时:（" + (end - start) + "）-------------------");
	}
	
	/***模拟测试方法*/
	public static void test1(){
		
		for(int i=0;i<1000;i++){
			System.out.print("ttt");
		}
		System.out.println();
	}
}
