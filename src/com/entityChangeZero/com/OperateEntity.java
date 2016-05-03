package com.entityChangeZero.com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



/**
 * 去操作实体，同时看看可不可以改变
 * @author zhengYu
 *
 */
public class OperateEntity {
	public static void main(String[] args) {
		//首先赋值(这里的值是模拟测试的数据)
		System.out.println("------teststart------");
		List<TestEntity> list = new ArrayList<TestEntity>();
		list = insert();  //插入数据
		System.out.println("listsize:"+list.size());
		
		System.out.println("-----xxxx-----");
		//然后如果要改变实体中的属性如果为null,就变成输入的值
		//这里有两种第一种，是单独的实体，另外一种是一个List集合的方式
		//第一种： 单独的实体 -- 这里不应该这样分的，都应该是一个List
		List<TestEntity> list2 = new ArrayList<TestEntity>();
		list2 = (List<TestEntity>) returnChangeEntity(list);
		System.out.println("list2:"+list2.size());  //看看是不是可以得到数据
		System.out.println("list2Data:"+list2.get(0).getLike()); //这里看看是不是可以得到里面的数据
	}
	//插入数据
	public static List<TestEntity> insert(){
		List<TestEntity> list = new ArrayList<TestEntity>();
		//模拟数据
		TestEntity t1 = new TestEntity("aa1", "xiaogo1");
		TestEntity t2 = new TestEntity("aa2", null);
		TestEntity t3 = new TestEntity("aa3", "xiaogo3");
		
		list.add(t1);
		list.add(t2);
		list.add(t3);
		return list;
	}
	
	//改变实体的值,这里应该要用泛型，因为我不确定返回的实体是什么，我不可能写死了撒，所以只能灵活的去用
	//然后一个，然后是通过collection可以去转换
	//首先不要那么复杂，我就返回一个多的好吧，恩，是的
	
	/**
	 * 泛型一般，是我输入一些参数，然后返回的时候的实体我没有写死，我可以在接收的时候把它给转换成我们需要的
	 * list集合的一种，在下面这个方法里面我输入的也是一个泛型，但是这样不好，一般我应该输入的是一些特定的参数，
	 * 返回的时候是一个泛型，
	 * 具体的可以参考以前张总写的代码，它连插入数据的时候都可以是泛型，真的是大神啊
	 * @param col
	 * @return
	 */
	public static <T> Collection<T> returnChangeEntity(Collection<T> col){
		List<T> list = (List<T>) col;  //强转成list类型

		return list;
	}
	
	
}
