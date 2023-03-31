package com.mvgx.home.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import com.mvgx.common.base.BaseViewModel;
import com.mvgx.common.http.Repository;
import com.mvgx.common.response.HomePieResponse;

/**
 * @Author Arthur
 * @Date 2023/03/29 11:02
 */
public class HomePieViewModel extends BaseViewModel<Repository> {


    public ObservableField<String> mTotal = new ObservableField<>("29,456,123,78.00");

    public HomePieViewModel(@NonNull Application application, Repository model) {
        super(application, model);
    }




}
