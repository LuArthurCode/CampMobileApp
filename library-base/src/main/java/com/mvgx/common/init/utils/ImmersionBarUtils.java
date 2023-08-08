package com.mvgx.common.init.utils;
import android.annotation.SuppressLint;

import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.mvgx.common.R;
import com.mvgx.common.config.AppConfig;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle2.components.support.RxFragment;

import skin.support.SkinCompatManager;


public class ImmersionBarUtils {

    private static ImmersionBar with;

    public static void setUpStatusBar(RxFragment fragment, boolean isDarkFont, boolean keyboardEnable, int barColor){
        boolean mSkin = SPUtils.getInstance().getBoolean(AppConfig.SKIN_DEFAULT);
        if (mSkin){
            //黑色背景
            barColor = com.mvgx.res.R.color.color_background_black;
            isDarkFont =false;
        }else {
            //默认白色背景
            barColor =com.mvgx.res.R.color.white;
        }
        if (with == null){
            ImmersionBar.with(fragment).statusBarDarkFont(isDarkFont,0.2f)
                    .statusBarColor(barColor)
                    .fitsSystemWindows(true)
                    .autoNavigationBarDarkModeEnable(true)
                    .navigationBarColor(com.mvgx.res.R.color.white)
                    .init();
        }else {
            with.statusBarDarkFont(isDarkFont,0.2f)
                    .statusBarColor(barColor)
                    .fitsSystemWindows(true)
                    .autoNavigationBarDarkModeEnable(true)
                    .navigationBarColor(com.mvgx.res.R.color.white)
                    .init();
        }
    }

   /* statusBarDarkFont(false)  字体颜色是否显示白色*/
    @SuppressLint("ResourceType")
    public static void setUpStatusBar(RxAppCompatActivity activity, boolean isDarkFont, boolean keyboardEnable , int color){
        boolean mSkin = SPUtils.getInstance().getBoolean(AppConfig.SKIN_DEFAULT);
        if (mSkin){
            //黑色背景
            color = com.mvgx.res.R.color.color_background_black;
            isDarkFont =false;
        }else {
            //默认白色背景
            color =com.mvgx.res.R.color.white;
            isDarkFont =true;
        }
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

    @SuppressLint("ResourceType")
    public static void setUpStatusBar(RxAppCompatActivity activity,  boolean keyboardEnable){
        boolean isDarkFont = false;
        int color;
        boolean mSkin = SPUtils.getInstance().getBoolean(AppConfig.SKIN_DEFAULT);
        if (mSkin){
            //黑色背景
            color = com.mvgx.res.R.color.color_background_black;
            isDarkFont =false;
        }else {
            //默认白色背景
            color =com.mvgx.res.R.color.white;
            isDarkFont =true;
        }
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


    public static void setHideBar(RxAppCompatActivity activity){
        if (with == null){
            ImmersionBar.with(activity)
                    .fullScreen(true)
                    .init();
        }else {
            with.fullScreen(true)
                    .init();
        }
    }


}
