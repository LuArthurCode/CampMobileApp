package com.mvgx.common.init.utils;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class GsonUtils {
    private static Gson gson;

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
}
