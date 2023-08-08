package com.mvgx.me.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;

import com.mvgx.common.base.BaseViewModel;
import com.mvgx.common.config.AppConfig;
import com.mvgx.common.http.Repository;
import com.mvgx.common.init.binding.command.BindingAction;
import com.mvgx.common.init.binding.command.BindingCommand;
import com.mvgx.common.init.bus.event.SingleLiveEvent;
import com.mvgx.common.init.utils.SPUtils;
import com.mvgx.me.event.LanguageEvent;


public class LanguageViewModel extends BaseViewModel<Repository> {

    public String language;

    public LanguageViewModel(@NonNull Application application, Repository model) {
        super(application, model);
        language = SPUtils.getInstance().getString(AppConfig.SP_LANGUAGE);
    }

    public ChangeObservable changeObservable = new ChangeObservable();

    public class ChangeObservable {
        public SingleLiveEvent<LanguageEvent> languageEvent = new SingleLiveEvent<>();
    }


    public BindingCommand onClickEnglish = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            if (AppConfig.EN.equals(language)) return;
            SPUtils.getInstance().put(AppConfig.SP_LANGUAGE, AppConfig.EN);
            LanguageEvent languageEvent = new LanguageEvent();
            languageEvent.setLanguage(AppConfig.EN);
            changeObservable.languageEvent.setValue(languageEvent);

        }
    });

    public BindingCommand onClickChinese = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            if (AppConfig.ZH.equals(language)) return;
            SPUtils.getInstance().put(AppConfig.SP_LANGUAGE, AppConfig.ZH);
            LanguageEvent languageEvent = new LanguageEvent();
            languageEvent.setLanguage(AppConfig.ZH);
            changeObservable.languageEvent.setValue(languageEvent);
        }
    });
}
