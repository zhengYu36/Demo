package com.demoFile.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/***
 * file创建文件
 * 如果文件夹不存在，那么同时还要把文件夹给创建下哈
 * @author lenovo
 *
 */
public class Demo2 {
	public static void main(String[] args) {
		Demo2 demo2 = new Demo2();
		try {
			//demo2.createFile();  //写入数据
			demo2.readFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//读文件
	public void readFile() throws Exception{
		String addFile = "e:/filetest/one/test1.txt";
		File file = new File(addFile);
		/*FileReader in = new FileReader(file);
		StringBuffer str1 = new StringBuffer();
		while(!in){
			//str1.append(in);
			System.out.println(in+"");
		}*/
		
		  FileReader fr = new FileReader(file); 
	      char [] a = new char[50];
	      fr.read(a); // 读取数组中的内容
	      for(char c : a)
	          System.out.print(c); // 一个一个打印字符
	      fr.close();
		
		System.out.println("读数据成功");
		
	}
	
	//写文件
	public void createFile() throws Exception{
		String addFiloder = "e:/filetest/one";  //文件夹
		String addFile = "e:/filetest/one/test1.txt";
		
		File folder = new File(addFiloder);
		if(!folder.exists()){  //首先创建文件夹
			folder.mkdirs();
		}
		
		File file = new File(addFile);
		if(!file.exists()){
			file.createNewFile();
		}
		
		//模拟插入数据
		List<String> list = new ArrayList<String>();
		for(int i=0;i<10;i++){
			list.add("admin:"+i);
		}
		
		FileOutputStream out = new FileOutputStream(file, true);
		for(int i=0;i<list.size();i++){
			StringBuffer str = new StringBuffer();
			str.append(list.get(i));
			
			out.write(str.toString().getBytes("utf-8"));
			//换行
			byte[] bytes = "\r\n".getBytes();
			out.write(bytes);
		}
		
		out.close();
		
		String currClaName = this.getClass().getSimpleName();
		String currMetName = Thread.currentThread().getStackTrace()[1].getMethodName();
		
		System.out.println(currClaName + "---" + currMetName +":写入数据成功");
		
	}
	
}
