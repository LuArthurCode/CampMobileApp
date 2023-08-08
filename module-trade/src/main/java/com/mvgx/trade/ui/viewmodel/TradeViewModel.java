package com.mvgx.trade.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;

import com.mvgx.common.base.BaseViewModel;
import com.mvgx.common.http.Repository;

/**
 * @Author Arthur
 * @Date 2023/03/17 14:10
 */
public class TradeViewModel extends BaseViewModel<Repository> {
    public TradeViewModel(@NonNull Application application, Repository model) {
        super(application, model);
    }
}
