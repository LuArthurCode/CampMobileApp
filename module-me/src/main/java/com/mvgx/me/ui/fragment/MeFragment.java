package com.mvgx.me.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.mvgx.common.base.BaseFragment;
import com.mvgx.common.router.RouterFragmentPath;
import com.mvgx.me.BR;
import com.mvgx.me.R;
import com.mvgx.me.app.AppViewModelFactory;
import com.mvgx.me.databinding.MeFragmentBinding;
import com.mvgx.me.ui.viewmodel.MeViewModel;

/**
 * @Author Arthur
 * @Date 2023/03/17 14:04
 */

@Route(path = RouterFragmentPath.Me.PAGER_ME)
public class MeFragment extends BaseFragment<MeFragmentBinding, MeViewModel> {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.me_fragment;
    }

    @Override
    public int initVariableId() {
        return BR.meViewModel;
    }

    public MeViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        return ViewModelProviders.of(this,factory).get(MeViewModel.class);
    }
}
