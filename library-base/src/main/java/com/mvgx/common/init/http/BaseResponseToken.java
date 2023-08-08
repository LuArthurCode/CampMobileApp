package com.mvgx.common.init.http;

/**
 * Created by goldze on 2017/5/10.
 * 该类仅供参考，实际业务返回的固定字段, 根据需求来定义，
 */
public class BaseResponseToken {
    private int code;
    private String token;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getToken() {
        return token == null ? "" : token;
    }

    public void setToken(String token) {
        this.token = token == null ? "" : token;
    }

    @Override
    public String toString() {
        return "BaseResponseToken{" +
                "code=" + code +
                ", token='" + token + '\'' +
                '}';
    }
}
