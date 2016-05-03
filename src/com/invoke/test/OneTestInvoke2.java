package com.invoke.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
	下面来模拟，输入一个属性名，然后返回那一个集合里面的和，这个是在实际开发中遇到的问题
	这个应该要结合到泛型来就可以了
 * @author zhengYu
 *
 */
public class OneTestInvoke2 {

	public static void main(String[] args) throws Exception{
		
		//首先测试反射
		//给一个集合里面插入数据
		List<TestEnttity> list = new ArrayList<TestEnttity>();
		TestEnttity t1 = new TestEnttity("36", "16", "20");
		TestEnttity t2 = new TestEnttity("40", "20", "20");
		TestEnttity t3 = new TestEnttity("56", "23", "33");
		
		list.add(t1);
		list.add(t2);
		list.add(t3);
		
		//下面通过反射的方法去得到需要数据的和 -- 这样的话，我的属性名就可以动态的去输入了
		String sum = returnCountByType(list,"All_Lines");
		
	}
	
	//返回需要属性的所有和 
	//type 属性名
	public static String returnCountByType(List<TestEnttity> list,String type) throws Exception{

		//Class<?> classType = TestEnttity.class;//得到测试类
		//Object invokeInstance = classType.newInstance(); //得到实例化
		//Class a = Class.forName("TestEnttity");
		
		

		System.out.println("0000xxx:"+list.get(0).getAll_Lines());
		int sum = 0; // 总和
		String str = type;
		for(int i=0;i<list.size();i++){

			Field field = list.get(i).getClass().getDeclaredField(str);
			Type gType = field.getGenericType();
			ParameterizedType pType = (ParameterizedType)gType;
			System.out.println(pType.getActualTypeArguments()[0]);
			
			//Field[] fields=list.get(i).getClass().getDeclaredFields();
			//System.out.println("xxx:"+fields.length);
			
			//遍历
			//for(Field field:fields){
				//field.setAccessible(true);
				//获取一个属性
				//String name = field.getName();
				//String value= (String) field.get("get"+str);
				//获取该属性的值，可能为空
				//Object value = field.get(name);
				//System.out.println("name:"+name);
				//System.out.println("value"+value);
			//}
			//System.out.println("============");
			//Field field=list.get(i).getClass().getField("get"+str);/////这个对应的是属性
			//System.out.println("xxx1："+field.getName());
	       // String fieldValue=field.get(obj);////这个就是属性的值
			
		//	Method getMethod = list.get(i).getClass().getMethod("get"+str, new Class[]{}); //得到方法了，要得到该方法中的值
		//	System.out.println("xxx:"+getMethod);
			
			//去执行方法
			//Object resultGetObject = getMethod.invoke(invokeInstance, new Object[]{});
			
		//	System.out.println("xxx1111:"+);
			//Object invokeInstance = classType.newInstance(); //得到实例化
			//Object resultGetObject = getMethod.invoke(invokeInstance, new Object[]{});
			//Object resultGetObject = getMethod.invoke(, new Object[]{});
			//sum = sum + (Integer)resultGetObject;
			
/*			//获取get类---这样可以得到值
			Method getMethod = classType.getMethod("get"+str, new Class[]{});
			//调取
			Object resultGetObject = getMethod.invoke(invokeInstance, new Object[]{});
			//System.out.println("getXXX:"+(String)resultGetObject);
			sum = sum + (Integer)resultGetObject;*/
		}
		
		//System.out.println("sum:"+sum);
		return sum+"";
	}
}
