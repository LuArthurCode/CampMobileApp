package com.mvgx.campmobile;

import com.mvgx.common.config.ModuleLifecycleConfig;
import com.mvgx.common.base.BaseApplication;


/**
 * @Author Arthur
 * @Date 2023/3/14 14:53
 */
public class AppApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化组件(靠前)
        ModuleLifecycleConfig.getInstance().initModuleAhead(this);
        //....
        //初始化组件(靠后)
        ModuleLifecycleConfig.getInstance().initModuleLow(this);
    }
}

