package com.restful.test;


/**
 * 单元测试
 * 功能描述:人员信息的采集
 * @author zhengYu
 *
 */

public class Test1 {

	//private static String url = "http://10.37.88.100:8080/tgpms/service";  //tgpms 人员信息采集接口url 
	
	private static String url = "http://localhost:8080/sharing/rs/v1";
	
	
	public static void main(String[] args) {
    	
		System.out.println("tttttttt");
		
    	String json="{\"workerId\":\"CHEN_JILIN17\",\"userName\":\"陈吉林4\",\"idenCard\":\"500237198802151234\","
    			+ "\"gender\":\"M\",\"addrFam\":\"四川省成都市高新区\",\"cellphone\":\"15812345678\",\"companyCode\":\"SXJJFZ\","
    			+ "\"postCode\":\"0101\",\"inTime\":\"2016-06-29 14:55:22\",\"outTime\":\" \",\"contactName\":\"李阳\","
    			+ "\"contactPhoneNum\":\"15812345679\"}";

    	//通过httprequest的方式来给json值哈

	   	 String namethod = "PerInfCollectionPos";
	     String getObj = HttpRequest.sendPostByJson(url+"/PerInfCollectionPos/1",json); 
	     System.out.println("getObj:"+getObj);
    	
	}



}
