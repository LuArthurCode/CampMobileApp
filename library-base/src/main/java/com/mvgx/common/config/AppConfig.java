package com.mvgx.common.config;

/**
 * @Author Arthur
 * @Date 2023/03/16 13:53
 */
public class AppConfig {


    public static final int DEFAULT_TIMEOUT = 20;
    //缓存时间
    public static final int CACHE_TIMEOUT = 10 * 1024 * 1024;

    public static final String  DEVUrl = "http://10.40.88.80:9093/";

    //保存的键值名字
    public static final String  USER_NAME = "USER_NAME";

    //保存的键值密码
    public static final String  USER_PASSWORD = "USER_PASSWORD";

    //保存的键值Token
    public static final String USER_TOKEN = "USER_TOKEN";

    public static  boolean IS_LOGIN = false;

    public static  String TOKEN = "";

    public static final String pubKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCqJA8yliEYgp9aorMNzayIyJex4ukgwEXi+Us2xVJlttB2Uy9Bsh9ugTqNcc1bf7R5WW/QIN/EbA+yJC1FCqZHzZdYw54O+IN9oV9I+pE2ziK6vlOjUYmKbi2NO84xAYW83uaWee6MkH8m87qn5hrd7JzksPJS3HdHNZCcOOOemwIDAQAB";


}
