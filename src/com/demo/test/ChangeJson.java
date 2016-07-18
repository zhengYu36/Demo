package com.demo.test;


/**
 * 测试一下转换json的方法哈
 * @author zhengYu
 */

public class ChangeJson {
	
	/**
	 *
	   把[101.82415672895092,36.59897983405301,323,232], [101.82441397282759,36.59744338910201,343,343 ] 转换为
	 101.82415672895092:36.59897983405301:323:232; 101.82441397282759:36.59744338910201:343:343 ;
	   但是在这里要注意去掉空格
	 * @return
	 */
	public static String changeFormat(String oldStr){
		if(oldStr == null){
			return null;
		}
		String infoString = oldStr;
		
		//首先替换"
      infoString = infoString.replace("\"", "");
      
      //替换[]等符号
      infoString = infoString.replace("[", "");
      infoString = infoString.replace("]", "");
      //然后弄成数值组（这个的个数一定要是偶数才可以哈）
      String[] infos = infoString.split(","); 
      String newString = "";  //返回 拼装后的 json 字符串格式
      if(infos.length % 2 == 0){  // %2为0说明是偶数,说明格式是正确的，不然返回null
      	//下面要拼装哈,同时还要判断测试是否都是数字
      	for(int i=1;i<=infos.length;i++){  //i从1开始，是为了便于拼装json字符串
           if(i % 4 != 0){ 
      			newString = newString + infos[i-1].trim() + ":";
      		}else{ 
      			newString = newString + infos[i-1].trim() + ";";
      		}
      	 }
      }else{
      		return null;  //返回null
      } 
		return newString;
	}
	
	public static void main(String[] args) {
		//下面是测试数据哈
		String strs = "{\"FINGERINFO\":\"[10,36,43,23],[12,35,44,32]\"}";  //这个是要测试的json
		
		String strs1 = "[10,36,,23],[12,35,44,32]";  //这里无这个值也是考虑了的哈
		String strs2 = changeFormat(strs1);
		System.out.println("strs2:"+strs2);
		
		String[] strs3 = strs2.split(";");
		System.out.println("strs3length~~~"+strs3.length);
		System.out.println("str3 on 1~~~~~"+strs3[strs3.length-1]);
		
		System.out.println("yyyyyyyyyyyy");
		String xx1 = "12:35::32";
		String[] xx2 = xx1.split(":");
		System.out.println("xx2 length is:~~~"+xx2.length);
		System.out.println("xx2 is:~~~"+xx2[2]);
		
	}
}
