package com.souvc.weixin.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.souvc.weixin.message.bean.message;
import com.souvc.weixin.pojo.Token;
import com.souvc.weixin.thread.TokenThread;
import com.souvc.weixin.util.CommonUtil;

import net.sf.json.JSONObject;

public class Test extends HttpServlet{

	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	 
		
		
//		PrintWriter out = response.getWriter();
//		out.print(respXml);
//		out.close();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Token accesstoke=TokenThread.accessToken;
		
		//群发
// 		String groupUrl = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token="+accesstoke.getAccessToken(); 
// 		String group1data = "{\"filter\":{\"is_to_all\":false,\"group_id\":\"2\"},\"text\":{\"content\":\"群发消息测试\"},\"msgtype\":\"text\"}\";"; //这个是通过分组id发送的普通文本消息  
//		
		//根据openid群发
		String groupUrl1 = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token="+accesstoke.getAccessToken(); //这个地址是根据openid来群发消息  
//		String openid1data = "{\"touser\":[\"o8FfIw9cXn9XR5dnltJVXXlZUM1M\",\"o8FfIw7DymtJnmtv_6vXd8uDyWTM\"],\"msgtype\": \"text\",\"text\": {\"content\": \"测试群发信息\"}}"; 
		String openid1data = "{\"touser\":[\"o8FfIw9cXn9XR5dnltJVXXlZUM1M\",\"o8FfIw7DymtJnmtv_6vXd8uDyWTM\"],\"msgtype\": \"text\",\"text\": {\"content\": \"测试文本消息\"}}"; 
		
		
		message ms=new message();
		ms.setMsgtype("text");
		Map<String, String> text = new HashMap<String, String>();
		text.put("content", "测试");
		ms.setText(text);
	    String[] touser={"o8FfIw9cXn9XR5dnltJVXXlZUM1M"};
		ms.setTouser(touser);
		String json=JSONObject.fromObject(ms).toString();
		System.out.println(json);
		
		JSONObject jsonObject = CommonUtil.httpsRequest(groupUrl1, "POST", openid1data);
		System.out.println(jsonObject.toString());
//		doPost(request, response);
	}
	
	
}
