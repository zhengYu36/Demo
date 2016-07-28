package com.javaben.test;

import javax.xml.crypto.Data;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;



/**
 * 去掉java bean中的空哈
 * @author zhengYu
 *
 */
public class DemoWipeOffBean {

	public static void main(String[] args) throws Exception {
		DemoBean data = new DemoBean();
		data.setId("1001");
		data.setName("小宇");
		data.setAge("");
		data.setLike("   ");

		//这个是用jackson中的序列化来把javabean中的空给去掉，这个东西非常不错，很可以的哈，加油
		ObjectMapper om = new ObjectMapper();
		om.setSerializationInclusion(Include.NON_EMPTY);

		System.out.println(om.writeValueAsString(data));

		} 
}
