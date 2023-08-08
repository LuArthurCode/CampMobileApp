package com.mvgx.assets;

import android.app.Application;

import com.mvgx.common.base.IModuleInit;
import com.mvgx.common.init.utils.KLog;

/**
 * Created by goldze on 2018/6/21 0021.
 */

public class AssetsModuleInit implements IModuleInit {
    @Override
    public boolean onInitAhead(Application application) {
        KLog.e("资产模块初始化 -- onInitAhead");
        return false;
    }

    @Override
    public boolean onInitLow(Application application) {
        KLog.e("资产模块初始化 -- onInitLow");
        return false;
    }
}
