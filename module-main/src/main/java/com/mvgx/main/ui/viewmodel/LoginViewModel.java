package com.mvgx.main.ui.viewmodel;


import android.app.Application;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import com.hjq.toast.ToastUtils;
import com.mvgx.common.BuildConfig;
import com.mvgx.common.http.Repository;
import com.mvgx.common.base.BaseViewModel;
import com.mvgx.common.http.request.RequestLoginInfo;
import com.mvgx.common.http.response.ResponseLoginInfo;
import com.mvgx.common.init.binding.command.BindingAction;
import com.mvgx.common.init.binding.command.BindingCommand;
import com.mvgx.common.init.bus.event.SingleLiveEvent;
import com.mvgx.common.init.http.BaseResponse;
import com.mvgx.common.init.utils.RxUtils;
import com.mvgx.main.ui.activity.MainActivity;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;

/**
 * @Author Arthur
 * @Date 2023/03/16 13:42
 */
public class LoginViewModel extends BaseViewModel<Repository> {

    //用户名的绑定
    public ObservableField<String> userName = new ObservableField<>("");
    //密码的绑定
    public ObservableField<String> password = new ObservableField<>("");


    public ObservableField<Boolean> onUnClickLogin = new ObservableField<Boolean>(true);
    //封装一个界面发生改变的观察者
    public UIChangeObservable uc = new UIChangeObservable();

    public class UIChangeObservable {
        //密码开关观察者
        public SingleLiveEvent<Boolean> pSwitchEvent = new SingleLiveEvent<>();
    }

    public LoginViewModel(@NonNull Application application, Repository repository) {
        super(application, repository);
        //从本地取得数据绑定到View层
        if (BuildConfig.DEBUG) {
            onUnClickLogin.set(false);
            userName.set("username");
            password.set("password");
        }else {
            onUnClickLogin.set(true);
            userName.set("");
            password.set("");
        }
    }

    public void setPasswordIsVisible() {
        //让观察者的数据改变,逻辑从ViewModel层转到View层，在View层的监听则会被调用
        uc.pSwitchEvent.setValue(uc.pSwitchEvent.getValue() == null || !uc.pSwitchEvent.getValue());
    }

    //登录按钮的点击事件
    public BindingCommand loginOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            if (BuildConfig.DEBUG){
                startActivity(MainActivity.class);
            }else {
                login();
            }
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
            requestLoginInfo.setPassword("1111111");
            model.login(requestLoginInfo)
                    .compose(RxUtils.schedulersTransformer())
                    .compose(RxUtils.exceptionTransformer())
                    .doOnSubscribe(this)
                    .doOnSubscribe(new Consumer<Disposable>() {
                        @Override
                        public void accept(Disposable disposable) throws Exception {
                            showDialog();
                        }
                    }).subscribe(new DisposableObserver<BaseResponse<ResponseLoginInfo>>() {
                        @Override
                        public void onNext(@NonNull BaseResponse<ResponseLoginInfo> result) {
                            dismissDialog();
                            if (null != result && result.isOk()) {
                                startActivity(MainActivity.class);
                            } else {
                                if (null != result && !TextUtils.isEmpty(result.getMessage())){
                                    ToastUtils.show(result.getMessage());
                                }
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
