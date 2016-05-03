package com.invoke.test;
import java.lang.reflect.Field;
/**
 * 这个是网上找的东西
 * @author zhengYu
 *
 */
public class ReflectClass3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p = new Person(1, "ctl", true, 'c', 2.0f, 2.0, 1L, (short) 1,
				(byte) 1);

		p.setId(0);
		p.setName("张三");
		p.setIsMen(true);
		p.setCh('c');
		p.setFloat_(2.0f);
		p.setDouble_(3.0);
		p.setLong_(2l);
		p.setShort_((short) 1);
		p.setByte_((byte) 2);
		reflect(p);
	}

	public static void reflect(Object obj) {
		if (obj == null)
			return;
		Field[] fields = obj.getClass().getDeclaredFields();
		String[] types1={"int","java.lang.String","boolean","char","float","double","long","short","byte"};
		String[] types2={"Integer","java.lang.String","java.lang.Boolean","java.lang.Character","java.lang.Float","java.lang.Double","java.lang.Long","java.lang.Short","java.lang.Byte"};
		for (int j = 0; j < fields.length; j++) {
			fields[j].setAccessible(true);
			// 字段名
		  System.out.print(fields[j].getName() + ":");
			// 字段值
			for(int i=0;i<types1.length;i++){
				if(fields[j].getType().getName()
						.equalsIgnoreCase(types1[i])|| fields[j].getType().getName().equalsIgnoreCase(types2[i])){
					try {
						System.out.print(fields[j].get(obj)+"     ");
					} catch (Exception e) {
						e.printStackTrace();
					} 
				}
			}
		}
	}
}

