package com.souvc.weixin.test;

import net.sf.json.JSONObject;

import com.souvc.weixin.pojo.Button;
import com.souvc.weixin.pojo.ClickButton;
import com.souvc.weixin.pojo.ComplexButton;
import com.souvc.weixin.pojo.Menu;



public class MenuTest {

    public static void main(String[] args) {
        /**
         * 按钮类型就两种：
         * click类型
         * view类型
         */

        /**
         *click类型
         * 二级菜单1
         * 所包含的二级菜单：
         *             clickButton_11
         *             ...
         * 可以定义5个
         */
        ClickButton clickButton_11 = new ClickButton();
        //设置按钮名称
        clickButton_11.setName("");
        //设置按钮类别 尊照微信开发文档给出的定义
        clickButton_11.setType("");
        //设置按钮key值
        clickButton_11.setKey("");

        //.....可以定义5个.....

        /**
         * 二级菜单2
         * 所包含的二级菜单：
         *         clickButton_21
         *      ...
         */
        ClickButton clickButton_21 = new ClickButton();
        clickButton_21.setName("");
        clickButton_21.setType("");
        clickButton_21.setKey("");

        /**
         * 定义一个一级菜单数组，
         * 个数应为1~3个
         */
        ClickButton button_3 = new ClickButton();
        button_3.setName("");
        button_3.setType("");
        button_3.setKey("");

        /**
         * 上面的二级菜单定义好后，
         * 用一个带二级菜单的按钮（ComplexButton）装起来
         */

        //一级菜单1
        ComplexButton complexButton1 = new ComplexButton();
        complexButton1.setName("一级菜单1");
        complexButton1.setSub_button(new Button[] {clickButton_11});

        //一级菜单2
        ComplexButton complexButton2 = new ComplexButton();
        complexButton2.setName("");
        complexButton2.setSub_button(new Button[] {clickButton_21});

        //一级菜单3定义在上面

        //用一个menu(相当于总菜单，在最外层)来把上面的菜单装起来
        Menu menu = new Menu();
        menu.setButton(new Button[] {complexButton1, complexButton2, button_3});

        //把menu转换为json数组
        String jsonMenu = JSONObject.fromObject(menu).toString();

        /**
         * 创建和删除都是采用https协议
         * http请求方式：POST（请使用https协议）
         */
        //创建菜单接口
        //https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN
/*        JSONObject createRequest = CommonUtil.httpsRequest(
                //requestUrl
                "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=此处填写上面GetAccessToken类获取的access_token",
                //requestMethod
                "POST",
                //outputStr
                jsonMenu
            );

        //打印出创建状态信息（同时执行创建）
        //System.out.println(createRequest);

        //删除菜单接口
        //https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN
        JSONObject deleteResult = CommonUtil.httpsRequest(
                "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=此处填写上面GetAccessToken类获取的access_token",
                "POST",
                jsonMenu
            );*/

        //打印出删除状态信息（同时执行删除）
//        System.out.println(deleteResult);
    }

}
