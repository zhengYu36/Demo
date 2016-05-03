package com.invoke.test;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 自己来根据网上的来测试
 * 哈哈，是可以的，哈哈，真的好安逸
 * 
 * 我这样就可以得到我想要的结果了
 * 就是我得到List<Entity>中的某一个方法的值了
 * @author zhengYu
 *
 */
public class SuccessTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<TestEnttity> list = new ArrayList<TestEnttity>();
		TestEnttity t1 = new TestEnttity("36", "16", "20");
		TestEnttity t2 = new TestEnttity("40", "20", "20");
		TestEnttity t3 = new TestEnttity("56", "23", "33");
		
		list.add(t1);
		list.add(t2);
		list.add(t3);
		
		//下面这个是给泛型用的看看
		List<TestEnttity2> list1 = new ArrayList<TestEnttity2>();
		TestEnttity2 t12 = new TestEnttity2("136", "216", "320");
		TestEnttity2 t22 = new TestEnttity2("140", "220", "330");
		TestEnttity2 t32 = new TestEnttity2("156", "223", "333");
		
		
		list1.add(t12);
		list1.add(t12);
		list1.add(t12);
		
		try {
			//reflect2(list,"All_Lines");
			
			reflect3(list1,"All_Lines1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//方法1 -- 通过循环
	public static void reflect(List<TestEnttity> list,String name) {
		if (list == null)
			return;
		
		for(int k=0;k<list.size();k++){
			Field[] fields = list.get(k).getClass().getDeclaredFields(); //得到方法
			String[] type1 = {"java.lang.String"};
			String[] type2 = {"java.lang.String","java.lang.String","java.lang.String"};  //这么目前是没有用的
			for(int j = 0;j<fields.length;j++){
				fields[j].setAccessible(true);
				//字段名
				//System.out.println(fields[j].getName() + "~:");
				
				//这里这个字段名，是根据我上面输入的来进行
				if(fields[j].getName().equals(name)){
					//字段值
					for(int i=0;i<type1.length;i++){ //我现在只有这么一个类型
						//System.out.println("333:"+fields[j].getType().getName());
						if(fields[j].getType().getName().equalsIgnoreCase(type1[i])){
							try {
								//System.out.println("xxxx:"+fields[j].get(list.get(k))+"   ");
								System.out.println(fields[j].get(list.get(k))+"     ");
							} catch (Exception e) {
								e.printStackTrace();
							} 
						}
					}
				}

			}
			
			System.out.println("----------------------");
		}

	}
	
	//方法2：方法我是知道的
	public static void reflect2(List<TestEnttity> list,String name) throws Exception{
		if (list == null)
			return;
		for(int k=0;k<list.size();k++){
			Field fields = list.get(k).getClass().getDeclaredField(name); //得到方法
			
			fields.setAccessible(true);
			//这里这个字段名，是根据我上面输入的来进行
			String[] type1 = {"java.lang.String"};
			if(fields.getType().getName().equalsIgnoreCase(type1[0])){
				try {
					//System.out.println("xxxx:"+fields[j].get(list.get(k))+"   ");
					System.out.println(fields.getName()+":"+fields.get(list.get(k)));
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
			System.out.println("222----------------------");
		}

	}
	
	//方法3:通过泛型的方式 -- 哈哈我测试看看
	public static <T> void reflect3(List<T> list,String name) throws Exception{
		if (list == null)
			return;
		for(int k=0;k<list.size();k++){
			Field fields = list.get(k).getClass().getDeclaredField(name); //得到方法
			
			fields.setAccessible(true);
			//这里这个字段名，是根据我上面输入的来进行
			String[] type1 = {"java.lang.String"};
			if(fields.getType().getName().equalsIgnoreCase(type1[0])){
				try {
					//System.out.println("xxxx:"+fields[j].get(list.get(k))+"   ");
					System.out.println(fields.getName()+":"+fields.get(list.get(k)));
					//int sum = (int) fields.get(list.get(k));
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
			System.out.println("------------333----------");
		}

	}
	
	//方法4：这个方式是去修改里面的值，不过方法我就没有去完善了，我有链接，到时候自己可以去参考
	//在action中的参考文件里面
}

