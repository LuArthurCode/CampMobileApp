package com.mvgx.common.init.utils;

import com.mvgx.common.config.AppConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TokenHeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        String token = AppConfig.TOKEN;
        if (StringUtils.isEmpty(token)) {
            Request originalRequest = chain.request();
            return chain.proceed(originalRequest);
        }else {
            Request originalRequest = chain.request();
            Request updateRequest = originalRequest.newBuilder().header("authorization", "Bearer " + AppConfig.TOKEN).build();
            return chain.proceed(updateRequest);
        }
    }


}
