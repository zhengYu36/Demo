package com.demo.test;

/**
 * 测试关于 截取CTGPC-20301字符串的方式哈
 * @author zhengYu
 *
 */
public class Demo15 {
	public static void main(String[] args) {
		System.out.println("----截取字符串开始---");
		
		String str = "CTGPC-20301";
		//String str1 = str.substring(0,3); //这个是包含0但是没有包含3，
		String str1 = str.substring(0,str.indexOf("-"));  //这个就是从开头取，然后到-(这个是不包含-的，这点要注意哈)结束
		System.out.println("str1:"+str1);  //str1:CTGPC
		
		String str2 = str.substring(0,str.indexOf("-")+4);    //这个就是公司下面的分公司了
		System.out.println("str2:"+str2);  //str2:CTGPC-203
		
		//String str3 = str.substring(0,str.indexOf("-")+4);    
		System.out.println("str3:"+str);  //str3:CTGPC-20301    //这个就是分公司下面的部门了
		
		/**
		 * 说明:目前这个级别就是这样来划分的，首先是查找所有的公司  ，后面是公司下面的分公司  ，最后是分公司下面的部门就好了
		 */
		
		//还要考虑到string里面有那个-的情况下哈
		String strx = "-1";
		boolean isok = str.contains(strx);  //str里面是否包含了strx
		System.out.println("isok is:"+isok);
		
		//通过/来拆分成一个数组
		System.out.println("拆分为数值通过/字符");
		String strByStaff = "company/CTGPC/32";
		String[] strSs = strByStaff.split("/");
		System.out.println("strSs length is:"+strSs.length);
		System.out.println("strs1 is:"+strSs[0]);
		System.out.println("strs2 is:"+strSs[1]);
		//System.out.println("strs3 is:"+strSs[2]);

		
		
	}
}
