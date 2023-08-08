package com.mvgx.assets.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;

import com.mvgx.common.base.BaseViewModel;
import com.mvgx.common.http.Repository;

/**
 * @Author Arthur
 * @Date 2023/03/17 14:02
 */
public class AssetsViewModel extends BaseViewModel<Repository> {
    public AssetsViewModel(@NonNull Application application, Repository model) {
        super(application, model);
    }
}
