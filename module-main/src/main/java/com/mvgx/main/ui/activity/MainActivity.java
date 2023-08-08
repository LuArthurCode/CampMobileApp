package com.mvgx.main.ui.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.mvgx.common.base.BaseActivity;
import com.mvgx.common.base.BaseViewModel;
import com.mvgx.common.entity.TabEntity;
import com.mvgx.common.language.MultiLanguageUtil;
import com.mvgx.common.router.RouterActivityPath;
import com.mvgx.common.router.RouterFragmentPath;
import com.mvgx.main.BR;
import com.mvgx.main.R;
import com.mvgx.main.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
/**
 * @Author Arthur
 * @Date 2023\03\16 10:35
 */
@Route(path = RouterActivityPath.Main.PAGER_MAIN)
public class MainActivity extends BaseActivity<ActivityMainBinding, BaseViewModel> {

    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    private List<Fragment> mFragments;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        //初始化Fragment
        initFragment();
        //初始化底部Button
        initBottomTab();
    }

    private void initFragment() {
        //ARouter拿到多Fragment(这里需要通过ARouter获取，不能直接new,因为在组件独立运行时，宿主app是没有依赖其他组件，所以new不到其他组件的Fragment)
        Fragment homeFragment = (Fragment) ARouter.getInstance().build(RouterFragmentPath.Home.PAGER_HOME).navigation();
        Fragment clickFragment = (Fragment) ARouter.getInstance().build(RouterFragmentPath.Client.PAGER_CLIENT).navigation();
        Fragment tradeFragment = (Fragment) ARouter.getInstance().build(RouterFragmentPath.Assets.PAGER_ASSETS).navigation();
        Fragment assetsFragment = (Fragment) ARouter.getInstance().build(RouterFragmentPath.Trade.PAGER_TRADE).navigation();
        Fragment meFragment = (Fragment) ARouter.getInstance().build(RouterFragmentPath.Me.PAGER_ME).navigation();
        mFragments = new ArrayList<>();
        mFragments.add(homeFragment);
        mFragments.add(clickFragment);
        mFragments.add(tradeFragment);
        mFragments.add(assetsFragment);
        mFragments.add(meFragment);
        if (homeFragment != null) {
            //默认选中第一个
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.frameLayout, homeFragment);
            transaction.commitAllowingStateLoss();
        }
    }

    private void initBottomTab() {
        String[] mTitles = {this.getResources().getString(com.mvgx.res.R.string.app_item_home),
                this.getResources(). getString(com.mvgx.res.R.string.app_item_client),
                this.getResources().getString(com.mvgx.res.R.string.app_item_trade),
                this.getResources().getString(com.mvgx.res.R.string.app_item_assets),
                this.getResources().getString(com.mvgx.res.R.string.app_item_me)};
        int[] mIconUnselectIds = {
                com.mvgx.res.R.mipmap.icon_home, com.mvgx.res.R.mipmap.icon_client,
                com.mvgx.res.R.mipmap.icon_trade, com.mvgx.res.R.mipmap.icon_assets
                , com.mvgx.res.R.mipmap.icon_me};
        int[] mIconSelectIds = {
                com.mvgx.res.R.mipmap.icon_home_pick, com.mvgx.res.R.mipmap.icon_client_pick,
                com.mvgx.res.R.mipmap.icon_trade, com.mvgx.res.R.mipmap.icon_assets_pick
                , com.mvgx.res.R.mipmap.icon_me_pick};

        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        binding.tl2.setTabData(mTabEntities);
        binding.tl2.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int index) {
                Fragment currentFragment = mFragments.get(index);
                if (currentFragment != null) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameLayout, currentFragment);
                    transaction.commitAllowingStateLoss();
                }
            }

            @Override
            public void onTabReselect(int position) {
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(MultiLanguageUtil.attachBaseContext(newBase));
        //app杀进程启动后会调用Activity attachBaseContext
        MultiLanguageUtil.getInstance().setConfiguration(newBase);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
