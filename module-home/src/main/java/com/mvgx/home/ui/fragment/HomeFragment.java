package com.mvgx.home.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.mvgx.common.adapter.CommonPagerAdapter;
import com.mvgx.common.base.BaseFragment;
import com.mvgx.common.router.RouterFragmentPath;
import com.mvgx.home.BR;
import com.mvgx.home.R;
import com.mvgx.home.app.AppViewModelFactory;
import com.mvgx.home.databinding.HomeFragmentBinding;
import com.mvgx.home.ui.viewmodel.HomeViewModel;


/**
 * @Author Arthur
 * @Date 2023/03/17 13:53
 */
@Route(path = RouterFragmentPath.Home.PAGER_HOME)
public class HomeFragment extends BaseFragment<HomeFragmentBinding, HomeViewModel> {

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.home_fragment;
    }

    @Override
    public int initVariableId() {
        return BR.homeViewModel;
    }

    @Override
    public void initData() {
        super.initData();
        viewModel.loadHomeInfo();
    }


    @Override
    public void initViewObservable() {
        super.initViewObservable();
        viewModel.uc.finishRefresh.observe(this, new Observer() {
            @Override
            public void onChanged(Object o) {
                initPageView();
            }
        });
    }

    private void initPageView() {
        CommonPagerAdapter pagerAdapter = new CommonPagerAdapter(getChildFragmentManager(), viewModel.mFragments, viewModel.mTitlePager);
        binding.homeViewPager.setAdapter(pagerAdapter);
        binding.homeTabs.setViewPager(binding.homeViewPager);
        binding.homeTabs.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {

            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }


    @Override
    public HomeViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        return ViewModelProviders.of(this, factory).get(HomeViewModel.class);
    }
}
