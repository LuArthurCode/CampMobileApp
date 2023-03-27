package com.mvgx.main.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import com.gyf.immersionbar.ImmersionBar;
import com.mvgx.common.base.BaseActivity;
import com.mvgx.main.BR;
import com.mvgx.main.R;
import com.mvgx.main.app.AppViewModelFactory;
import com.mvgx.main.databinding.ActivitySplashBinding;
import com.mvgx.main.ui.viewmodel.SplashViewModel;

/**
 *  冷启动
 * @Author Arthur
 * @Date 2023/03/16 11:47
 */
public class SplashActivity  extends BaseActivity<ActivitySplashBinding, SplashViewModel> {

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ImmersionBar.with(this).transparentBar().init();
        super.onCreate(savedInstanceState);

    }

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_splash;
    }

    @Override
    public int initVariableId() {
        return BR.splashViewModel;
    }

    @Override
    public SplashViewModel initViewModel() {
        //使用自定义的ViewModelFactory来创建ViewModel，如果不重写该方法，则默认会调用LoginViewModel(@NonNull Application application)构造方法
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this, factory).get(SplashViewModel.class);
    }


    @Override
    public void initData() {
        super.initData();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                inMain();
            }
        }, 2 * 1000);
    }

    /**
     * 进入主页面
     */
    private void inMain() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
