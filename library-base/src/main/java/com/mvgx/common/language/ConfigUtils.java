package com.mvgx.common.language;

import android.content.Context;
import android.text.TextUtils;
import com.mvgx.common.config.AppConfig;
import com.mvgx.common.init.utils.SPUtils;
import java.util.Locale;

/**
 * 自己使用的工具类
 */
public class ConfigUtils {

    public static String getLanguage(Context context,String value){
        try {
            if (null == context||TextUtils.isEmpty(value)){
                Locale locale = context.getResources().getConfiguration().locale;
                String language = locale.getLanguage();
                if (language.contains("zh")){
                    SPUtils.getInstance().put(AppConfig.SP_LANGUAGE, AppConfig.ZH);
                    return context.getString(com.mvgx.res.R.string.app_language_chinese);
                }else if (language.endsWith("en")){
                    SPUtils.getInstance().put(AppConfig.SP_LANGUAGE,AppConfig.EN);
                    return context.getString(com.mvgx.res.R.string.app_language_english);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

       return getLanguageText(context,value);
    }

    private static String getLanguageText(Context context,String value){
        if ("zh".equals(value)){
            return context.getString(com.mvgx.res.R.string.app_language_chinese);
        }else if ("en".equals(value)){
            return context.getString(com.mvgx.res.R.string.app_language_english);
        }else {
            return context.getString(com.mvgx.res.R.string.app_language_english);
        }
    }
}
