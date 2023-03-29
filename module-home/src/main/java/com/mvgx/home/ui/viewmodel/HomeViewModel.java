package com.mvgx.home.ui.viewmodel;

import android.app.Application;
import android.provider.SyncStateContract;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.fragment.app.Fragment;

import com.auth0.android.jwt.Claim;
import com.auth0.android.jwt.JWT;
import com.kennyc.view.MultiStateView;
import com.mvgx.common.base.BaseViewModel;
import com.mvgx.common.config.AppConfig;
import com.mvgx.common.http.Repository;
import com.mvgx.common.init.binding.command.BindingAction;
import com.mvgx.common.init.binding.command.BindingCommand;
import com.mvgx.common.init.bus.event.SingleLiveEvent;
import com.mvgx.common.init.http.BaseResponse;
import com.mvgx.common.init.http.BaseResponseToken;
import com.mvgx.common.init.http.NetworkUtil;
import com.mvgx.common.init.utils.GsonUtils;
import com.mvgx.common.init.utils.RxUtils;
import com.mvgx.common.init.utils.SPUtils;
import com.mvgx.common.init.utils.Utils;
import com.mvgx.common.request.HomeRequestInfo;
import com.mvgx.common.response.HomePieResponse;
import com.mvgx.home.ui.fragment.HomePieFragment;

import java.util.List;
import java.util.Map;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;


/**
 * @Author Arthur
 * @Date 2023/03/17 13:54
 */
public class HomeViewModel extends BaseViewModel<Repository> {

    public ObservableField< MultiStateView.ViewState> multiStateView  = new ObservableField<>(MultiStateView.ViewState.CONTENT);
    public List<Fragment> mFragments;
    public List<String> mTitlePager;

    public UIChangeObservable uc = new UIChangeObservable();

    public HomeViewModel(@NonNull Application application, Repository model) {
        super(application, model);

    }

    @Override
    public void checkNetWork() {
        super.checkNetWork();
        if (!NetworkUtil.isNetworkAvailable(Utils.getContext())) {
            if (null != multiStateView){
                multiStateView.set(MultiStateView.ViewState.ERROR);
            }
        }
    }

    public class UIChangeObservable{
        public SingleLiveEvent finishRefresh = new SingleLiveEvent();
    }


    public BindingCommand stateClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            loadHomeInfo();
        }
    });

    public BindingCommand onRefreshCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            loadHomeInfo();
        }
    });



    @SuppressWarnings("unchecked")
    public void loadHomeInfo(){
        HomeRequestInfo homeRequestInfo = new HomeRequestInfo();
        model.getStatisticsMain(homeRequestInfo)
                .compose(RxUtils.schedulersTransformer())
                .compose(RxUtils.exceptionTransformer())
                .doOnSubscribe(this)
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        showDialog();
                    }
                }).subscribe(new DisposableObserver<BaseResponse<List<HomePieResponse>>>() {
                    @Override
                    public void onNext(@NonNull BaseResponse<List<HomePieResponse>> result) {
                        dismissDialog();
                        if (null != result && result.isOk() && null != result.getData() && result.getData().size() > 0){
                            for (HomePieResponse homeInfo : result.getData()) {
                                HomePieFragment homePieFragment = new HomePieFragment();
                                mFragments.add(homePieFragment);
                                mTitlePager.add(homeInfo.getTitle());
                            }
                            uc.finishRefresh.call();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable throwable) {
                        dismissDialog();
                    }

                    @Override
                    public void onComplete() {}
                });
    }



}
