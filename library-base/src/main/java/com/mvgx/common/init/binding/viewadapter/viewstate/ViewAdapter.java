package com.mvgx.common.init.binding.viewadapter.viewstate;

import android.view.View;

import androidx.databinding.BindingAdapter;

import com.kennyc.view.MultiStateView;
import com.mvgx.common.init.binding.command.BindingCommand;


/**
 * Created by goldze on 2017/6/16.
 * TwinklingRefreshLayout列表刷新的绑定适配器
 */
public class ViewAdapter {

    @BindingAdapter(value = {"msv_viewState"},requireAll = false)
    public static void onViewState(MultiStateView multiStateView, final MultiStateView.ViewState viewState) {
        switch (viewState){
            case CONTENT:
                multiStateView.setViewState(viewState.CONTENT);
                break;
            case EMPTY:
                multiStateView.setViewState(viewState.EMPTY);
                break;
            case ERROR:
                multiStateView.setViewState(viewState.ERROR);
                break;
            case LOADING:
                multiStateView.setViewState(viewState.LOADING);
                break;
        }
    }

    @BindingAdapter(value = {"onStateClickCommand"}, requireAll = false)
    public static void onItemClickCommand(final MultiStateView multiStateView, final BindingCommand<Integer> onItemClickCommand) {
        multiStateView.getView(MultiStateView.ViewState.ERROR).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickCommand != null) {
                    onItemClickCommand.execute();
                }
            }
        });
    }
}
