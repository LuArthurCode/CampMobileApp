package com.mvgx.main.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;

import com.gyf.immersionbar.ImmersionBar;
import com.mvgx.main.R;

/**
 *  冷启动
 * @Author Arthur
 * @Date 2023/03/16 11:47
 */
public class SplashActivity  extends Activity {

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ImmersionBar.with(this).transparentBar().init();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
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
