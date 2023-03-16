package com.mvgx.common.http.source.http.service;


import com.mvgx.common.http.request.RequestLoginInfo;
import com.mvgx.common.http.response.ResponseLoginInfo;
import com.mvgx.common.init.http.BaseResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by goldze on 2017/6/15.
 */

public interface ApiService {

    //登录接口
    @POST("/auth")
    Observable<BaseResponse<ResponseLoginInfo>> login(@Body RequestLoginInfo info);

}
