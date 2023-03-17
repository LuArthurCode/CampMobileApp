package com.mvgx.assets.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.mvgx.assets.BR;
import com.mvgx.assets.R;
import com.mvgx.assets.app.AppViewModelFactory;
import com.mvgx.assets.databinding.AssetsFragmentBinding;
import com.mvgx.assets.ui.viewmodel.AssetsViewModel;
import com.mvgx.common.base.BaseFragment;
import com.mvgx.common.router.RouterFragmentPath;

/**
 * @Author Arthur
 * @Date 2023/03/17 14:02
 */
@Route(path = RouterFragmentPath.Assets.PAGER_ASSETS)
public class AssetsFragment extends BaseFragment<AssetsFragmentBinding, AssetsViewModel> {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.assets_fragment;
    }

    @Override
    public int initVariableId() {
        return BR.assetsViewModel;
    }

    public AssetsViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        return ViewModelProviders.of(this,factory).get(AssetsViewModel.class);
    }
}
