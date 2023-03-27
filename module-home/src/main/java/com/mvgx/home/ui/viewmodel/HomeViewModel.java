package com.mvgx.home.ui.viewmodel;

import android.app.Application;
import android.provider.SyncStateContract;
import android.util.Log;

import androidx.annotation.NonNull;

import com.mvgx.common.base.BaseViewModel;
import com.mvgx.common.http.Repository;
import com.mvgx.common.init.binding.command.BindingAction;
import com.mvgx.common.init.binding.command.BindingCommand;


/**
 * @Author Arthur
 * @Date 2023/03/17 13:54
 */
public class HomeViewModel extends BaseViewModel<Repository> {
    public HomeViewModel(@NonNull Application application, Repository model) {
        super(application, model);
    }


    public BindingCommand onClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            restoreSkin();
        }
    });
}
