package com.mvgx.home.ui.fragment;

import java.io.Serializable;

/**
 * @Author Arthur
 * @Date 2023/03/31 15:35
 */
public class HomeGraphEntity implements Serializable {


    /**
     * date : 2023-02-27
     * type : USD
     * value : 1.0008
     */

    private String date;
    private String type;
    private double value;

    public String getDate() {
        return date == null ? "" : date;
    }

    public void setDate(String date) {
        this.date = date == null ? "" : date;
    }

    public String getType() {
        return type == null ? "" : type;
    }

    public void setType(String type) {
        this.type = type == null ? "" : type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
