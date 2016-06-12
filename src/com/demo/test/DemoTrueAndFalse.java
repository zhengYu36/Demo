package com.demo.test;
/**
 * 测试断点的执行，f5表示会进入到方法里面去，f6会跳过方法，往下面执行
 * @author zhengYu
 *
 */
public class DemoTrueAndFalse {
	public static void main(String[] args) {
		/*System.out.println("xxxxx");
		boolean isok = true;
		if(isok == true){
			System.out.println("xxx1");
		}else {
			System.out.println("xxx2");
		}*/
		
		String objid = "1,2,3,4";
		String objid2 = "13432";
		String strsString = objid.replace("\"", ""); //去掉"
		String[] sts = strsString.split(",");
		System.out.println("str:"+sts);
		
		System.out.println("sdfds1:"+objid.contains(","));
		System.out.println("sdfds2:"+objid2.contains(","));
		
	}
}
