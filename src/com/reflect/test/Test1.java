package com.reflect.test;

/**
 * 测试看看是不是可以反射得到父类的东西
 * http://www.360doc.com/content/14/0908/20/13815587_408002430.shtml
 * @author zhengYu
 *
 */
public class Test1 {

	public static void main(String[] args) {
		
		//赋值
		TestSon obj = new TestSon();
		obj.setCity("guanan");
		obj.setLike("pingping");
		obj.setName("xiaoyu");
		
		 //我日这样是可以的得到的嘛
	     System.out.println("原来的各个属性的值: ");  
	     System.out.println("city = " + FieldUtil.getFieldValue(obj, "city"));
	     System.out.println("like = " + FieldUtil.getFieldValue(obj, "like"));
	     
	     System.out.println("---下面是来测试赋值的...");
	     TestSon obj1 = new TestSon();
	     FieldUtil.setFieldValue(obj1, "city", "abc") ;  
	     FieldUtil.setFieldValue(obj1, "like", "play") ;  
	     System.out.println("将属性值改变后的各个属性值: ");  
	     System.out.println("citychange = " + FieldUtil.getFieldValue(obj1, "city"));
	     System.out.println("likechange = " + FieldUtil.getFieldValue(obj1, "like"));
	}
}
