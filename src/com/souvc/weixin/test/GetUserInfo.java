package com.souvc.weixin.test;

import com.souvc.weixin.util.CommonUtil;

public class GetUserInfo {

	public static void main(String args[]) {
        // 获取接口访问凭证
        String accessToken = CommonUtil.getToken("xxxx", "xxxx").getAccessToken();
        /**
         * 获取用户信息
         */
//        WeixinUserInfo user = getUserInfo(accessToken, "ooK-yuJvd9gEegH6nRIen-gnLrVw");
//        System.out.println("OpenID：" + user.getOpenId());
//        System.out.println("关注状态：" + user.getSubscribe());
//        System.out.println("关注时间：" + user.getSubscribeTime());
//        System.out.println("昵称：" + user.getNickname());
//        System.out.println("性别：" + user.getSex());
//        System.out.println("国家：" + user.getCountry());
//        System.out.println("省份：" + user.getProvince());
//        System.out.println("城市：" + user.getCity());
//        System.out.println("语言：" + user.getLanguage());
//        System.out.println("头像：" + user.getHeadImgUrl());
    }

}
