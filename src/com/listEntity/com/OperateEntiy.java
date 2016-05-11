package com.listEntity.com;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.entityChangeZero.com.TestEntity;

/**
 * 其实以前都有一个，只是后面没有搞来就算了，现在我重新来搞，应该是没有问题的哈
 * 哈哈，现在是可以的，没有什么问题了哦，哈哈，这样就可以去设置了哦，哈哈
 * @author zhengYu
 *
 */
public class OperateEntiy {
	public static void main(String[] args) throws Exception{
		System.out.println("-------test start------");
		List<TestEntity> list = new ArrayList<TestEntity>();
		TestEntity t1 = new TestEntity("aa1", "xiaogo1");
		TestEntity t2 = new TestEntity("aa2", null);
		TestEntity t3 = new TestEntity("aa3", "xiaogo3");
		TestEntity t4 = new TestEntity("aa4", null);
		list.add(t1);
		list.add(t2);
		list.add(t3);
		list.add(t4);
		System.out.println("like:"+list.get(0).getLike());
		System.out.println("name:"+list.get(1).getLike());
		
		//看看能不能被修改
		List<TestEntity> list2 = new ArrayList<TestEntity>();
		list2 = returnChangeEntity(list,"434",null);
		System.out.println("changelike:"+list2.get(0).getLike());
		System.out.println("changename:"+list2.get(1).getLike());
		System.out.println("changename:"+list2.get(3).getLike());
		System.out.println("changename:"+list2.get(2).getName());
		
	}
	
	/**
	 * 
	 * @param list  -- list泛型
	 * @param needChgValue  -- 需要改变里面什么值 eg:需要改变实体中等于null的 ,这里如果输入的是null,那么就是null,如果不是null,那么就是输入的那个
	 * @param changeName  -- 要改变成什么样子，eg：把null改变成0
	 * @return
	 */
	public static <T> List<T> returnChangeEntity(List<T> getlist,String changeName,String needChgValue) throws Exception{
		
		List<T> list = new ArrayList<T>();
		list = getlist;	
		if(list == null){
			return null;
		}
		
		try {
			//首先是循环遍历list得到所有的实体中的值(注意实体是不能有继承其他的实体,这个问题目前还是没有能够解决)
			for(int i=0;i<list.size();i++){
				Field[] fields = list.get(i).getClass().getDeclaredFields(); //得到全部方法
				for(int j=0;j<fields.length;j++){
					Field field = fields[j]; //得到方法
					field.setAccessible(true);  //晕，这里刚刚忘记写了，所以一直出错
					
					//得到方法的值
					String getValue = (String) field.get(list.get(i));
					if(needChgValue == null){
						if(getValue == needChgValue){  //如果值等于null
							field.set(list.get(i), changeName);  //就改变成需要的值
						}
					}else{
						if(needChgValue.equals(getValue)){  //如果值等于null
							field.set(list.get(i), changeName);  //就改变成需要的值
						}
					}
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
