package com.mvgx.common.init.binding.viewadapter.twinklingrefreshlayout;

import androidx.databinding.BindingAdapter;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.mvgx.common.init.binding.command.BindingCommand;


/**
 * Created by goldze on 2017/6/16.
 * TwinklingRefreshLayout列表刷新的绑定适配器
 */
public class ViewAdapter {

    @BindingAdapter(value = {"onRefreshCommand", "onLoadMoreCommand"}, requireAll = false)
    public static void onRefreshAndLoadMoreCommand(TwinklingRefreshLayout layout, final BindingCommand onRefreshCommand, final BindingCommand onLoadMoreCommand) {
        layout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);
                if (onRefreshCommand != null) {
                    onRefreshCommand.execute();
                }
            }

            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                super.onLoadMore(refreshLayout);
                if (onLoadMoreCommand != null) {
                    onLoadMoreCommand.execute();
                }
            }

        });
    }

    @BindingAdapter(value = {"tr_enable_refresh"}, requireAll = false)
    public static void onEnableRefreshCommand(TwinklingRefreshLayout layout, final boolean enAble) {
        layout.setEnableRefresh(enAble);
    }

    @BindingAdapter(value = {"tr_enable_loadmore"}, requireAll = false)
    public static void onEnableLoadCommand(TwinklingRefreshLayout layout, final boolean enAble) {
        layout.setEnableLoadmore(enAble);
    }


}
