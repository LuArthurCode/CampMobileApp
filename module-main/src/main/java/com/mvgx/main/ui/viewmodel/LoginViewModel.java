package com.mvgx.main.ui.viewmodel;


import android.app.Application;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import com.auth0.android.jwt.Claim;
import com.auth0.android.jwt.JWT;
import com.mvgx.common.BuildConfig;
import com.mvgx.common.config.AppConfig;
import com.mvgx.common.http.Repository;
import com.mvgx.common.base.BaseViewModel;
import com.mvgx.common.http.request.RequestLoginInfo;
import com.mvgx.common.init.binding.command.BindingAction;
import com.mvgx.common.init.binding.command.BindingCommand;
import com.mvgx.common.init.http.BaseResponseToken;
import com.mvgx.common.init.utils.GsonUtils;
import com.mvgx.common.init.utils.RSADigitalSignUtil;
import com.mvgx.common.init.utils.RxUtils;
import com.mvgx.common.init.utils.SPUtils;
import com.mvgx.main.ui.activity.MainActivity;

import java.util.Map;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;

/**
 * @Author Arthur
 * @Date 2023/03/16 13:42
 */
public class LoginViewModel extends BaseViewModel<Repository> {

//    DEV  环境
//    uob_tr@mvgx.com  TR
//    P@ssw0rd1234

//    ob_admin@mvgx.com  企业管理员
//    P@ssw0rd1234

    public String mPasswordStr;

    //用户名的绑定
    public ObservableField<String> userName = new ObservableField<>("");
    //密码的绑定
    public ObservableField<String> password = new ObservableField<>("");


    public ObservableField<Boolean> onUnClickLogin = new ObservableField<Boolean>(true);
    //封装一个界面发生改变的观察者
    public LoginViewModel(@NonNull Application application, Repository repository) {
        super(application, repository);
        //从本地取得数据绑定到View层
        if (BuildConfig.DEBUG) {
            onUnClickLogin.set(false);
            userName.set("uob_admin@mvgx.com");
            password.set("P@ssw0rd1234");
        }else {
            onUnClickLogin.set(true);
            // TR
            userName.set("uob_tr@mvgx.com");
            password.set("P@ssw0rd1234");
        }
    }

    //登录按钮的点击事件
    public BindingCommand loginOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
//            if (BuildConfig.DEBUG){
//                startActivity(MainActivity.class);
//            }else {
                login();
//            }
        }
    });

    /**
     * 网络模拟一个登陆操作
     **/
    @SuppressWarnings("unchecked")
    private void login() {
        try {
            RequestLoginInfo requestLoginInfo = new RequestLoginInfo();
            requestLoginInfo.setUsername(userName.get().trim());
            mPasswordStr = RSADigitalSignUtil.encryptByPublicKey(password.get().trim(), AppConfig.pubKey);
            requestLoginInfo.setPassword(mPasswordStr);
            model.login(requestLoginInfo)
                    .compose(RxUtils.schedulersTransformer())
                    .compose(RxUtils.exceptionTransformer())
                    .doOnSubscribe(this)
                    .doOnSubscribe(new Consumer<Disposable>() {
                        @Override
                        public void accept(Disposable disposable) throws Exception {
                            showDialog();
                        }
                    }).subscribe(new DisposableObserver<BaseResponseToken>() {
                        @Override
                        public void onNext(@NonNull BaseResponseToken result) {
                            dismissDialog();
                            if (null != result && !TextUtils.isEmpty(result.getToken())){
                                String token = result.getToken();
                                JWT jwt = new JWT(token);
                                Map<String, Claim> claims = jwt.getClaims();
                                String userInfo = GsonUtils.getInstance().toJson(claims);
                                if (!TextUtils.isEmpty(userInfo)){
                                    SPUtils.getInstance().put(AppConfig.USER_INFO,userInfo);
                                    SPUtils.getInstance().put(AppConfig.USER_INFO,userInfo);
                                    SPUtils.getInstance().put(AppConfig.USER_INFO,userInfo);
                                    SPUtils.getInstance().put(AppConfig.USER_INFO,userInfo);
                                    SPUtils.getInstance().put(AppConfig.USER_INFO,userInfo);
                                }
                                startActivity(MainActivity.class);
                            }
                        }

                        @Override
                        public void onError(@NonNull Throwable throwable) {
                            dismissDialog();
                        }

                        @Override
                        public void onComplete() {
                        }
                    });

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
