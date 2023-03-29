package com.mvgx.main.ui.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import androidx.lifecycle.ViewModelProviders;
import com.mvgx.common.base.BaseActivity;
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
        binding.loginUserName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                setLoginAction();
            }
        });
        binding.loginPassWord.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                setLoginAction();
            }
        });
    }

    /**
     * 判断是否可以点击
     */
    private void setLoginAction() {
        if (null != binding.loginUserName && binding.loginUserName.getText().length()>0 && null != binding.loginPassWord && binding.loginPassWord.getText().toString().length()>0){
            viewModel.onUnClickLogin.set(false);
        }else {
            viewModel.onUnClickLogin.set(true);
        }
    }

}
