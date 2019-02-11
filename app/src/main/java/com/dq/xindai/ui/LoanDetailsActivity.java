package com.dq.xindai.ui;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.dq.xindai.R;
import com.dq.xindai.base.BaseActivity;
import com.dq.xindai.linechart.LineChartEntity;
import com.dq.xindai.linechart.LineChartInViewPager;
import com.dq.xindai.linechart.NewMarkerView;
import com.dq.xindai.linechart.RealListEntity;
import com.dq.xindai.linechart.StringUtils;
import com.dq.xindai.linechart.YoyListEntity;
import com.github.mikephil.chart_3_0_1v.charts.LineChart;
import com.github.mikephil.chart_3_0_1v.components.AxisBase;
import com.github.mikephil.chart_3_0_1v.components.Legend;
import com.github.mikephil.chart_3_0_1v.data.Entry;
import com.github.mikephil.chart_3_0_1v.data.LineDataSet;
import com.github.mikephil.chart_3_0_1v.formatter.IAxisValueFormatter;
import com.github.mikephil.chart_3_0_1v.formatter.IValueFormatter;
import com.github.mikephil.chart_3_0_1v.utils.ViewPortHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 贷款-详情
 * Created by jingang on 2018/6/7.
 */

public class LoanDetailsActivity extends BaseActivity {
    @Bind(R.id.ivLoanDetailBack)
    ImageView back;
    @Bind(R.id.new_lineChart)
    LineChartInViewPager lineChart;
    @Bind(R.id.butLoanDetail)
    Button butLoanDetail;

    private List<RealListEntity> realList;
    private List<YoyListEntity> yoyList;

