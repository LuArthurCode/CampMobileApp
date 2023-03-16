package com.mvgx.common.init.utils;
import com.gyf.immersionbar.ImmersionBar;
import com.mvgx.common.R;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle2.components.support.RxFragment;


public class ImmersionBarUtils {

    private static ImmersionBar with;

    public static void setUpStatusBar(RxFragment fragment, boolean isDarkFont, boolean keyboardEnable, int barColor){
        if (with == null){
            ImmersionBar.with(fragment).statusBarDarkFont(isDarkFont,0.2f)
                    .statusBarColor(barColor)
                    .fitsSystemWindows(true)
                    .autoNavigationBarDarkModeEnable(true)
                    .navigationBarColor(R.color.white)
                    .init();
        }else {
            with.statusBarDarkFont(isDarkFont,0.2f)
                    .statusBarColor(barColor)
                    .fitsSystemWindows(true)
                    .autoNavigationBarDarkModeEnable(true)
                    .navigationBarColor(R.color.white)
                    .init();
        }
    }

   /* statusBarDarkFont(false)  字体颜色是否显示白色*/
    public static void setUpStatusBar(RxAppCompatActivity activity, boolean isDarkFont, boolean keyboardEnable , int color){
        if (with == null){
            ImmersionBar.with(activity).statusBarDarkFont(isDarkFont,0.2f)
                    .statusBarColor(color)
                    .fitsSystemWindows(true)
                    .autoNavigationBarDarkModeEnable(true)
                    .keyboardEnable(keyboardEnable)
                    .navigationBarColor(color)
                    .init();
        }else {
            with.statusBarDarkFont(isDarkFont,0.2f)
                    .statusBarColor(color)
                    .fitsSystemWindows(true)
                    .autoNavigationBarDarkModeEnable(true)
                    .keyboardEnable(keyboardEnable)
                    .navigationBarColor(color)
                    .init();
        }
    }


}
