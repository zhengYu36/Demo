package com.classTest.test;

/***
 * 关于测试class的一些方法和api哈，这里就是如果不用log的话哈，嗯，试试看
 * @author zy
 *
 */
public class Test1 {
	public static void main(String[] args) {
		System.out.println("#==================#");
		Test1 t1 = new Test1();  //如果要用  this.getClass().getSimpleName() 那么方法就不能是static的
		t1.test123();
	}
	public void test123(){
		System.out.println("test123 is 1:"+this.getClass().getName());   //这个是得到当前类的名字(加上包名)
		//得到当前方法名
		String getMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println("current method name is :"+getMethodName);
	}
}
