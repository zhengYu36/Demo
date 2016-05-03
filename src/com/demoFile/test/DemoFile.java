package com.demoFile.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * @description 关于文件读的操作(重)
 * 很多时候要了解原理，要去操作一下才行，嗯，是的
 * @author zhengYu
 *
 */
public class DemoFile {
	public static void main(String[] args) {
		DemoFile demoFile = new DemoFile();
		String fileName = "D:/TestFile.txt";
		try {
			//读文件
			//通过fileReader的方式，这样是一个一个的读，效率有点慢
			//demoFile.fileReader(fileName);  
			
			//通过bufferedReader的方式，这样是一行一行的读
			demoFile.bufferedReader(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//我在方法后面抛出异常，就是在调用的时候，必须要抛出异常，这样的好处，是代码有点少
	public void fileReader(String fileName) throws Exception{
		FileReader fileReader = new FileReader(fileName);
		int ch = 0;
		while((ch = fileReader.read()) != -1){
			// 这里会打印出来，但是中文不行，这个是读字节,英文是可以读出来的
			System.out.println((char)ch);   // 转成成char
		}
	}
	
	//这种方式比较推荐，很不错的哈
	public void bufferedReader(String fileName) throws Exception{
		//BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		//下面这个是万一有乱码
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"GBK")); 
		String data = null;
		while((data = br.readLine()) != null){
			System.out.println(data);
		}
	}
}
