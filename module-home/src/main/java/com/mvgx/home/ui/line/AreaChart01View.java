
package com.mvgx.home.ui.line;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;


import com.mvgx.home.ui.line.base.AnchorDataPoint;
import com.mvgx.home.ui.line.base.AreaChart;
import com.mvgx.home.ui.line.base.AreaData;
import com.mvgx.home.ui.line.base.CustomLineData;
import com.mvgx.home.ui.line.base.DemoView;
import com.mvgx.home.ui.line.base.IFormatterDoubleCallBack;
import com.mvgx.home.ui.line.base.IFormatterTextCallBack;
import com.mvgx.home.ui.line.base.PointPosition;
import com.mvgx.home.ui.line.base.XEnum;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * @author XiongChuanLiang<br />(xcl_168@aliyun.com)
 * @ClassName AreaChart01View
 * @Description 面积图例子
 */

public class AreaChart01View extends DemoView implements Runnable {


    private AreaChart chart = new AreaChart();
    //标签集合
    private LinkedList<String> mLabels = new LinkedList<String>();
    //数据集合
    private LinkedList<AreaData> mDataset = new LinkedList<AreaData>();

    private AreaChart chartBg = new AreaChart();
    private LinkedList<String> mBgLabels = new LinkedList<String>();

    private List<CustomLineData> mCustomLineDataset = new LinkedList<CustomLineData>();

    private double mStdValue = 30d;
    private String TAG = "AreaChart01View";

    public AreaChart01View(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        initView();
    }

