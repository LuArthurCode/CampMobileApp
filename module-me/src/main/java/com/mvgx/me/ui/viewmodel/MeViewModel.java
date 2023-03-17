package com.mvgx.me.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;

import com.mvgx.common.base.BaseViewModel;
import com.mvgx.common.http.Repository;

/**
 * @Author Arthur
 * @Date 2023/03/17 14:05
 */
public class MeViewModel extends BaseViewModel<Repository> {
    public MeViewModel(@NonNull Application application, Repository model) {
        super(application, model);
    }
}
