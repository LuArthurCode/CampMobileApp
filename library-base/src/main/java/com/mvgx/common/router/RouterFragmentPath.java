package com.mvgx.common.router;

/**
 * 用于组件开发中，ARouter多Fragment跳转的统一路径注册
 * 在这里注册添加路由路径，需要清楚的写好注释，标明功能界面
 * Created by goldze on 2018/6/21
 */

public class RouterFragmentPath {
    /**
     * Home组件
     */
    public static class Home {
        private static final String HOME = "/home";
        /*首页*/
        public static final String PAGER_HOME = HOME + "/Home";

    }

    /**
     * Client组件
     */
    public static class Client {
        private static final String CLIENT = "/client";
        /*工作*/
        public static final String PAGER_CLIENT = CLIENT + "/Client";
    }

    /**
     * Assets组件
     */
    public static class Assets {
        private static final String ASSETS = "/assets";
        /*消息*/
        public static final String PAGER_ASSETS = ASSETS + "/Assets";
    }

    /**
     * Me组件
     */
    public static class Me {
        private static final String ME = "/me";
        /*我的*/
        public static final String PAGER_ME = ME + "/Me";


        public static final String PAGER_LANGUAGE = ME + "/LanguageActivity";
    }
    /**
     *  Trade组件
     */
    public static class Trade {
        private static final String TRADE = "/trade";
        /*首页*/
        public static final String PAGER_TRADE = TRADE + "/Mask";
    }
}
