package com.mvgx.common.init.utils;

import android.content.Context;
import android.text.TextUtils;

import com.mvgx.common.BuildConfig;
import com.mvgx.common.config.AppConfig;
import com.mvgx.common.init.http.cookie.CookieJarImpl;
import com.mvgx.common.init.http.cookie.store.PersistentCookieStore;
import com.mvgx.common.init.http.interceptor.BaseInterceptor;
import com.mvgx.common.init.http.interceptor.CacheInterceptor;
import com.mvgx.common.init.http.interceptor.logging.Level;
import com.mvgx.common.init.http.interceptor.logging.LoggingInterceptor;

import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.internal.platform.Platform;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by goldze on 2017/5/10.
 * RetrofitClient封装单例类, 实现网络请求
 */
public class RetrofitClient {
    //超时时间
    private static Context mContext = Utils.getContext();

    private static OkHttpClient okHttpClient;
    private static Retrofit retrofit;

    private Cache cache = null;
    private File httpCacheDirectory;

    private static class SingletonHolder {
        private static RetrofitClient INSTANCE = new RetrofitClient();
    }

    public static RetrofitClient getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private RetrofitClient() {
        this("", null);
    }

    private RetrofitClient(String url, Map<String, String> headers) {
        if (BuildConfig.DEBUG && TextUtils.isEmpty(url)) {
            url = AppConfig.DEVUrl;
        } else {
            url = AppConfig.DEVUrl;
        }

        if (httpCacheDirectory == null) {
            httpCacheDirectory = new File(mContext.getCacheDir(), "goldze_cache");
        }

        try {
            if (cache == null) {
                cache = new Cache(httpCacheDirectory, AppConfig.CACHE_TIMEOUT);
            }
        } catch (Exception e) {
            KLog.e("Could not create http cache", e);
        }
        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory();
        okHttpClient = new OkHttpClient.Builder()
                .cookieJar(new CookieJarImpl(new PersistentCookieStore(mContext)))
                .addInterceptor(new BaseInterceptor(headers))
                .addInterceptor(new CacheInterceptor(mContext))
                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                .addInterceptor(new LoggingInterceptor
                        .Builder()//构建者模式
                        .loggable(BuildConfig.DEBUG) //是否开启日志打印
                        .setLevel(Level.BASIC) //打印的等级
                        .log(Platform.INFO) // 打印类型
                        .request("Request") // request的Tag
                        .response("Response")// Response的Tag
                        .addHeader("log-header", "I am the log request header.") // 添加打印头, 注意 key 和 value 都不能是中文
                        .build()
                ).addNetworkInterceptor(new TokenHeaderInterceptor())
                .connectTimeout(AppConfig.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(AppConfig.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .connectionPool(new ConnectionPool(8, 15, TimeUnit.SECONDS))
                // 这里你可以根据自己的机型设置同时连接的个数和时间，我这里8个，和每个保持时间为10s
                .build();
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(url)
                .build();

    }


    /**
     * 根据Response，判断Token是否失效
     * 1.token 判断 第一是根据期望刷新时间，如果已经超过了期望刷新时间，
     * 则比较过期时间，如果没有超过过期时间，那么就刷新token
     * 2.如果已经超过了期望时间则需要进行登录，直接跳转到登录页面。
     * 时间戳
     *
     * @return
     */
//    private boolean isTokenExpired(Request request) {
//        // 否则的话 则都是需要去登录界面
//        if (null != request) {
//            HttpUrl url = request.url();
//            isLogin = SPUtils.getInstance().getBoolean(AppConfig.IS_LOGIN);
//            expirationDate = SPUtils.getInstance().getExpirationDateLong();//到期时间
//            recommendDate = SPUtils.getInstance().getRecommendDateLong();//期望时间
//            currentTimeDate = TimeUtils.getCurTimeLong();
//            /**
//             * 如果是已经登录则比较是否要刷新token
//             */
//            if (isLogin && !REFRESH) {
//                if (currentTimeDate < expirationDate) {// 当前时间小于 过期时间
//                    if (currentTimeDate > recommendDate) {// 当前时间大于  期望时间
//                        REFRESH = true;
//                        return true;
//                    }
//                    return false;//没有大于期望时间 什么都不用做，正常访问网络
//                }
//            }
//
//            if (null != url) {
//                if (url.encodedPath().equals(AppConfig.URL_LOGIN) || url.encodedPath().equals(AppConfig.URL_FA_LOGIN) || url.encodedPath().equals(AppConfig.URL_REFRESH_TOKEN)) {
//                    return false;
//                }
//            }
//        }
//        return false;
//    }

    //自定义添加header参数
    public void addHeader(Map head) {
        if (null == head) return;
    }


    /**
     * 同步请求方式，获取最新的Token
     *
     * @return
     */
//    private synchronized Request getNewToken(Interceptor.Chain chain) {
//        // 通过获取token的接口，同步请求接口
//        Request newRequest = chain.request()
//                .newBuilder()
//                .header("authorization", "Bearer " + token)
//                .build();
//        try {
//            ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);
//            String string = SPUtils.getInstance().getString(TOKEN);
//            Call<BaseResponse<TokenInfo>> baseResponseCall = apiService.refreshToken(string);
//            retrofit2.Response<BaseResponse<TokenInfo>> execute = baseResponseCall.execute();
//            BaseResponse<TokenInfo> body = execute.body();
//            if (null != body && null != body.getData()) {
//                TokenInfo data = body.getData();
//                token = data.getToken();
//                SPUtils.getInstance().put(TOKEN, data.getToken());
//                SPUtils.getInstance().put(AppConfig.EXPIRATION_DATA, data.getExpirationDate());
//                SPUtils.getInstance().put(AppConfig.RECOMMEND_DATA, data.getRecommendDate());
//                SPUtils.getInstance().put(AppConfig.TOKENINFO, data.toJsonString());
//                Log.d("TAG", "自动刷新Token,请求回来的结果：" + token);
//                newRequest = chain.request()
//                        .newBuilder()
//                        .header("authorization", "Bearer " + token)
//                        .build();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return newRequest;
//    }


    /**
     * create you ApiService
     * Create an implementation of the API endpoints defined by the {@code service} interface.
     */
    public <T> T create(final Class<T> service) {
        if (service == null) {
            throw new RuntimeException("Api service is null!");
        }
        return retrofit.create(service);
    }

    /**
     * /**
     * execute your customer API
     * For example:
     * MyApiService service =
     * RetrofitClient.getInstance(MainActivity.this).create(MyApiService.class);
     * <p>
     * RetrofitClient.getInstance(MainActivity.this)
     * .execute(service.lgon("name", "password"), subscriber)
     * * @param subscriber
     */

    public static <T> T execute(Observable<T> observable, Observer<T> subscriber) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

        return null;
    }
}