    public AreaChart01View(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public AreaChart01View(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    private void initView() {

        chartLabels();
        chartDataSet();
        chartBgRender();
        chartRender();
        //綁定手势滑动事件
        this.bindTouch(this, chart);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //图所占范围大小
        chartBg.setChartRange(w, h);
        chart.setChartRange(w, h);

    }

    private void chartRender() {
        try {
            //设置绘图区默认缩进px值,留置空间显示Axis,Axistitle....
            int[] ltrb = getBarLnDefaultSpadding();
            chart.setPadding(ltrb[0], ltrb[1], ltrb[2], ltrb[3]);

            chart.disableHighPrecision();
            chart.disablePanMode();

            //轴数据源   标签轴  展示的具体的点
            chart.setCategories(mLabels);
            //数据轴
            chart.setDataSource(mDataset);

            chart.setCrurveLineStyle(XEnum.CrurveLineStyle.BEELINE);

            //数据轴最大值
            chart.getDataAxis().setAxisMax(100);
            //数据轴刻度间隔
            chart.getDataAxis().setAxisSteps(10);

            //网格
            chart.getPlotGrid().hideHorizontalLines();
            chart.getPlotGrid().hideVerticalLines();
            //把顶轴和右轴隐藏
            //chart.hideTopAxis();
            //chart.hideRightAxis();
            //把轴线和刻度线给隐藏起来
            chart.getDataAxis().hideAxisLine();
            chart.getDataAxis().hideTickMarks();
            chart.getCategoryAxis().hideAxisLine();
            chart.getCategoryAxis().hideTickMarks();


            //标题
//            chart.getPlotTitle();
//            chart.addSubtitle("(XCL-Charts Demo)");

            //设定交叉点标签显示格式
            chart.setItemLabelFormatter(new IFormatterDoubleCallBack() {
                @Override
                public String doubleFormatter(Double value) {
                    // TODO Auto-generated method stub
                    DecimalFormat df = new DecimalFormat("#0");
                    String label = df.format(value).toString();
                    return label;
                }
            });
            chart.getAreaFillPaint().setAlpha(254);
            chart.setAreaAlpha(254);

            chart.getDataAxis().hide();
            chart.getCategoryAxis().hide();

            // 颜色值是里面的虚线。
            CustomLineData line1 = new CustomLineData("30", mStdValue, getResources().getColor(com.mvgx.res.R.color.color_666), 7);
            line1.getLineLabelPaint().setColor(Color.RED);
            line1.setLabelHorizontalPostion(Align.LEFT);
            line1.setLineStyle(XEnum.LineStyle.DASH);
            line1.setLabelOffset(chart.getDataAxis().getTickLabelMargin());
            mCustomLineDataset.add(line1);

            CustomLineData line2 = new CustomLineData("20", 20d, getResources().getColor(com.mvgx.res.R.color.color_666), 7);
            line2.setLabelHorizontalPostion(Align.LEFT);
            line2.hideLine();
            line2.setLabelOffset(chart.getDataAxis().getTickLabelMargin());
            line2.getLineLabelPaint().setColor(Color.RED);
            mCustomLineDataset.add(line2);

            CustomLineData line3 = new CustomLineData("10",10d,Color.RED,7);
            line3.setLabelHorizontalPostion(Align.LEFT);
            line3.hideLine();
            line3.getLineLabelPaint().setColor(Color.RED);
            line3.setLabelOffset( chart.getDataAxis().getTickLabelMargin() );
            mCustomLineDataset.add(line3);

            chart.setCustomLines(mCustomLineDataset);

            chart.getPlotLegend().hide();

            //chart.disablePanMode();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Log.e(TAG, e.toString());
        }
    }

    private void chartDataSet() {
        //将标签与对应的数据集分别绑定
        //标签对应的数据集
        List<Double> dataSeries1 = new LinkedList<Double>();

        double testData[] = {40, 21, 32, 56, 40, 54, 46, 32, 89, 76, 53, 62, 66, 78, 47, 53, 90, 80, 60, 82, 77, 67, 79, 85, 83, 90};
        for (int i = 0; i < testData.length; i++) {
            dataSeries1.add(testData[i]);
            mLabels.add(Integer.toString(i));
        }

        //设置每条线各自的显示属性
        //key,数据集,线颜色,区域颜色
        AreaData line1 = new AreaData("小熊", dataSeries1, Color.rgb(108, 180, 223), Color.GRAY);
        //显示点
        line1.setDotStyle(XEnum.DotStyle.RING);

        line1.setApplayGradient(true);
        line1.setAreaBeginColor(Color.WHITE);
        line1.setAreaEndColor(Color.rgb(108, 180, 223));
        line1.setGradientDirection(XEnum.Direction.VERTICAL);

        mDataset.add(line1);

    }

    private void chartBgRender() {
        try {
            //设置绘图区默认缩进px值,留置空间显示Axis,Axistitle....
            int[] ltrb = getBarLnDefaultSpadding();
            chartBg.setPadding(ltrb[0], ltrb[1], ltrb[2], ltrb[3]);

            chartBg.disableHighPrecision();
            chartBg.disablePanMode();

            //轴数据源
            //标签轴
            chartBg.setCategories(mBgLabels);
            //数据轴
            //chartBg.setDataSource(mDataset);

            chartBg.setCrurveLineStyle(XEnum.CrurveLineStyle.BEELINE);

            //数据轴最大值
            chartBg.getDataAxis().setAxisMax(100);
            //数据轴刻度间隔
            chartBg.getDataAxis().setAxisSteps(10);

            //网格
            chartBg.getPlotGrid().hideHorizontalLines();
            chartBg.getPlotGrid().hideVerticalLines();

            //把轴线和刻度线给隐藏起来
            chartBg.getDataAxis().hideAxisLine();
            chartBg.getDataAxis().hideTickMarks();
            chartBg.getCategoryAxis().hideAxisLine();
            chartBg.getCategoryAxis().hideTickMarks();


            chartBg.getDataAxis().getTickLabelPaint().setColor(Color.GREEN);

            //定义数据轴标签显示格式
            chartBg.getDataAxis().setLabelFormatter(new IFormatterTextCallBack() {

                @Override
                public String textFormatter(String value) {
                    // TODO Auto-generated method stub
                    Double tmp = Double.parseDouble(value);
                    if (Double.compare(tmp, mStdValue) == -1 || Double.compare(tmp, mStdValue) == 0) {
                        return "";
                    } else {
                        DecimalFormat df = new DecimalFormat("#0");
                        String label = df.format(tmp).toString();
                        return (label);
                    }
                }

            });

            chartBg.getPlotLegend().hide();
            //chart.disablePanMode();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Log.e(TAG, e.toString());
        }
    }


    private void chartLabels() {
        mBgLabels.add("9:00");
        mBgLabels.add("9:30");
        mBgLabels.add("10:00");
        mBgLabels.add("10:30");
        mBgLabels.add("11:00");
    }

    @Override
    public void render(Canvas canvas) {
        try {
            chartBg.render(canvas);
            chart.render(canvas);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }


    @Override
    public void run() {
// TODO Auto-generated method stub
        try {
            chartAnimation();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }

    private void chartAnimation() {
        try {

            chart.getPlotLegend().hide();

            int[] ltrb = getBarLnDefaultSpadding();
            for (int i = 8; i > 0; i--) {
                Thread.sleep(100);
                chart.setPadding(ltrb[0], ltrb[1], i * ltrb[2], ltrb[3]);

//                if(1 == i)drawTitle();
                postInvalidate();
            }

        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}
