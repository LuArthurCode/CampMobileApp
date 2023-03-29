package com.mvgx.home.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;

import com.mvgx.common.base.BaseViewModel;
import com.mvgx.common.http.Repository;

/**
 * @Author Arthur
 * @Date 2023/03/29 11:02
 */
public class HomePieViewModel extends BaseViewModel<Repository> {

    public HomePieViewModel(@NonNull Application application, Repository model) {
        super(application, model);
    }
}
