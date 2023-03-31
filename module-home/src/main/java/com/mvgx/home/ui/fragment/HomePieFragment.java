package com.mvgx.home.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.mvgx.common.base.BaseFragment;
import com.mvgx.common.response.HomePieResponse;
import com.mvgx.common.router.RouterFragmentPath;
import com.mvgx.home.BR;
import com.mvgx.home.R;
import com.mvgx.home.app.AppViewModelFactory;
import com.mvgx.home.databinding.HomePieFragmentBinding;
import com.mvgx.home.ui.viewmodel.HomePieViewModel;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Arthur
 * @Date 2023/03/29 11:02
 */
@Route(path = RouterFragmentPath.Home.PAGER_HOME_PIE)
public class HomePieFragment extends BaseFragment<HomePieFragmentBinding, HomePieViewModel> {

    public HomePieResponse mHomeInfo;


    /**
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.home_pie_fragment;
    }

    public HomePieFragment(HomePieResponse homeInfo) {
        if (homeInfo == null) return;
        mHomeInfo = homeInfo;

        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
//        if (null != homeInfo) {
//            JsonElement element = parser.parse(gson.toJson(homeInfo));
//            if (element.isJsonObject()) {//假设最外层是object
//                // 把JsonElement对象转换成JsonObject
//                JsonObject JsonObject = element.getAsJsonObject();
//                JsonElement jsonElement = JsonObject.get("value");
//                if (jsonElement.isJsonObject()) {
//                    Double value = gson.fromJson(jsonElement, Double.class);
//                } else if (jsonElement.isJsonArray()) {
//                    Type type = new TypeToken<List<HomeGraphEntity>>() {
//                    }.getType();
//                    // 把JsonElement对象转换成JsonArray
//                    List<HomeGraphEntity> list = gson.fromJson(jsonElement, type);
//                }
//            }
//        }
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
        //如果启用此功能，饼图中的值将以百分比形式绘制，而不是使用它们的原始值。然后以百分比形式提供为 IValueFormatter 格式化的值。参数：启用
        binding.chart1.setUsePercentValues(true);
        //返回图表的 Description 对象，该对象负责保存与显示在图表右下角（默认情况下）的描述文本相关的所有信息。退货：
        binding.chart1.getDescription().setEnabled(false);
        //设置额外的偏移量（围绕图表视图）附加到自动计算的偏移量。
        binding.chart1.setExtraOffsets(5, 10, 5, 5);
        binding.chart1.setDrawHoleEnabled(true);

        binding.chart1.setTransparentCircleColor(Color.WHITE);
        binding.chart1.setTransparentCircleAlpha(110);
        //饼状图中间的圆的半径大小
        binding.chart1.setHoleRadius(58f);
        //设置圆环的半径值
        binding.chart1.setTransparentCircleRadius(61f);

        binding.chart1.setDrawCenterText(false);

        binding.chart1.setRotationAngle(0);
        // enable rotation of the chart by touch
        binding.chart1.setRotationEnabled(true);
        binding.chart1.setHighlightPerTapEnabled(true);

        binding.chart1.animateY(1400, Easing.EaseInOutQuad);
        // chart.spin(2000, 0, 360);

        Legend l = binding.chart1.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setEnabled(false);
        setData(5, 12.33F);
    }

    private void setData(int count, float range) {

        ArrayList<PieEntry> entries = new ArrayList<>();

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (int i = 0; i < count; i++) {
            entries.add(new PieEntry(10F, ""));
        }

        PieDataSet dataSet = new PieDataSet(entries, "Election Results");
        //设置 dp 中饼图切片之间留出的空间。默认值：0 --> 无空格，最大 20f
        dataSet.setSliceSpace(0f);
        //设置此 DataSet 的突出显示的饼图切片从图表中心“偏移”的距离，默认为 12f
        dataSet.setSelectionShift(80f);

        // add a lot of colors
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(getResources().getColor(com.mvgx.res.R.color.pie_color_two));
        colors.add(getResources().getColor(com.mvgx.res.R.color.pie_color_three));
        colors.add(getResources().getColor(com.mvgx.res.R.color.pie_color_four));
        colors.add(getResources().getColor(com.mvgx.res.R.color.pie_color_five));
        colors.add(getResources().getColor(com.mvgx.res.R.color.pie_color_six));
        colors.add(getResources().getColor(com.mvgx.res.R.color.pie_color_seven));

        dataSet.setColors(colors);
        dataSet.setSelectionShift(0f);

        //设置的虚线
        dataSet.setValueLinePart1OffsetPercentage(100.f);
        dataSet.setValueLinePart1Length(0.4f);
        dataSet.setValueLinePart2Length(1.2f);
        dataSet.setUsingSliceColorAsValueLineColor(true);
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

        //设置虚线中的文字大小
        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(13f);
        data.setValueTextColors(colors);
        binding.chart1.setData(data);
        binding.chart1.setDrawHoleEnabled(true);
        binding.chart1.setHoleColor(getResources().getColor(com.mvgx.res.R.color.transparent));
        // undo all highlights
        binding.chart1.highlightValues(null);
        //设置上下边距 来控制圆形的大小
        binding.chart1.setExtraOffsets(0f, 32f, 0f, 32f);

        binding.chart1.invalidate();
    }

    @Override
    public HomePieViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        return ViewModelProviders.of(this, factory).get(HomePieViewModel.class);
    }

}
