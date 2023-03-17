package com.mvgx.client.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;

import com.mvgx.common.base.BaseViewModel;
import com.mvgx.common.http.Repository;

/**
 * @Author Arthur
 * @Date 2023?03/17 13:56
 */
public class ClientViewModel extends BaseViewModel<Repository> {
    public ClientViewModel(@NonNull Application application, Repository model) {
        super(application, model);
    }
}
