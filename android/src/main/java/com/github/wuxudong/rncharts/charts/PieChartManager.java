package com.github.wuxudong.rncharts.charts;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.github.mikephil.charting.data.PieEntry;
import com.github.wuxudong.rncharts.data.DataExtract;
import com.github.wuxudong.rncharts.data.PieDataExtract;
import com.github.wuxudong.rncharts.listener.RNOnChartGestureListener;
import com.github.wuxudong.rncharts.listener.RNOnChartValueSelectedListener;
import com.github.wuxudong.rncharts.utils.BridgeUtils;
import com.github.wuxudong.rncharts.utils.TypefaceUtils;

public class PieChartManager extends ChartBaseManager<PieChart, PieEntry> {

    @Override
    public String getName() {
        return "RNPieChart";
    }

    @Override
    protected PieChart createViewInstance(ThemedReactContext reactContext) {
        PieChart pieChart =  new PieChart(reactContext);
        pieChart.setOnChartValueSelectedListener(new RNOnChartValueSelectedListener(pieChart));
        pieChart.setOnChartGestureListener(new RNOnChartGestureListener(pieChart));
        return pieChart;
    }

    @Override
    DataExtract getDataExtract() {
        return new PieDataExtract();
    }

    @ReactProp(name = "extraOffsets")
    public void setExtraOffsets(PieChart chart, ReadableMap propMap) {
        double left = 0, top = 0, right = 0, bottom = 0;

        if (BridgeUtils.validate(propMap, ReadableType.Number, "left")) {
            left = propMap.getDouble("left");
        }
        if (BridgeUtils.validate(propMap, ReadableType.Number, "top")) {
            top = propMap.getDouble("top");
        }
        if (BridgeUtils.validate(propMap, ReadableType.Number, "right")) {
            right = propMap.getDouble("right");
        }
        if (BridgeUtils.validate(propMap, ReadableType.Number, "bottom")) {
            bottom = propMap.getDouble("bottom");
        }
        chart.setExtraOffsets((float) left, (float) top, (float) right, (float) bottom);
    }

    @ReactProp(name = "drawEntryLabels")
    public void setDrawEntryLabels(PieChart chart, boolean enabled) {
        chart.setDrawEntryLabels(enabled);
    }

    @ReactProp(name = "usePercentValues")
    public void setUsePercentValues(PieChart chart, boolean enabled) {
        chart.setUsePercentValues(enabled);
    }

    @ReactProp(name = "centerText")
    public void setCenterText(PieChart chart, String text) {
        chart.setCenterText(text);
    }

    @ReactProp(name = "styledCenterText")
    public void setStyledCenterText(PieChart chart, ReadableMap propMap) {
        if (BridgeUtils.validate(propMap, ReadableType.String, "text")) {
            chart.setCenterText(propMap.getString("text"));
        } else {
            chart.setCenterText("");
        }

        if (BridgeUtils.validate(propMap, ReadableType.Number, "color")) {
            chart.setCenterTextColor(propMap.getInt("color"));
        }

        if (BridgeUtils.validate(propMap, ReadableType.Number, "size")) {
            chart.setCenterTextSize((float) propMap.getDouble("size"));
        }

        if (BridgeUtils.validate(propMap, ReadableType.String, "fontFamily")) {
            chart.setCenterTextTypeface(TypefaceUtils.getTypeface(chart, propMap));
        }
    }

    @ReactProp(name = "centerTextRadiusPercent")
    public void setCenterTextRadiusPercent(PieChart chart, float radiusPercent) {
        chart.setCenterTextRadiusPercent(radiusPercent);
    }

    @ReactProp(name = "holeRadius")
    public void setHoleRadius(PieChart chart, float percent) {
        chart.setHoleRadius(percent);
    }

    @ReactProp(name = "holeColor")
    public void setHoleColor(PieChart chart, Integer color) {
        chart.setHoleColor(color);
    }

    @ReactProp(name = "transparentCircleRadius")
    public void setTransparentCircleRadius(PieChart chart, float percent) {
        chart.setTransparentCircleRadius(percent);
    }

    @ReactProp(name = "transparentCircleColor")
    public void setTransparentCircleColor(PieChart chart, Integer color) {
        chart.setTransparentCircleColor(color);
    }

    @ReactProp(name = "entryLabelColor")
    public void setEntryLabelColor(PieChart chart, Integer color) {
        chart.setEntryLabelColor(color);
    }

    @ReactProp(name = "entryLabelTextSize")
    public void setEntryLabelTextSize(PieChart chart, float size) {
        chart.setEntryLabelTextSize(size);
    }

    @ReactProp(name = "entryLabelFontFamily")
    public void setEntryLabelFontFamily(PieChart chart, String fontFamily) {
        chart.setEntryLabelTypeface(TypefaceUtils.getTypeface(chart, fontFamily));
    }

    @ReactProp(name = "maxAngle")
    public void setMaxAngle(PieChart chart, float maxAngle) {
        chart.setMaxAngle(maxAngle);
    }

    @ReactProp(name = "rotationEnabled")
    public void setRotationEnabled(PieChart chart, boolean enabled) {
        chart.setRotationEnabled(enabled);
    }

    @ReactProp(name = "rotationAngle")
    public void setRotationAngle(PieChart chart, float angle) {
        chart.setRotationAngle(angle);
    }


}
