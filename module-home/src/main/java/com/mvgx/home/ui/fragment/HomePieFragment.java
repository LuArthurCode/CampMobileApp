package com.mvgx.home.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.mvgx.common.base.BaseFragment;
import com.mvgx.home.BR;
import com.mvgx.home.R;
import com.mvgx.home.databinding.HomePieFragmentBinding;
import com.mvgx.home.ui.viewmodel.HomePieViewModel;

import java.util.ArrayList;

/**
 * @Author Arthur
 * @Date 2023/03/29 11:02
 */
public class HomePieFragment extends BaseFragment<HomePieFragmentBinding, HomePieViewModel> {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.home_pie_fragment;
    }

    @Override
    public int initVariableId() {
        return BR.homePieViewModel;
    }

    @Override
    public void initData() {
        super.initData();
        initPieData();
    }

    private void initPieData() {
        binding.chart1.setUsePercentValues(true);
        binding.chart1.getDescription().setEnabled(false);
        //设置额外的偏移量（围绕图表视图）附加到自动计算的偏移量。
        binding.chart1.setExtraOffsets(5, 10, 5, 5);
        binding.chart1.setDrawHoleEnabled(true);
        //中间的颜色
//        binding.chart1.setHoleColor(Color.WHITE);

        binding.chart1.setTransparentCircleColor(Color.WHITE);
        binding.chart1.setTransparentCircleAlpha(110);

        binding.chart1.setHoleRadius(58f);
        binding.chart1.setTransparentCircleRadius(61f);

        binding.chart1.setDrawCenterText(true);

        binding.chart1.setRotationAngle(0);
        // enable rotation of the chart by touch
        binding.chart1.setRotationEnabled(true);
        binding.chart1.setHighlightPerTapEnabled(true);

        // chart.setUnit(" €");
        // chart.setDrawUnitsInChart(true);

        // add a selection listener
//        binding.chart1.setOnChartValueSelectedListener(this);

        binding.chart1.animateY(1400, Easing.EaseInOutQuad);
        // chart.spin(2000, 0, 360);

        Legend l = binding.chart1.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setEnabled(false);
        setData(5,12.33F);
    }

    private void setData(int count, float range) {

        ArrayList<PieEntry> entries = new ArrayList<>();

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (int i = 0; i < count; i++) {
            entries.add(new PieEntry((float) (Math.random() * range) + range / 5,10));
        }

        PieDataSet dataSet = new PieDataSet(entries, "Election Results");
        //设置 dp 中饼图切片之间留出的空间。默认值：0 --> 无空格，最大 20f
        dataSet.setSliceSpace(0f);
        //设置此 DataSet 的突出显示的饼图切片从图表中心“偏移”的距离，默认为 12f
        dataSet.setSelectionShift(80f);

        // add a lot of colors

        ArrayList<Integer> colors = new ArrayList<>();

        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());

        dataSet.setColors(colors);
        dataSet.setSelectionShift(0f);

        //设置的虚线
        dataSet.setValueLinePart2Length(1f);
        dataSet.setValueLinePart1OffsetPercentage(80.f);
        dataSet.setValueLinePart1Length(0.2f);
        dataSet.setValueLinePart2Length(0.4f);

        //dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.BLACK);
//        data.setValueTypeface(tf);
        binding.chart1.setData(data);

        // undo all highlights
        binding.chart1.highlightValues(null);

        binding.chart1.invalidate();
    }

}
