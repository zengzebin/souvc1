package com.souvc.weixin.demo;

import java.util.HashMap;
import java.util.Map;

import com.souvc.weixin.message.req.Template;
import com.souvc.weixin.thread.TokenThread;
import com.souvc.weixin.util.CommonUtil;

import net.sf.json.JSONObject;

public class TemplateMessage {

	public static void test1() {
		String url = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token="
				+ "Qe78XXRlkSCT4xXI3Hjd4kno6oOQVr6ERaw0gAS6n1lqNz9HmLVZluvAjAa6FohpU4e6zWrF7k0ODcSa-c6KvyyZbehIgYm7JdouaqhuWHuwwnhLjfSvgCPstEVAUfOOHATaAAABUN";
		Map map = new HashMap();
		map.put("industry_id1", 1);
		// map.put("industry_id2", 4);

		String json = JSONObject.fromObject(map).toString();
		System.out.println(json);
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", json);
		System.out.println(jsonObject.toString());

	}

	public static void test2() {
		String url = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token="
				+ "Qe78XXRlkSCT4xXI3Hjd4kno6oOQVr6ERaw0gAS6n1lqNz9HmLVZluvAjAa6FohpU4e6zWrF7k0ODcSa-c6KvyyZbehIgYm7JdouaqhuWHuwwnhLjfSvgCPstEVAUfOOHATaAAABUN";
		Map map = new HashMap();
		map.put("industry_id1", 1);
		// map.put("industry_id2", 4);

		String json = JSONObject.fromObject(map).toString();
		// System.out.println(json);
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "GET", null);
		System.out.println(jsonObject.toString());
	}

	public static void sendTemplate() {
		String url="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=8_EDdloOoD9ypn35UrlvhZs9ZIc9ga5PIJ_rrNe6plpO2vzoH3QfTncvtyZhs1Buq4H_q5RCpYETwTVpFZjEuz6MLFAUHQf6Y3VUFPACWTen8YsGh3CRxIGrA-Zs-ZK9Q3QZMBlYaPGSfNClLgJCGiAGAMFJ";
		Template t = new Template();
		t.setTemplate_id("wJrmTq81tB0EK8oMkRAr9KJF153Y8_mnjiRxTHJY2Qg");
		t.setUrl("http://weixin.qq.com/download");
		t.setTouser("o8FfIw9cXn9XR5dnltJVXXlZUM1M");
		Map<String, Map<String, String>> map = new HashMap<String, Map<String, String>>();
		Map<String, String> bin1 = new HashMap<String, String>();
		bin1.put("value", "恭喜你购买成功");
		bin1.put("color", "#173177");
		map.put("bin", bin1);
		t.setData(map);
		String json = JSONObject.fromObject(t).toString();
		System.out.println(json);
		JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", json);
		System.out.println(jsonObject);
	}

	public static void main(String[] args) {
		TemplateMessage.sendTemplate();
	}
}
