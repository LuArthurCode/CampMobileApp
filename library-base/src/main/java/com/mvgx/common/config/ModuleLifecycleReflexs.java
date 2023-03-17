package com.mvgx.common.config;

/**
 * Created by goldze on 2018/6/21 0021.
 * 组件生命周期反射类名管理，在这里注册需要初始化的组件，通过反射动态调用各个组件的初始化方法
 * 注意：以下模块中初始化的Module类不能被混淆
 */

public class ModuleLifecycleReflexs {
    private static final String BaseInit = "com.mvgx.common.base.BaseModuleInit";
    //主业务模块
    private static final String MainInit = "com.mvgx.main.MainModuleInit";
    //登录验证模块
    private static final String SignInit = "com.goldze.sign.SignModuleInit";
    //首页业务模块
    private static final String HomeInit = "com.mvgx.home.HomeModuleInit";

    //我的业务模块
    private static final String MeInit = "com.mvgx.me.MeModuleInit";

    //用户业务模块
    private static final String ClientInit = "com.mvgx.client.ClientModuleInit";

    //资产业务模块
    private static final String AssetsInit = "com.mvgx.assets.AssetsModuleInit";

    //交易业务模块
    private static final String TradeInit = "com.mvgx.trade.TradeModuleInit";

    public static String[] initModuleNames = {BaseInit, MainInit,SignInit, HomeInit, ClientInit, AssetsInit, MeInit, TradeInit};
}
