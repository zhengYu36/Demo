package com.demo.test;

import java.util.Date;
import java.util.Random;

public class Demo6 {
	public static void main(String[] args) {
		System.out.println("dfdf");
		
		Random random = new Random();
		//这个是rowkey的规则
		//Put put=new Put(Bytes.toBytes(
		//sdf.format(new Date()) + "" + (random.nextInt(90000) + 10000)));//添加一条数据rowkey
		
		System.out.println(new Date());
		
		System.out.println(random.nextInt(90000) + 10000);
	}
}
