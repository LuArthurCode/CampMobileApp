package com.mvgx.client;

import android.app.Application;

import com.mvgx.common.base.IModuleInit;
import com.mvgx.common.init.utils.KLog;

/**
 * Created by goldze on 2018/6/21 0021.
 */

public class ClientModuleInit implements IModuleInit {
    @Override
    public boolean onInitAhead(Application application) {
        KLog.e("客户模块初始化 -- onInitAhead");
        return false;
    }

    @Override
    public boolean onInitLow(Application application) {
        KLog.e("客户模块初始化 -- onInitLow");
        return false;
    }
}
