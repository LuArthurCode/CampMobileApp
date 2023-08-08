package com.mvgx.trade.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.mvgx.common.base.BaseFragment;
import com.mvgx.common.router.RouterFragmentPath;
import com.mvgx.trade.BR;
import com.mvgx.trade.R;
import com.mvgx.trade.app.AppViewModelFactory;
import com.mvgx.trade.databinding.TradeFragmentBinding;
import com.mvgx.trade.ui.viewmodel.TradeViewModel;

/**
 * @Author Arthur
 * @Date 2023/03/17 14:10
 */
@Route(path = RouterFragmentPath.Trade.PAGER_TRADE)
public class TradeFragment extends BaseFragment<TradeFragmentBinding, TradeViewModel> {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.trade_fragment;
    }

    @Override
    public int initVariableId() {
        return BR.tradeViewModel;
    }

    public TradeViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        return ViewModelProviders.of(this,factory).get(TradeViewModel.class);
    }
}
