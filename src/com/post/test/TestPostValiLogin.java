package com.post.test;

/**
 * 参数post方式
 * @author zhengYu
 *
 */
public class TestPostValiLogin {
	
	
	public static void main(String[] args) {
		
		//这个是post的方式，这个是可以这用的，这里我调取成功了
		String sp=HttpRequest.sendPost("http://10.37.10.106:8080/scales/user/login.do", "username=tgpms1&password=tgpmssmpgt&tns=tgpmstest"); //通过get是可以把值放入进去的
		System.out.println(sp);
		//返回就 success 或 other_wrong ?如果以后这个数据有差异的话，这里应该要多有几个就可以了哈
		
		//http://localhost:8080/sharing/rs/v1/validateLogin?username=tgpms&password=tgpmssmpgt
		//下面用去调取我的接口，看看是否有接口哈
		/*String sp1=HttpRequest.sendGet("http://localhost:8080/sharing/rs/v1/validateLogin", "username=tgpms&password=tgpmssmpgt"); //通过get是可以把值放入进去的
		System.out.println(sp1);*/
		
	}
}
