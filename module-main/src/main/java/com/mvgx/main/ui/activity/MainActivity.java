package com.mvgx.main.ui.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.mvgx.common.base.BaseActivity;
import com.mvgx.common.base.BaseViewModel;
import com.mvgx.common.router.RouterActivityPath;
import com.mvgx.common.router.RouterFragmentPath;
import com.mvgx.main.BR;
import com.mvgx.main.R;
import com.mvgx.main.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;
import me.majiajie.pagerbottomtabstrip.item.NormalItemView;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;

/**
 * @Author Arthur
 * @Date 2023\03\16 10:35
 */
@Route(path = RouterActivityPath.Main.PAGER_MAIN)
public class MainActivity extends BaseActivity<ActivityMainBinding, BaseViewModel> {

    private List<Fragment> mFragments;

    private NormalItemView normalItemView;

    private NavigationController navigationController;

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
        Fragment workFragment = (Fragment) ARouter.getInstance().build(RouterFragmentPath.Client.PAGER_CLIENT).navigation();
        Fragment msgFragment = (Fragment) ARouter.getInstance().build(RouterFragmentPath.Assets.PAGER_ASSETS).navigation();
        Fragment meFragment = (Fragment) ARouter.getInstance().build(RouterFragmentPath.Me.PAGER_ME).navigation();
        Fragment maskFragment = (Fragment) ARouter.getInstance().build(RouterFragmentPath.Trade.PAGER_TRADE).navigation();
        mFragments = new ArrayList<>();
        mFragments.add(homeFragment);
        mFragments.add(workFragment);
        mFragments.add(msgFragment);
        mFragments.add(meFragment);
        mFragments.add(maskFragment);
        if (homeFragment != null) {
            //默认选中第一个
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.frameLayout, homeFragment);
            transaction.commitAllowingStateLoss();
        }
    }

    private void initBottomTab() {
        navigationController = binding.pagerBottomTab.custom()
                .addItem(newItem(com.mvgx.res.R.mipmap.icon_home, com.mvgx.res.R.mipmap.icon_home_pick, getString(com.mvgx.res.R.string.app_item_home)))
                .addItem(newItem(com.mvgx.res.R.mipmap.icon_card, com.mvgx.res.R.mipmap.icon_card_pick, getString(com.mvgx.res.R.string.app_item_card)))
                .addItem(newItem(com.mvgx.res.R.mipmap.icon_wallet, com.mvgx.res.R.mipmap.icon_wallet_pick, getString(com.mvgx.res.R.string.app_item_wallet)))
                .addItem(newItem(com.mvgx.res.R.mipmap.icon_me, com.mvgx.res.R.mipmap.icon_me_pick, getString(com.mvgx.res.R.string.app_item_me)))
                .addItem(newItem(com.mvgx.res.R.mipmap.icon_me, com.mvgx.res.R.mipmap.icon_me_pick, getString(com.mvgx.res.R.string.app_item_me)))
                .build();
        //底部按钮的点击事件监听
        navigationController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
                Fragment currentFragment = mFragments.get(index);
                if (currentFragment != null) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameLayout, currentFragment);
                    transaction.commitAllowingStateLoss();
                }
            }

            @Override
            public void onRepeat(int index) {
            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    private BaseTabItem newItem(int drawable, int checkedDrawable, String text) {
        normalItemView = new NormalItemView(this);
        normalItemView.initialize(drawable, checkedDrawable, text);
        normalItemView.setTextDefaultColor(Color.GRAY);
        normalItemView.setTextCheckedColor(getColor(com.mvgx.res.R.color.color_eb2));
        return normalItemView;
    }
}
