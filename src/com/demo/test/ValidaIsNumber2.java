package com.demo.test;

/**
 * 验证是否是数字
 * 资源，网上找的方法 - 这个是用异常的操作来进行的
 * 通过一个实际的例子来进行测试哈
 * @author zhengYu
 *
 */
public class ValidaIsNumber2 {
	public static void main(String[] args) {
		System.out.println("验证String是否是数字----start");
		String tx = "\"[101.82415672895092,36.598979834a05301],[101.82441397282759,36.59744338910201]\"";
		String str = changeFormat(tx);
		System.out.println("isok:"+str);
		
		if(str == null){
			System.out.println("1111xxx");
		}else {
			System.out.println("2222xxx");
		}
	}
	
	//这个是用正则表达式的方式来进行的
	public static boolean isNum(String str){
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	}
	
	public static String changeFormat(String oldStr){
		if(oldStr == null){
			return null;
		}
		
		String infoString = oldStr;
		
		//首先替换"
        infoString = infoString.replace("\"", "");
        
        //替换[]等符号
        infoString = infoString.replace("[", "");
        infoString = infoString.replace("]", "");  //现在这里的格式为:101.82415672895092, 36.59897983405301, 101.82441397282759,36.59744338910201 
        //然后弄成数值组（这个的个数一定要是偶数才可以哈）
        String[] infos = infoString.split(","); 
        String newString = "";  //返回 拼装后的 json 字符串格式
        if(infos.length % 2 == 0){  // %2为0说明是偶数,说明格式是正确的，不然返回null
        	//下面要拼装哈,同时还要判断测试是否都是数字
        	for(int i=1;i<=infos.length;i++){  //i从1开始，是为了便于拼装json字符串
        		
        		if(isNum(infos[i-1].trim())){
            		if(i % 2 != 0){ //奇数
            			newString = newString + infos[i-1].trim() + ":";  //还要去掉一次空格才行
            		}else{ //偶数
            			newString = newString + infos[i-1].trim() + ";";
            		}
        		}else{
        			return null;  //只有有一个格式不对，就结束循环
        		}	

        		
        	}
        }else{
        	return null;  //返回null
        }
       
		return newString;
	}
}
