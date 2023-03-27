package com.mvgx.main.ui.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.mvgx.common.base.BaseActivity;
import com.mvgx.common.init.utils.SoftInputUtil;
import com.mvgx.main.BR;
import com.mvgx.main.R;
import com.mvgx.main.app.AppViewModelFactory;
import com.mvgx.main.databinding.ActivityLoginBinding;
import com.mvgx.main.ui.viewmodel.LoginViewModel;

/**
 * @Author Arthur
 * @Date 2023/03/16 13:41
 */
public class LoginActivity extends BaseActivity<ActivityLoginBinding,LoginViewModel> {
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_login;
    }

    @Override
    public int initVariableId() {
        return BR.loginViewModel;

    }


    @Override
    public LoginViewModel initViewModel() {
        //使用自定义的ViewModelFactory来创建ViewModel，如果不重写该方法，则默认会调用LoginViewModel(@NonNull Application application)构造方法
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this, factory).get(LoginViewModel.class);
    }


    @Override
    public void initData() {
        super.initData();
    }


    @Override
    public  boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideKeyboard(v, ev)) {
                v.clearFocus();//清除Edittext的焦点从而让光标消失
                hideKeyboard(v.getWindowToken());
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void onBackPressed() {
//        SoftInputUtil.closeKeybord(binding.,getApplicationContext());
        super.onBackPressed();
    }

}
