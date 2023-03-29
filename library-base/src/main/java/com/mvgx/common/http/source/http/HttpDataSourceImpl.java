package com.mvgx.common.http.source.http;


import com.mvgx.common.http.request.RequestLoginInfo;
import com.mvgx.common.http.response.ResponseLoginInfo;
import com.mvgx.common.http.source.HttpDataSource;
import com.mvgx.common.http.source.http.service.ApiService;
import com.mvgx.common.init.http.BaseResponse;
import com.mvgx.common.init.http.BaseResponseToken;
import com.mvgx.common.request.HomeRequestInfo;
import com.mvgx.common.response.HomePieResponse;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by goldze on 2019/3/26.
 */
public class HttpDataSourceImpl implements HttpDataSource {
    private ApiService apiService;
    private volatile static HttpDataSourceImpl INSTANCE = null;

    public static HttpDataSourceImpl getInstance(ApiService apiService) {
        if (INSTANCE == null) {
            synchronized (HttpDataSourceImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HttpDataSourceImpl(apiService);
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    private HttpDataSourceImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Observable<BaseResponseToken> login(RequestLoginInfo info) {
        return apiService.login(info);
    }

    @Override
    public Observable<BaseResponse<List<HomePieResponse>>> getStatisticsMain(HomeRequestInfo homeRequestInfo) {
        return apiService.getStatisticsMain(homeRequestInfo);
    }


}
