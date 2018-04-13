package com.souvc.weixin.servlet;

/*
 * 请求appid与appsecret，只到服务器，没有到页面
 * 在 web.xml 里面配置
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.souvc.weixin.thread.TokenThread;
import com.souvc.weixin.util.CommonUtil;

public class InitServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(CommonUtil.class);

	@Override
	public void init() throws ServletException {

		TokenThread.appid = getInitParameter("appid");
		TokenThread.appsecret = getInitParameter("appsecret");

		log.info("weixin api appid:{}", TokenThread.appid);
		log.info("weixin api appsecret:{}", TokenThread.appsecret);
		if ("".equals(TokenThread.appid) || "".equals(TokenThread.appsecret)) {
			log.error("appid and appsecret configuration error, please check carefully.");
		} else {
			new Thread(new TokenThread()).start();
		}
	}

}
