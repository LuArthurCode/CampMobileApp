package com.mvgx.me.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;

import com.alibaba.android.arouter.launcher.ARouter;
import com.mvgx.common.BuildConfig;
import com.mvgx.common.base.BaseViewModel;
import com.mvgx.common.http.Repository;
import com.mvgx.common.init.binding.command.BindingAction;
import com.mvgx.common.init.binding.command.BindingCommand;
import com.mvgx.common.router.RouterFragmentPath;

/**
 * @Author Arthur
 * @Date 2023/03/17 14:05
 */
public class MeViewModel extends BaseViewModel<Repository> {
    public MeViewModel(@NonNull Application application, Repository model) {
        super(application, model);
    }

    public BindingCommand onClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            ARouter.getInstance().build(RouterFragmentPath.Me.PAGER_LANGUAGE).navigation();
        }
    });

    public BindingCommand onClickDarkCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            restoreSkin();
        }
    });

}
