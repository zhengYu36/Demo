package com.list.behavior.test;

import java.util.ArrayList;
import java.util.List;

import com.listEntity.com.TestEntity;

/**
 * 去除list中对象的某一个值相同的数据，默认取第一个数据哈
 * 
 * 参考的url:
 * http://blog.csdn.net/u013499771/article/details/44647371
 *
 */
public class Demo2 {
	public static void main(String[] args) {
		System.out.println("模拟测试数据哈");
		
		
		/***
		 * 模拟情况哈：
		 * 
		List<TestEntity> list = new ArrayList<TestEntity>();
		TestEntity t1 = new TestEntity("aa1", "xiaogo1");
		TestEntity t2 = new TestEntity("aa2", "xiaogo1");
		TestEntity t3 = new TestEntity("aa3", "xiaogo3");
		TestEntity t4 = new TestEntity("aa4", "xiaogo1");
		list.add(t1);
		list.add(t2);
		list.add(t3);
		list.add(t4);
		 * eg:  通过返回后，我应该值得到t1和t3，因为t1,t2,t4中的后面一个参数是相同的
		 *    所有我要过滤掉，至于为什么是得到t1,这个是默认取第一个对象的
		 */
		
		List<TestEntity> list = new ArrayList<TestEntity>();
		TestEntity t1 = new TestEntity("aa2", "xiaogo5");
		TestEntity t2 = new TestEntity("aa2", "xiaogo1");
		TestEntity t3 = new TestEntity("aa3", "xiaogo3");
		TestEntity t4 = new TestEntity("aa4", "xiaogo1");
		list.add(t1);
		list.add(t2);
		list.add(t3);
		list.add(t4);
		
		System.out.println("----执行去掉后的数据哈");
		List<TestEntity> list2 = new ArrayList<TestEntity>();
		list2 = dinParams(list);
		for(int i=0;i<list2.size();i++){
			System.out.println("name is:"+list2.get(i).getName());
			System.out.println("like is:"+list2.get(i).getLike());
			System.out.println("===================");
		}
	}
	
	/**
	 * 这个是用类的匿名类
	 * @param list
	 * @return
	 */
	public static  List<TestEntity> dinParams(List<TestEntity> mList){
		
		for (int i = 0; i < mList.size()-1; i++) {  
		    for (int j = mList.size()-1; j > i; j--) {  
		        if (mList.get(j).getLike().equals(mList.get(i).getLike())) {   // 如果一样就去掉哈
		            mList.remove(j);  
		        }  
		    }  
		}  
		return mList;
		
	}
}
