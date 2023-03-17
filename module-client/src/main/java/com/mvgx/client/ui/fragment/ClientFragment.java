package com.mvgx.client.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.mvgx.client.BR;
import com.mvgx.client.R;
import com.mvgx.client.app.AppViewModelFactory;
import com.mvgx.client.databinding.ClientFragmentBinding;
import com.mvgx.client.ui.viewmodel.ClientViewModel;
import com.mvgx.common.base.BaseFragment;
import com.mvgx.common.router.RouterFragmentPath;

/**
 * @Author Arthur
 * @Date 2023/03/17 13:57
 */
@Route(path = RouterFragmentPath.Client.PAGER_CLIENT)
public class ClientFragment extends BaseFragment<ClientFragmentBinding, ClientViewModel> {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.client_fragment;
    }

    @Override
    public int initVariableId() {
        return BR.clientViewModel;
    }

    public ClientViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        return ViewModelProviders.of(this,factory).get(ClientViewModel.class);
    }
}
