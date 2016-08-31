package com.list.behavior.test;

import java.util.ArrayList;  
import java.util.Collections;  
import java.util.HashMap;  
import java.util.HashSet;  
import java.util.List;  
import java.util.Map;  
import java.util.Set;  
import java.util.TreeMap;  
   
public class CountDuplicatedList {  
   
    public static void main(String[] args) {  
   
    	/**
    	 * 这里的数据目前都不考虑为null的情况哈
    	 * 这里的例子是找的网上哈
    	 */
        List<String> list = new ArrayList<String>();  
/*        list.add("a");  
        list.add("b");  
        list.add("c");  
        list.add("d");  
        list.add("b");  
        list.add("c");  
        list.add("a");  
        list.add("a");  
        list.add("a");  */
		list.add("13508295760+13990463001");  //模拟主叫和被叫，中间通过+来连接哈
		list.add("13508295760+13568683894");  //模拟主叫和被叫，中间通过+来连接哈
		list.add("13508295760+15082305186");  //模拟主叫和被叫，中间通过+来连接哈
		list.add("13508295760+13990463001");  //模拟主叫和被叫，中间通过+来连接哈
		list.add("13508295760+13990463001");  //模拟主叫和被叫，中间通过+来连接哈
		list.add("15082305186+18783638613");  //模拟主叫和被叫，中间通过+来连接哈
		list.add("18783648860+15984732660");  //模拟主叫和被叫，中间通过+来连接哈
		list.add("13518448530+15984732660");  //模拟主叫和被叫，中间通过+来连接哈
		list.add("13518448530+13508298370");  //模拟主叫和被叫，中间通过+来连接哈
		list.add("13508295760+15082305186");  //模拟主叫和被叫，中间通过+来连接哈
		list.add("13508298370+15984732660");  //模拟主叫和被叫，中间通过+来连接哈
		list.add("13568683894+13568683894");  //模拟主叫和被叫，中间通过+来连接哈
		list.add("13508295760+15082305186");  //模拟主叫和被叫，中间通过+来连接哈
   
  /*      System.out.println("\n例子1 - 计算'a'出现的次数");  
        System.out.println("a : " + Collections.frequency(list, "a"));  */
   
        System.out.println("\n例子2 - 计算所有对象出现的次数");  
        Set<String> uniqueSet = new HashSet(list);  
        
        List<String> listGt3 = new ArrayList<String>();    //打印等于3次出现的数据哈
        for (String temp : uniqueSet) {  
        	
            System.out.println(temp + ": " + Collections.frequency(list, temp));   //这个可以得到次数哈
            //下面我是如果出现了三次及其以上的就保存下来，然后重新放到一个List中去哈
            if( Collections.frequency(list, temp) >=3){
            	listGt3.add(temp);
            }
            
            
            //。。。。。算了，我还是在下面来考虑这个逻辑吧，恩，是的
        }  
        
        //打印出来看看哈
        for(String temp : listGt3){
        	System.out.println("三次及其以上的通话记录哈:"+temp);
        }
        
        
        /**
         * 关于只打不接意味着电话只出现在主叫人中而被叫人没有给主叫人的呼叫记录。
         * 这个就是说，它们换一个顺序后没有出现一次
         * eg:13508295760+15082305186  + 号前面的是呼叫  ，+后面的是被叫，这条数据是从listGt3得到的
         * 表示 13508295760 给 15082305186打了三个及其以上的吉林
         * 如果15082305186 没有一次给13508295760打电话，那么 这条记录就符合 13508295760只呼不打这个情况了
         * 
         * 那么这个时候我们应该电话号码反起来查一次看看哈
         * 
         */
        
       //首先遍历数据哈
        for(int i=0;i<listGt3.size();i++){
        	String str1= listGt3.get(i);  //得到数据（老数据）  eg： 13508295760+15082305186 
        	String[] strs = str1.split("+");
        	String str2= strs[1]+strs[0];  // 这里是电话号码反过来的string哈     eg: 15082305186+13508295760
        	
        	
        	int num = Collections.frequency(list, str2);  //这里是得到指定的字符串哈
        	if(num>0){  //大于0说明，这个数据存在了，这个时候这个数据就不对啊
        		//listGt3.remove(this);
        		listGt3.remove(i);//然后移除不符合条件的数据
        		
        		/***
        		 * 注意：现在的数据， 对前面这个号码来说，是对后面的只打不接，
        		 *  对后面的号码而言：   前面的号码都是只接不打
        		 */
        	}
        	
        	
        }
        
   
    }  
   

}  