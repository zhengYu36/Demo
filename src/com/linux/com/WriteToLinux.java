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
 * java 中文件写入到linux指定的文件夹下
 * @author zy
 *
 */
public class WriteToLinux {
	public static void main(String[] args) {
		System.out.println("写入到linux开始");
		try {
			/**模拟得到的数据**/
			List<String> list = new ArrayList<String>();
			for(int i=0;i<76;i++){
				list.add("小明"+(i+1));
			}
			
	        //判断list是否有数据哈
	        if(list ==null || list.size() <1){
	        	return;
	        }
	        getPageHelper(list);
			
			//StringBufferDemo(list);
			System.out.println("写入成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("写入失败");
		}
	}
	
	/**每次100条数据一取*/
	public static void getPageHelper(List<String> list) throws Exception{
		
		int sum = 910,pageSize=50;
		/*List<String> list = new ArrayList<String>();
		for (int i = 0; i < sum; i++) {
			list.add(i);
		}*/

		int totalSize = list.size();
		int totalPage = (totalSize - 1) / pageSize + 1;//页码，逢1进1
		if (totalSize < pageSize) {
			pageSize = list.size();
		}

		for(int i = 0; i < totalPage; i++){
			int pageNo = i+1;
			List<String> sublist = list.subList((pageNo-1)*pageSize, pageNo*pageSize>totalSize ? (totalSize) : pageNo*pageSize);
			//System.out.println("第" + pageNo + "次保存" + pageSize + "条数据到数据库....");
			//System.out.println(sublist);//每次循环保存的数据输出
			//打印
			for(int j=0;j<sublist.size();j++){
				System.out.println("pag1:"+sublist.get(j));
			}
			
			//默认延迟一秒执行
			try
			{
			    Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
			    e.printStackTrace();
			}
			StringBufferDemo(sublist);
			System.out.println("=======ttt======");
			System.out.println("len:"+sublist.size());
		}
	}
	
	/**得到系统当前时间**/
	public static String getCurrent(){
		String str = "";
		Date date = new Date();  
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss"); 
		str = format.format(date);
		System.out.println("str:"+str);
		
        //System.out.println("ttt:"+format.format(date));  
		return str;
	}
	
	/**写文件具体方法,这个方法里面只会来写入数据的，其他的业务逻辑不需要**/
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