    private List<Entry> values1, values2, dottedLineData, solidLineData;
    private List<String> dataList;
    private RealListEntity realListEntity;
    private YoyListEntity yoyListEntity;
    private DecimalFormat mFormat;
    private float maxData = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_loan_details);
        ButterKnife.bind(this);
        getData();
        test();
        initViews();
    }

    @OnClick({R.id.ivLoanDetailBack, R.id.butLoanDetail})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivLoanDetailBack:
                finish();
                break;
            case R.id.butLoanDetail:
                goToActivity(ProductApplicationActivity.class);
                break;
        }
    }

    /**
     * 下面json转实体类
     */
    public void test() {
        String data = "{\"realList\":[{\"amount\":\"3740\",\"month\":\"1\",\"year\":\"2018\"}," +
                "{\"amount\":\"2382\",\"month\":\"2\",\"year\":\"2018\"}," +
                "{\"amount\":\"3329\",\"month\":\"3\",\"year\":\"2018\"}," +
                "{\"amount\":\"463\",\"month\":\"4\",\"year\":\"2018\"}],\n" +
                "\"yoyList\":[{\"amount\":\"4571\",\"month\":\"1\",\"year\":\"2017\"}," +
                "{\"amount\":\"1630\",\"month\":\"2\",\"year\":\"2017\"}," +
                "{\"amount\":\"2589\",\"month\":\"3\",\"year\":\"2017\"}," +
                "{\"amount\":\"2180\",\"month\":\"4\",\"year\":\"2017\"}," +
                "{\"amount\":\"3089\",\"month\":\"5\",\"year\":\"2017\"}," +
                "{\"amount\":\"4906\",\"month\":\"6\",\"year\":\"2017\"}," +
                "{\"amount\":\"5741\",\"month\":\"7\",\"year\":\"2017\"}," +
                "{\"amount\":\"3611\",\"month\":\"8\",\"year\":\"2017\"}," +
                "{\"amount\":\"2458\",\"month\":\"9\",\"year\":\"2017\"}," +
                "{\"amount\":\"2608\",\"month\":\"10\",\"year\":\"2017\"}," +
                "{\"amount\":\"5437\",\"month\":\"11\",\"year\":\"2017\"}," +
                "{\"amount\":\"4219\",\"month\":\"12\",\"year\":\"2017\"}]}";
        try {
            JSONObject object = new JSONObject(data);
            JSONArray jsonArray = object.getJSONArray("realList");
            realList = new ArrayList<>();
            for (int i = 0, count = jsonArray.length(); i < count; i++) {
                //改了这里
                JSONObject jsonObject = jsonArray.optJSONObject(i);
                //{"amount":"3740","month":"1","year":"2017"}
                RealListEntity realListEntity = new RealListEntity();
                String amount = jsonObject.optString("amount");
                String month = jsonObject.optString("month");
                String year = jsonObject.optString("year");
                realListEntity.setAmount(amount);
                realListEntity.setMonth(month);
                realListEntity.setYear(year);
                realList.add(realListEntity);
            }

            JSONArray jsonArray1 = object.getJSONArray("yoyList");
            yoyList = new ArrayList<>();
            for (int i = 0, count = jsonArray1.length(); i < count; i++) {
                //改了这里
                JSONObject jsonObject = jsonArray1.optJSONObject(i);
                //{"amount":"3740","month":"1","year":"2017"}
                YoyListEntity yoyListEntity = new YoyListEntity();
                String amount = jsonObject.optString("amount");
                String month = jsonObject.optString("month");
                String year = jsonObject.optString("year");
                yoyListEntity.setAmount(amount);
                yoyListEntity.setMonth(month);
                yoyListEntity.setYear(year);
                yoyList.add(yoyListEntity);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void getData() {
        String data = "{\"exponentList\":[{\"dottedLineData\":\"0.0109\",\"exponentDate\":\"07-04\",\"solidLineData\":\"0.0099\"}," +
                "{\"dottedLineData\":\"0.0102\",\"exponentDate\":\"07-05\",\"solidLineData\":\"0.0039\"}," +
                "{\"dottedLineData\":\"0.0095\",\"exponentDate\":\"07-06\",\"solidLineData\":\"0.0084\"}," +
                "{\"dottedLineData\":\"0.0088\",\"exponentDate\":\"07-07\",\"solidLineData\":\"0.0195\"}," +
                "{\"dottedLineData\":\"0.0081\",\"exponentDate\":\"07-08\",\"solidLineData\":\"0.0148\"}," +
                "{\"dottedLineData\":\"0.0073\",\"exponentDate\":\"07-09\",\"solidLineData\":\"0.0035\"}," +
                "{\"dottedLineData\":\"0.0066\",\"exponentDate\":\"07-10\",\"solidLineData\":\"0.0013\"}],\"overviewName\":\"负面舆情指数\"}";
        try {
            JSONObject object = new JSONObject(data);
            JSONArray jsonArray = object.getJSONArray("exponentList");
            dottedLineData = new ArrayList<>();
            solidLineData = new ArrayList<>();
            dataList = new ArrayList<>();
            BigDecimal scale = new BigDecimal(100);
            for (int i = 0, count = jsonArray.length(); i < count; i++) {
                //改了这里
                JSONObject jsonObject = jsonArray.optJSONObject(i);
                String dottedData = jsonObject.optString("dottedLineData");
                String solidData = jsonObject.optString("solidLineData");
                String exponentDate = jsonObject.optString("exponentDate");
                BigDecimal solid = new BigDecimal(solidData);
                BigDecimal dotted = new BigDecimal(dottedData);
                dottedLineData.add(new Entry(i, (int) scale.multiply(solid).floatValue()));
                solidLineData.add(new Entry(i, (int) scale.multiply(dotted).floatValue()));
                if (Float.valueOf(dottedData) > maxData) {
                    maxData = Float.valueOf(dottedData);
                }
                if (Float.valueOf(solidData) > maxData) {
                    maxData = Float.valueOf(solidData);
                }
                dataList.add(exponentDate);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void initViews() {
        mFormat = new DecimalFormat("#,###.##");

        values1 = new ArrayList<>();
        values2 = new ArrayList<>();
        for (int i = 0; i < yoyList.size(); i++) {
            yoyListEntity = yoyList.get(i);
            String amount = yoyListEntity.getAmount();
            if (amount != null) {
                float f = 0;
                try {
                    f = Float.parseFloat(amount);
                } catch (Exception e) {
                    e.printStackTrace();
                    f = 0;
                }
                Entry entry = new Entry(i + 1, (int) f);
                values1.add(entry);
            }
        }

        for (int i = 0; i < realList.size(); i++) {
            realListEntity = realList.get(i);
            String amount = realListEntity.getAmount();
            if (amount != null) {
                float f = 0;
                try {
                    f = Float.parseFloat(amount);
                } catch (Exception e) {
                    e.printStackTrace();
                    f = 0;
                }
                Entry entry = new Entry(i + 1, (int) f);
                values2.add(entry);
            }
        }


        Drawable[] drawables = {
                ContextCompat.getDrawable(this, R.drawable.chart_thisyear_blue),
                ContextCompat.getDrawable(this, R.drawable.chart_callserice_call_casecount)
        };
        int[] callDurationColors = {Color.parseColor("#45A2FF"), Color.parseColor("#5fd1cc")};
        String thisYear = "";
        if (realList.size() > 0) {
            thisYear = realList.get(0).getYear();
        }

        String lastYear = "";
        if (yoyList.size() > 0) {
            lastYear = yoyList.get(0).getYear();
        }
        String[] labels = new String[]{thisYear, lastYear};
        updateLinehart(yoyList, realList, lineChart, callDurationColors, drawables, "", values1, values2, labels);
    }


    /**
     * 双平滑曲线传入数据，添加markview，添加实体类单位
     *
     * @param yoyList
     * @param realList
     * @param lineChart
     * @param colors
     * @param drawables
     * @param unit
     * @param values2
     * @param values1
     * @param labels
     */
    @SuppressWarnings("unchecked")
    private void updateLinehart(final List<YoyListEntity> yoyList, final List<RealListEntity> realList, LineChart lineChart, int[] colors, Drawable[] drawables,
                                final String unit, List<Entry> values2, List<Entry> values1, final String[] labels) {
        List<Entry>[] entries = new ArrayList[2];
        entries[0] = values1;
        entries[1] = values2;
        LineChartEntity lineChartEntity = new LineChartEntity(lineChart, entries, labels, colors, Color.parseColor("#999999"), 12f);
        lineChartEntity.drawCircle(true);
        lineChart.setScaleMinima(1.0f, 1.0f);
        toggleFilled(lineChartEntity, drawables, colors);

        /**
         * 这里切换平滑曲线或者折现图
         */
        lineChartEntity.setLineMode(LineDataSet.Mode.HORIZONTAL_BEZIER);
        lineChartEntity.initLegend(Legend.LegendForm.CIRCLE, 12f, Color.parseColor("#999999"));
        lineChartEntity.updateLegendOrientation(Legend.LegendVerticalAlignment.TOP, Legend.LegendHorizontalAlignment.RIGHT, Legend.LegendOrientation.HORIZONTAL);
        lineChartEntity.setAxisFormatter(
                new IAxisValueFormatter() {
                    @Override
                    public String getFormattedValue(float value, AxisBase axis) {
                        if (value == 1.0f) {
                            return mFormat.format(value) + "月";
                        }
                        String monthStr = mFormat.format(value);
                        if (monthStr.contains(".")) {
                            return "";
                        } else {
                            return monthStr;
                        }
//                        return mMonthFormat.format(value);
                    }
                },
                new IAxisValueFormatter() {
                    @Override
                    public String getFormattedValue(float value, AxisBase axis) {
                        return mFormat.format(value) + unit;
                    }
                });

        lineChartEntity.setDataValueFormatter(new IValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                return mFormat.format(value) + unit;
            }
        });

        final NewMarkerView markerView = new NewMarkerView(this, R.layout.custom_marker_view_layout);
        markerView.setCallBack(new NewMarkerView.CallBack() {
            @Override
            public void onCallBack(float x, String value) {
                int index = (int) (x);
                if (index < 0) {
                    return;
                }
                if (index > yoyList.size() && index > realList.size()) {
                    return;
                }
                String textTemp = "";

                if (index <= yoyList.size()) {
                    if (!StringUtils.isEmpty(textTemp)) {
                    }
                    textTemp += yoyList.get(index - 1).getYear() + "." + index + "  " + mFormat.format(Float.parseFloat(yoyList.get(index - 1).getAmount())) + unit;
                }

                if (index <= realList.size()) {
                    textTemp += "\n";
                    textTemp += realList.get(index - 1).getYear() + "." + index + "  " + mFormat.format(Float.parseFloat(realList.get(index - 1).getAmount())) + unit;
                }
                markerView.getTvContent().setText(textTemp);
            }
        });
        lineChartEntity.setMarkView(markerView);
        lineChart.getData().setDrawValues(false);
    }

    /**
     * 双平滑曲线添加线下的阴影
     *
     * @param lineChartEntity
     * @param drawables
     * @param colors
     */
    private void toggleFilled(LineChartEntity lineChartEntity, Drawable[] drawables, int[] colors) {
        if (Build.VERSION.SDK_INT >= 18) {

            lineChartEntity.toggleFilled(drawables, null, true);
        } else {
            lineChartEntity.toggleFilled(null, colors, true);
        }
    }


}
