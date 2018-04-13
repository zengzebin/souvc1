package com.souvc.weixin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.souvc.weixin.pojo.SNSUserInfo;
import com.souvc.weixin.pojo.WeixinOauth2Token;
import com.souvc.weixin.util.AdvancedUtil;

/**
 * 网页授权请求
 * 
 * @author hb
 *
 */
public class OAuthServlet extends HttpServlet {

	private static final long serialVersionUID = -1847238807216447030L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String code = request.getParameter("code");
		String state = request.getParameter("state");

		if (!"authdeny".equals(code)) {
			// 获取网页授权access_token

			String appId = "wx1220bd5d26516ec1";
			String appSecret = "46cd020be3ad67d853e8dd2301cf2a1c";

			WeixinOauth2Token weixinOauth2Token = AdvancedUtil.getOauth2AccessToken(appId, appSecret, code);
			// 网页授权接口访问凭证
			String accessToken = weixinOauth2Token.getAccessToken();
			String openId = weixinOauth2Token.getOpenId();
			SNSUserInfo snsUserInfo = AdvancedUtil.getSNSUserInfo(accessToken, openId);

			request.setAttribute("snsUserInfo", snsUserInfo);
			request.setAttribute("state", state);
		}
		// 跳转到index.jsp
		request.getRequestDispatcher("MyJsp.jsp").forward(request, response);
	}
}
