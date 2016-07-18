package com.demoFile.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class DemoCreateFile {
	public static void main(String[] args) {
		//注意：如果aad文件夹不存在的话，会报错的，因为 file只会创建文件，不会创建文件夹
		//思路，要首先创建文件夹，后面创建文件，知道不，要结合起来一起用，很多事情，怎么说尼
		//可以参考 http://zhidao.baidu.com/link?url=BGBQEaj088cmx1isSH6RC_rxSf9BWxRvCOZbBnm3sxREPTqPr2cpkp73SI628fBjERrpFrq4hZddDlskXl4fb_
		DemoCreateFile df = new DemoCreateFile();
		//df.addFile();  //创建文件夹和文件
		String str = "fsdf打发士大夫";
		byte[] bt = new byte[1024];
		bt = str.getBytes(); // 转换成字节了
		
		//写入
		try {
			FileOutputStream fos = new FileOutputStream("d:/temp/file/addfile.txt");  //写入进去
			fos.write(bt, 0, bt.length);   //这个会把以前的都清楚
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//如何读出来
		try {
			//这里的编码格式，因为我是用eclipse的utf-8的，所有这样就是
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("d:/temp/file/addfile.txt"),"utf-8")); 
			String data = null;
			 //StringBuilder sb = new StringBuilder();
			while((data = br.readLine()) != null){
				System.out.println(data);
				//sb.append(data);  这里是把值放到sb里面去哈
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//写文件

	
	}
	
	public void addFile(){
		//因为这个文件是创建在文件夹下面去,这样就可以解决了
		String addfolder = "d:/temp/file";
		String addfile = "d:/temp/file/addfile.txt";
		
		File folder = new File(addfolder);
		if(!folder.exists()){
			folder.mkdirs();  
		}
		
		folder = new File(addfile);
		if(!folder.exists()){
			try {
				folder.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
