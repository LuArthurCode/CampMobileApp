package com.mvgx.common.http.source;


import com.mvgx.common.http.request.RequestLoginInfo;
import com.mvgx.common.http.response.ResponseLoginInfo;
import com.mvgx.common.init.http.BaseResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;

/**
 * Created by goldze on 2019/3/26.
 */
public interface HttpDataSource {

    //登录接口
    Observable<BaseResponse<ResponseLoginInfo>> login(@Body RequestLoginInfo info);



}
