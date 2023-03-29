package com.mvgx.common.config;

/**
 * @Author Arthur
 * @Date 2023/03/16 13:53
 */
public class AppConfig {


    //-----------------------------
    public static final String TAG = "AppConfig------------>";
    public static final int DEFAULT_TIMEOUT = 20;
    //缓存时间
    public static final int CACHE_TIMEOUT = 10 * 1024 * 1024;

    public static final String  DEVUrl = "http://10.40.88.67:9903";

    public static final String pubKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCqJA8yliEYgp9aorMNzayIyJex4ukgwEXi+Us2xVJlttB2Uy9Bsh9ugTqNcc1bf7R5WW/QIN/EbA+yJC1FCqZHzZdYw54O+IN9oV9I+pE2ziK6vlOjUYmKbi2NO84xAYW83uaWee6MkH8m87qn5hrd7JzksPJS3HdHNZCcOOOemwIDAQAB";


    public static final String USER_INFO = "USER_INFO";

    public static final String USER_CLIENT = "USER_CLIENT";
    //保存的键值名字
    public static final String  USER_NAME = "USER_NAME";

    //保存的键值密码
    public static final String  USER_PASSWORD = "USER_PASSWORD";

    //保存的键值Token
    public static final String USER_TOKEN = "USER_TOKEN";

    //保存的语言
    public static final String SP_LANGUAGE = "LANGUAGE";

    public static final String EN = "en";

    public static final String ZH = "zh";

    public static final String IS_LOGIN = "IS_LOGIN";

    public static  String SKIN_DEFAULT = "SKIN_DEFAULT";

    public static String TOKEN = "";

    //到期时间
    public static final String RECOMMEND_DATA = "RECOMMEND_DATA";
    //期望时间
    public static final String EXPIRATION_DATA = "EXPIRATION_DATA";

    //-----------------------------


    // 超级管理员  不可以登陆
    public static String ROLE_CAMP_SUPER_ADMIN_ROLE = "ROLE_CAMP_SUPER_ADMIN_ROLE";
    // 判断系统
    public static String ROLE_CAMP = "ROLE_CAMP";

    public static String CLIENT_NAME = "CLIENT_NAME";

    public enum ROLE{
        ADMIN_ROLE,TR_ROLE,CLIENT_ROLE
    }


}
