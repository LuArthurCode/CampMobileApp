package com.mvgx.common.init.utils;

import static com.mvgx.common.config.AppConfig.USER_INFO;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.mvgx.common.config.AppConfig;
import com.mvgx.common.entity.UserEntity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class GsonUtils {
    private static Gson gson;

    private static UserEntity mUserInfo = new UserEntity();
    public static Gson getInstance() {
        if (null == gson) {
            synchronized (GsonUtils.class) {
                if (null == gson) {
                    gson = new Gson();
                }
            }
        }
        return gson;
    }
    public static JSONObject parseMapParameterFromJson(String data) {
        try {
            if (null == data) return null;
            JSONObject result = new JSONObject(data);
            return result;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static UserEntity getUserInfoEntity() {
        String info = SPUtils.getInstance().getString(USER_INFO, "");
        if (!TextUtils.isEmpty(info)) {
            mUserInfo = (new Gson()).fromJson(info, UserEntity.class);
            if (null != mUserInfo){
                return mUserInfo;
            }
        }//应用信息为空，说明登陆已经失效，需要跳转登陆
        return mUserInfo;
    }

    public static AppConfig.ROLE getUserRole() {
        AppConfig.ROLE role = null;
        String info = SPUtils.getInstance().getString(USER_INFO, "");
        if (!TextUtils.isEmpty(info)) {
            mUserInfo = (new Gson()).fromJson(info, UserEntity.class);
            if (null != mUserInfo){
                List<String> roleList = mUserInfo.getRol();
                if (null != roleList){
                    for (int i = 0; i < roleList.size() ; i ++){
                        String roleName = roleList.get(i);
                        if (!TextUtils.isEmpty(roleName) && roleName.startsWith(AppConfig.ROLE_CAMP) && roleName.endsWith(AppConfig.ROLE.ADMIN_ROLE.name())){
                            role = AppConfig.ROLE.ADMIN_ROLE;
                            SPUtils.getInstance().put(AppConfig.CLIENT_NAME,role.name());
                        }else if (!TextUtils.isEmpty(roleName) && roleName.startsWith(AppConfig.ROLE_CAMP) && roleName.endsWith(AppConfig.ROLE.TR_ROLE.name())){
                            role = AppConfig.ROLE.TR_ROLE;
                            SPUtils.getInstance().put(AppConfig.CLIENT_NAME,role.name());
                        }else if (!TextUtils.isEmpty(roleName) && roleName.startsWith(AppConfig.ROLE_CAMP) && roleName.endsWith(AppConfig.ROLE.CLIENT_ROLE.name())){
                            role = AppConfig.ROLE.CLIENT_ROLE;
                            SPUtils.getInstance().put(AppConfig.CLIENT_NAME,role.name());
                        }
                    }
                }
                return role;
            }
        }//应用信息为空，说明登陆已经失效，需要跳转登陆
        return role;
    }

}
