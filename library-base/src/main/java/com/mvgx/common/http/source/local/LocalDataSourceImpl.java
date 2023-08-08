package com.mvgx.common.http.source.local;


import com.mvgx.common.config.AppConfig;
import com.mvgx.common.http.source.LocalDataSource;
import com.mvgx.common.init.utils.SPUtils;

/**
 * 本地数据源，可配合Room框架使用
 * Created by goldze on 2019/3/26.
 */
public class LocalDataSourceImpl implements LocalDataSource {
    private volatile static LocalDataSourceImpl INSTANCE = null;

    public static LocalDataSourceImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (LocalDataSourceImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LocalDataSourceImpl();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    private LocalDataSourceImpl() {
        //数据库Helper构建
    }

    @Override
    public void saveUserName(String userName) {
        SPUtils.getInstance().put(AppConfig.USER_NAME, userName);
    }

    @Override
    public void savePassword(String password) {
        SPUtils.getInstance().put(AppConfig.USER_PASSWORD, password);
    }

    @Override
    public void saveFA(String faCode) {
        SPUtils.getInstance().put(AppConfig.USER_TOKEN, faCode);
    }

    @Override
    public String getUserName() {
        return SPUtils.getInstance().getString(AppConfig.USER_NAME);
    }

    @Override
    public String getPassword() {
        return SPUtils.getInstance().getString(AppConfig.USER_PASSWORD);
    }

    @Override
    public String getFA() {
        return SPUtils.getInstance().getString(AppConfig.USER_TOKEN);
    }
}
