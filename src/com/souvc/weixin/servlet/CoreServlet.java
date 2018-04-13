package com.souvc.weixin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.souvc.weixin.service.CoreService;
import com.souvc.weixin.util.SignUtil;

/**
 * 类名: CoreServlet </br>
 * 描述: 来接收微信服务器传来信息 </br>
 */
public class CoreServlet extends HttpServlet {

	private static final long serialVersionUID = 4323197796926899691L;

	/**
	 * 确认请求来自微信服务器
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/**
		 * 微信加密签名
		 */
		String signature = request.getParameter("signature");
		/**
		 * 时间戳
		 */
		String timestamp = request.getParameter("timestamp");
		/**
		 * 随机数
		 */
		String nonce = request.getParameter("nonce");
		/**
		 * 随机字符串
		 */
		String echostr = request.getParameter("echostr");

		PrintWriter out = response.getWriter();

		/**
		 * 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		 */
		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			out.print(echostr);
		}

		out.close();
		out = null;
	}

	/**
	 * 处理微信服务器发来的消息
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String respXml = CoreService.processRequest(request);
		PrintWriter out = response.getWriter();
		// try {
		// 查询官方wiki 开头强调：
		// 假如服务器无法保证在五秒内处理回复，则必须回复“success”或者“”（空串），否则微信后台会发起三次重试。
		// Thread.sleep(10000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		out.print(respXml);
		out.close();
	}

}