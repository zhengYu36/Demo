package com.json.test;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 1.关于json数组数据的读取和测试类
 * 2.可以通过map的方式来存数据？
 * 
 * 特别说明：我们在用jackson的时候，最好采用readValue的方式，而且我们可以解析到实体中或是其他的什么地方，
 * 		    然后你不用实体，也可以用map来得到数据，至于数据里面的集合也是可以取到的
 *       当然，我们这个目前只是需要一些简单的应用，如果需要更加深入的应用，可以继续去研究下哈
 *       
 *       注意点哈：其实我觉得可以都用object或是用string类型哈(在实体中用的是Integer类型，但是在json中用的是字符串类型，但是
 *       也解析成功了，好吧，这些东西都太强大了)
 *       
 *       参考url:
 *       http://www.360doc.com/content/13/1114/16/203871_329189269.shtml
 * 
 * 2016年8月3日15:49:58
 * @author zhengYu
 *
 */

public class JsonArrayTest {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("关于测试读取json数组的操作");
		
		/**首先通过读取.txt里面的文件，这样是为了方便*/
		String jsonFileName = "src/sources/JsonValue.txt";
		String returnJson = ReadJsonFileUtil.returnJson(jsonFileName);
		System.out.println("returnJson is:"+returnJson);
		
		/**然后再来解析json里面的数据哈*/
		ObjectMapper mapper = new ObjectMapper();  //我要用的话，肯定需要首先实例化撒
		
		/**第一种：解析成实体,注意：实体和json里面的必须要对应好才行，当时如果是数字的哈，这个还是可以用的哈*/
		EntityTest t = mapper.readValue(returnJson, EntityTest.class);
		System.out.println("name:"+t.getName());
		System.out.println("age:"+t.getAge());
		
		/**第二种:直接解析,这里我们是解析成map了哈，如果map里面的key下面还是json,那么就会。。。。
		 * 应该会解析成List吧，晕。。。
		 * */
		
		//第一:通过readValue
/*		Map<String,Object> userData = mapper.readValue(returnJson, Map.class);   //然后这里我为什么要用readValue呢？
		String str1=(String) userData.get("name");  //这里可以直接得到name
		System.out.println("str1:"+str1); 
		
		//但是里面的employees应该是一个集合
		//List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> list = (List<Map<String, Object>>) userData.get("employees");
		if(list !=null && list.size()>0){
			for(Map<String, Object> map:list){
				System.out.println("firstName:"+map.get("firstName"));
				System.out.println("lastName:"+map.get("lastName"));
				System.out.println("####################");
			}
		}*/
		
		//下面我来通过readTree的方式来测试下看看哈  
/*		JsonNode node = mapper.readTree(returnJson);
		String str2 =  node.get("name").toString();
		System.out.println("str2:"+str2);  //"xiaoyu"，这个会把""这些特殊符号给打印出来，目前我也不知道有什么用处
*/		
	}
}
