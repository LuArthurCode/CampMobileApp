package com.mvgx.me.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.mvgx.common.base.AppManager;
import com.mvgx.common.base.BaseActivity;
import com.mvgx.common.config.AppConfig;
import com.mvgx.common.init.utils.SPUtils;
import com.mvgx.common.language.LanguageType;
import com.mvgx.common.language.MultiLanguageUtil;
import com.mvgx.common.router.RouterActivityPath;
import com.mvgx.common.router.RouterFragmentPath;
import com.mvgx.me.BR;
import com.mvgx.me.R;
import com.mvgx.me.app.AppViewModelFactory;
import com.mvgx.me.databinding.ActivityLanguageBinding;
import com.mvgx.me.event.LanguageEvent;
import com.mvgx.me.ui.viewmodel.LanguageViewModel;
import java.util.Locale;

@Route(path = RouterFragmentPath.Me.PAGER_LANGUAGE)
public class LanguageActivity extends BaseActivity<ActivityLanguageBinding, LanguageViewModel> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_language;
    }

    @Override
    public int initVariableId() {
        return BR.languageViewModel;
    }


    @Override
    public LanguageViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this, factory).get(LanguageViewModel.class);
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
        viewModel.changeObservable.languageEvent.observe(this, new Observer<LanguageEvent>() {
            @Override
            public void onChanged(LanguageEvent languageEvent) {
                if (AppConfig.ZH.equals(languageEvent.getLanguage())){
                    SPUtils.getInstance().put(AppConfig.SP_LANGUAGE,AppConfig.ZH);
                    binding.englishCk.setVisibility(View.GONE);
                    binding.chineseCk.setVisibility(View.VISIBLE);
                    int selectedLanguage = LanguageType.LANGUAGE_CHINESE_SIMPLIFIED;
                    AppManager.getAppManager().finishAllActivity();
                    MultiLanguageUtil.getInstance().updateLanguage(LanguageActivity.this,selectedLanguage);
                    ARouter.getInstance().build(RouterActivityPath.Main.PAGER_MAIN).navigation();
                }else if (AppConfig.EN.equals(languageEvent.getLanguage())){
                    SPUtils.getInstance().put(AppConfig.SP_LANGUAGE,AppConfig.EN);
                    binding.englishCk.setVisibility(View.VISIBLE);
                    binding.chineseCk.setVisibility(View.GONE);
                    int selectedLanguage = LanguageType.LANGUAGE_EN;
                    AppManager.getAppManager().finishAllActivity();
                    MultiLanguageUtil.getInstance().updateLanguage(LanguageActivity.this,selectedLanguage);
                    ARouter.getInstance().build(RouterActivityPath.Main.PAGER_MAIN).navigation();
                }
            }
        });
    }

    /**
     * 加载数据 并保存数据
     */
    @Override
    public void initData() {
        viewModel.setTitleText(getString(com.mvgx.res.R.string.app_general_language));
        viewModel.language = SPUtils.getInstance().getString(AppConfig.SP_LANGUAGE);
        if (AppConfig.ZH.equals(viewModel.language)) {
            binding.chineseCk.setVisibility(View.VISIBLE);
        } else if (AppConfig.EN.equals(viewModel.language)) {
            binding.englishCk.setVisibility(View.VISIBLE);
        }else {
            Locale locale = getResources().getConfiguration().locale;
            String language = locale.getLanguage();
            if (!TextUtils.isEmpty(language)){
                if (language.endsWith("zh")){
                    SPUtils.getInstance().put(AppConfig.SP_LANGUAGE,AppConfig.ZH);
                    binding.chineseCk.setVisibility(View.VISIBLE);
                }else if (language.endsWith("en")){
                    SPUtils.getInstance().put(AppConfig.SP_LANGUAGE,AppConfig.EN);
                    binding.englishCk.setVisibility(View.VISIBLE);
                }
            }else {
                SPUtils.getInstance().put(AppConfig.SP_LANGUAGE, AppConfig.EN);
                binding.englishCk.setVisibility(View.VISIBLE);
            }
        }
        viewModel.setTitleText(getString(com.mvgx.res.R.string.app_general_language));
    }



}
