package com.linux.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/***
 * java  单例模式
 * @author zy
 *
 */
public class WriteToLinux2 {
	
	 private static WriteToLinux2 uniqueInstance = null;
	 
	    private WriteToLinux2() {
	    	
	    }
	   
	    
	    //首先实例化哈
	    public static WriteToLinux2 getInstance() {
	       if (uniqueInstance == null) {
	           uniqueInstance = new WriteToLinux2();
	       }
	       return uniqueInstance;
	    }
	    
	    
		/**插入数据 根据  指定需要的数据条数*/
		public static void insertDateByPageHelper(List<String> list) throws Exception{
			//判断list是否有数据哈
	        if(list == null || list.size() <1){
	        	return;
	        }
			int pageSize=200;   //默认每页数据
			int totalSize = list.size();
			int totalPage = (totalSize - 1) / pageSize + 1;//页码，逢1进1
			if (totalSize < pageSize) {
				pageSize = list.size();
			}

			for(int i = 0; i < totalPage; i++){
				int pageNo = i+1;
				List<String> sublist = list.subList((pageNo-1)*pageSize, pageNo*pageSize>totalSize ? (totalSize) : pageNo*pageSize);
				/**这里为了防止系统执行太快， 默认延迟一秒执行**/
				try
				{
				   Thread.sleep(1000);
				}
				catch (InterruptedException e)
				{
				    e.printStackTrace();
				}
				StringBufferDemo(sublist);  //去写入数据
			}
		}
	    
	    
		/**得到系统当前时间**/
		public static String getCurrent(){
			Date date = new Date();  
			DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss"); 
			return format.format(date);
		}

		/**写入数据到指定的位置**/
		public static void StringBufferDemo(List<String> list) throws IOException {

	        File file=new File("E:/SMS_file_"+getCurrent()+".txt");
	        file.exists();
	        if(!file.exists())
	            file.createNewFile();
	        FileOutputStream out=new FileOutputStream(file,false);         
	        for(int i=0;i<list.size();i++){
	        	StringBuffer sb=new StringBuffer();
	            sb.append(list.get(i));
	            out.write(sb.toString().getBytes("utf-8"));
	            //使换行符转为字节数组  
	            byte []newLine="\r\n".getBytes();    //还可以有另外一种方式（） 在unix下的是"\n";
	            //写入换行  
	            out.write(newLine); 
	        }
	        out.close();
	    }
	
}
