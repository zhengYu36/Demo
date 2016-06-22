package com.statictest.com;

/**
 * 开始测试我在实例化TestStatic的时候会不会执行static方法
 * @author zhengYu
 *
 */
public class Test1 {
	public static void main(String[] args) {
		/*System.out.println("test start----------");
		TestStatic t1 = new TestStatic();  //这个时候它会执行那个static的方法的
		System.out.println("test end----------");*/
		
		//下面测试static类的东西哈
		System.out.println("test teststatic2 start.....");
		//TestStatic2 t2 = new TestStatic2();
		//t2.test();
		TestStatic2.test();  //这个时候就算我不实例化它，但是它也要去执行static中的方法
		System.out.println("test end ----");
	}
}
