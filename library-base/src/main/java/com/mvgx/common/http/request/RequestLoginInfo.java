package com.mvgx.common.http.request;

import java.io.Serializable;

public class RequestLoginInfo implements Serializable {
    private String username;
    private String password;


    public String getUsername() {
        return username == null ? "" : username;
    }

    public void setUsername(String username) {
        this.username = username == null ? "" : username;
    }

    public String getPassword() {
        return password == null ? "" : password;
    }

    public void setPassword(String password) {
        this.password = password == null ? "" : password;
    }
}
