package com.mvgx.common.http.source.http.service;


import com.mvgx.common.http.request.RequestLoginInfo;
import com.mvgx.common.http.response.ResponseLoginInfo;
import com.mvgx.common.init.http.BaseResponse;
import com.mvgx.common.init.http.BaseResponseToken;
import com.mvgx.common.request.HomeRequestInfo;
import com.mvgx.common.response.HomePieResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by goldze on 2017/6/15.
 */

public interface ApiService {

    //登录接口
    @POST("/auth")
    Observable<BaseResponseToken> login(@Body RequestLoginInfo info);

    //首页中展示的Tab
    @POST("/statistics/main")
    Observable<BaseResponse<List<HomePieResponse>>> getStatisticsMain(@Body HomeRequestInfo homeRequestInfo);

}
