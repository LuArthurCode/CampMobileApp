package com.mvgx.common.http.source;

/**
 * Created by goldze on 2019/3/26.
 */
public interface LocalDataSource {
    /**
     * 保存用户名
     */
    void saveUserName(String userName);

    /**
     * 保存用户密码
     */

    void savePassword(String password);

    /**
     * 2FA
     * @param password
     */
    void saveFA(String password);

    /**
     * 获取用户名
     */
    String getUserName();

    /**
     * 获取用户密码
     */
    String getPassword();

    /**
     * 获取2FA
     * @return
     */
    String getFA();
}
