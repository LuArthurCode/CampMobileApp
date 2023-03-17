package com.mvgx.home.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;

import com.mvgx.common.base.BaseViewModel;
import com.mvgx.common.http.Repository;

/**
 * @Author Arthur
 * @Date 2023/03/17 13:54
 */
public class HomeViewModel extends BaseViewModel<Repository> {
    public HomeViewModel(@NonNull Application application, Repository model) {
        super(application, model);
    }
}
