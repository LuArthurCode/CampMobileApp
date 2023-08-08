package com.mvgx.common.http.source;


import com.mvgx.common.http.request.RequestLoginInfo;
import com.mvgx.common.http.response.ResponseLoginInfo;
import com.mvgx.common.init.http.BaseResponse;
import com.mvgx.common.init.http.BaseResponseToken;
import com.mvgx.common.request.HomeRequestInfo;
import com.mvgx.common.response.HomePieResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;

/**
 * Created by goldze on 2019/3/26.
 */
public interface HttpDataSource {

    //登录接口
    Observable<BaseResponseToken> login(@Body RequestLoginInfo info);

    //首页接口
    Observable<BaseResponse<List<HomePieResponse>>> getStatisticsMain(@Body HomeRequestInfo homeRequestInfo);

}
