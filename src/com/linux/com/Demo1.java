package com.linux.com;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {
	public static void main(String[] args) {
		WriteToLinux2 w2 = WriteToLinux2.getInstance();
		/**模拟得到的数据**/
		List<String> list = new ArrayList<String>();
		for(int i=0;i<376;i++){
			list.add("小光"+(i+1));
		}
		try {
			w2.insertDateByPageHelper(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}	
