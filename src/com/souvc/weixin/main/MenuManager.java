package com.souvc.weixin.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.souvc.weixin.pojo.AccessToken;
import com.souvc.weixin.pojo.Button;
import com.souvc.weixin.pojo.ClickButton;
import com.souvc.weixin.pojo.ComplexButton;
import com.souvc.weixin.pojo.Menu;
import com.souvc.weixin.pojo.ViewButton;
import com.souvc.weixin.thread.TokenThread;
import com.souvc.weixin.util.WeixinUtil;

/**
 * 微信菜单栏设置
 * 
 * @author hb
 *
 */
public class MenuManager {

	private static Logger log = LoggerFactory.getLogger(MenuManager.class);

	public static void main(String[] args) {
		/**
		 * 微信二次开发所必需的两个参数 appId appSecret
		 */
		String appId = "wx1220bd5d26516ec1";
		String appSecret = "46cd020be3ad67d853e8dd2301cf2a1c";

		AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);
		if (null != at) {
			// 调用接口创建菜单
			int result = WeixinUtil.createMenu(getMenu(), at.getToken());
			if (0 == result) {
				log.info("菜单创建成功！");
			} else {
				log.info("菜单创建失败，错误码：" + result);
			}
		}
	}

	/**
	 * 组装菜单数据 待优化：把所需要填写的数据传到前端，由页面填写
	 */
	private static Menu getMenu() {

		ViewButton btn11 = new ViewButton();
		btn11.setName("公司简介");
		btn11.setType("view");
		btn11.setUrl("http://mp.weixin.qq.com/s/jNPD6F_dI6SEtykb0sXAUQ");

		ViewButton btn12 = new ViewButton();
		btn12.setName("团队成员");
		btn12.setType("view");
		btn12.setUrl("http://mp.weixin.qq.com/s/_Gf_DpHTR1yH03qX1mCRkg");

		ViewButton btn13 = new ViewButton();
		btn13.setName("中国建设产业网");
		btn13.setType("view");
		btn13.setUrl("http://www.zgjscyw.com/");

		ViewButton btn21 = new ViewButton();
		btn21.setName("生态运营");
		btn21.setType("view");
		btn21.setUrl("http://a3.rabbitpre.com/m/fUz2Yn2#10006-weixin-1-52626-6b3bffd01fdde4900130bc5a2751b6d1");

		ViewButton btn22 = new ViewButton();
		btn22.setName("生态开发");
		btn22.setType("view");
		btn22.setUrl("http://a3.rabbitpre.com/m/RRN3AbM#10006-weixin-1-52626-6b3bffd01fdde4900130bc5a2751b6d1");

		ViewButton btn23 = new ViewButton();
		btn23.setName("EIUI应用");
		btn23.setType("view");
		btn23.setUrl("http://c.eqxiu.com/s/CGrIofH4?eqrcode=1");

		ViewButton btn31 = new ViewButton();
		btn31.setName("网页授权1");
		btn31.setType("view");

		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx1220bd5d26516ec1&redirect_uri=http://shubin.tunnel.qydev.com/souvc1/oAuthServlet&response_type=code&scope=snsapi_userinfo&state=2#wechat_redirect";
		btn31.setUrl(url);
		ViewButton btn32 = new ViewButton();
		btn32.setName("分享js-sdk");
		btn32.setType("view");
		btn32.setUrl("http://shubin.tunnel.qydev.com/souvc1/test.jsp");

		/*
		 * ViewButton btn32 = new ViewButton(); btn32.setName("账户查询");
		 * btn32.setType("view");
		 * btn32.setUrl("http://www.zgjscyw.com/mloginOut.html");
		 */

		ViewButton btn33 = new ViewButton();
		btn33.setName("善建者");
		btn33.setType("view");
		btn33.setUrl("http://dev.zgjscyw.com/");

		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("环球通");
		mainBtn1.setSub_button(new ViewButton[] { btn11, btn12, btn13 });

		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("生态互联");
		mainBtn2.setSub_button(new ViewButton[] { btn21, btn22, btn23 });

		ComplexButton mainBtn3 = new ComplexButton();
		mainBtn3.setName("用户中心");
		mainBtn3.setSub_button(new ViewButton[] { btn31, btn32 });

		ClickButton btn14 = new ClickButton();
		btn14.setName("点击事件");
		btn14.setType("click");
		btn14.setKey("bin");

		ComplexButton mainBtn0 = new ComplexButton();
		mainBtn0.setName("clik事件");
		mainBtn0.setSub_button(new ClickButton[] { btn14 });

		Menu menu = new Menu();
		menu.setButton(new Button[] { mainBtn0, mainBtn1, mainBtn3 });
		return menu;
	}
}
