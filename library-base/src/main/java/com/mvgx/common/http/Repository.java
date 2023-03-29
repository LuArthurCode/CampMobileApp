package com.mvgx.common.http;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;

import com.mvgx.common.http.request.RequestLoginInfo;
import com.mvgx.common.http.response.ResponseLoginInfo;
import com.mvgx.common.http.source.HttpDataSource;
import com.mvgx.common.http.source.LocalDataSource;
import com.mvgx.common.base.BaseModel;
import com.mvgx.common.init.http.BaseResponse;
import com.mvgx.common.init.http.BaseResponseToken;
import com.mvgx.common.request.HomeRequestInfo;
import com.mvgx.common.response.HomePieResponse;

import java.util.List;

import io.reactivex.Observable;


/**
 * MVVM的Model层，统一模块的数据仓库，包含网络数据和本地数据（一个应用可以有多个Repositor）
 * Created by goldze on 2019/3/26.
 */
public class Repository extends BaseModel implements HttpDataSource, LocalDataSource {
    private volatile static Repository INSTANCE = null;
    private final HttpDataSource mHttpDataSource;

    private final LocalDataSource mLocalDataSource;

    private Repository(@NonNull HttpDataSource httpDataSource,
                       @NonNull LocalDataSource localDataSource) {
        this.mHttpDataSource = httpDataSource;
        this.mLocalDataSource = localDataSource;
    }

    public static Repository getInstance(HttpDataSource httpDataSource,
                                         LocalDataSource localDataSource) {
        if (INSTANCE == null) {
            synchronized (Repository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Repository(httpDataSource, localDataSource);
                }
            }
        }
        return INSTANCE;
    }

    @VisibleForTesting
    public static void destroyInstance() {
        INSTANCE = null;
    }


    @Override
    public Observable<BaseResponseToken> login(RequestLoginInfo info) {
        return mHttpDataSource.login(info);
    }

    @Override
    public Observable<BaseResponse<List<HomePieResponse>>> getStatisticsMain(HomeRequestInfo homeRequestInfo) {
        return mHttpDataSource.getStatisticsMain(homeRequestInfo);
    }


    @Override
    public void saveUserName(String userName) {
        mLocalDataSource.saveUserName(userName);
    }

    @Override
    public void savePassword(String password) {
        mLocalDataSource.savePassword(password);
    }

    public void saveFA(String password) {
        mLocalDataSource.saveFA(password);
    }

    @Override
    public String getUserName() {
        return mLocalDataSource.getUserName();
    }

    @Override
    public String getPassword() {
        return mLocalDataSource.getPassword();
    }
    public String getFA() {
        return mLocalDataSource.getFA();
    }
}
