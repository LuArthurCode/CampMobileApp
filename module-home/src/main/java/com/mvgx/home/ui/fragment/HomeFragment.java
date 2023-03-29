package com.mvgx.home.ui.fragment;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.tabs.TabLayout;
import com.mvgx.common.adapter.BaseFragmentPagerAdapter;
import com.mvgx.common.base.BaseFragment;
import com.mvgx.common.router.RouterFragmentPath;
import com.mvgx.home.BR;
import com.mvgx.home.R;
import com.mvgx.home.app.AppViewModelFactory;
import com.mvgx.home.databinding.HomeFragmentBinding;
import com.mvgx.home.ui.viewmodel.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

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

    }

    private void initPageView() {
        BaseFragmentPagerAdapter pagerAdapter = new BaseFragmentPagerAdapter(getChildFragmentManager(), viewModel.mFragments, viewModel.mTitlePager);
        binding.homeViewPager.setAdapter(pagerAdapter);
        binding.homeTabs.setupWithViewPager(binding.homeViewPager);
        binding.homeViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.homeTabs));
    }


    @Override
    public HomeViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        return ViewModelProviders.of(this,factory).get(HomeViewModel.class);
    }
}
