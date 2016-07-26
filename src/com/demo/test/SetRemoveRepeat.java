package com.demo.test;

import java.util.HashSet;
import java.util.Set;

/**
 * set去除重复的数据
 * 详情参考:
 * http://blog.csdn.net/miqi770/article/details/8998517
 * @author zhengYu
 *
 */
public class SetRemoveRepeat {
	public static void main(String[] args) {
		System.out.println("去除重复数据开始~~~~~~~~");
		Set<String> nameSet = new HashSet<String>();  
        nameSet.add("张三");  
        nameSet.add("李四");  
        nameSet.add("王五");  
        nameSet.add("张三");  
          
        // 输出结果 张三  李四  王五  
        for(String name : nameSet){  
            System.out.print(name + "\t");  
        }  
	}
}
