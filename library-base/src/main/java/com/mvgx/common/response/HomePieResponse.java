package com.mvgx.common.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Arthur
 * @Date 2023/3/29 10:20
 */
public class HomePieResponse implements Serializable {


    /**
     * sequence : 99
     * type : cryptoRate
     * title : Market
     * value : {"list":[{"name":"USDT","value":[{"date":"2023-02-27","type":"USD","value":1.0008},{"date":"2023-02-28","type":"USD","value":1.0006},{"date":"2023-03-01","type":"USD","value":1.0009},{"date":"2023-03-02","type":"USD","value":1.0008},{"date":"2023-03-03","type":"USD","value":1.0008},{"date":"2023-03-04","type":"USD","value":1.0009},{"date":"2023-03-05","type":"USD","value":1.001},{"date":"2023-03-06","type":"USD","value":1.0005},{"date":"2023-03-07","type":"USD","value":1.0006},{"date":"2023-03-08","type":"USD","value":1.0006},{"date":"2023-03-09","type":"USD","value":1.0005},{"date":"2023-03-10","type":"USD","value":1.0002},{"date":"2023-03-11","type":"USD","value":1.0007},{"date":"2023-03-14","type":"USD","value":1.0055},{"date":"2023-03-15","type":"USD","value":1.0057},{"date":"2023-03-16","type":"USD","value":1.004},{"date":"2023-03-17","type":"USD","value":1.0034},{"date":"2023-03-18","type":"USD","value":1.0028},{"date":"2023-03-19","type":"USD","value":1.0044},{"date":"2023-03-20","type":"USD","value":1.0046},{"date":"2023-03-21","type":"USD","value":1.0042},{"date":"2023-03-22","type":"USD","value":1.0025},{"date":"2023-03-23","type":"USD","value":1.0033},{"date":"2023-03-24","type":"USD","value":1.0037},{"date":"2023-03-25","type":"USD","value":1.0024},{"date":"2023-03-26","type":"USD","value":1.0026},{"date":"2023-03-27","type":"USD","value":1.0025},{"date":"2023-03-28","type":"USD","value":1.0018},{"date":"2023-03-29","type":"USD","value":1.0017}]},{"name":"USDC","value":[{"date":"2023-02-27","type":"USD","value":1.0001},{"date":"2023-02-28","type":"USD","value":1.0001},{"date":"2023-03-01","type":"USD","value":1.0001},{"date":"2023-03-02","type":"USD","value":1.0001},{"date":"2023-03-03","type":"USD","value":1.0001},{"date":"2023-03-04","type":"USD","value":1.0001},{"date":"2023-03-05","type":"USD","value":1.0001},{"date":"2023-03-06","type":"USD","value":1.0001},{"date":"2023-03-07","type":"USD","value":1.0001},{"date":"2023-03-08","type":"USD","value":1.0001},{"date":"2023-03-09","type":"USD","value":1.0001},{"date":"2023-03-10","type":"USD","value":1.0001},{"date":"2023-03-11","type":"USD","value":1.0001},{"date":"2023-03-14","type":"USD","value":0},{"date":"2023-03-15","type":"USD","value":0},{"date":"2023-03-16","type":"USD","value":0},{"date":"2023-03-17","type":"USD","value":0},{"date":"2023-03-18","type":"USD","value":0},{"date":"2023-03-19","type":"USD","value":0},{"date":"2023-03-20","type":"USD","value":0},{"date":"2023-03-21","type":"USD","value":0},{"date":"2023-03-22","type":"USD","value":0},{"date":"2023-03-23","type":"USD","value":0},{"date":"2023-03-24","type":"USD","value":0},{"date":"2023-03-25","type":"USD","value":0},{"date":"2023-03-26","type":"USD","value":1.000073},{"date":"2023-03-27","type":"USD","value":1.000042},{"date":"2023-03-28","type":"USD","value":0},{"date":"2023-03-29","type":"USD","value":0}]}]}
     */

    private int sequence;
    private String type;
    private String title;
    private ValueBeanX value;


    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getType() {
        return type == null ? "" : type;
    }

    public void setType(String type) {
        this.type = type == null ? "" : type;
    }

    public String getTitle() {
        return title == null ? "" : title;
    }

    public void setTitle(String title) {
        this.title = title == null ? "" : title;
    }

    public ValueBeanX getValue() {
        return value;
    }

    public void setValue(ValueBeanX value) {
        this.value = value;
    }

    public static class ValueBeanX implements Serializable {
        private List<ListBean> list;

        public List<ListBean> getList() {
            if (list == null) {
                return new ArrayList<>();
            }
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean implements Serializable {
            /**
             * name : USDT
             * value : [{"date":"2023-02-27","type":"USD","value":1.0008},{"date":"2023-02-28","type":"USD","value":1.0006},{"date":"2023-03-01","type":"USD","value":1.0009},{"date":"2023-03-02","type":"USD","value":1.0008},{"date":"2023-03-03","type":"USD","value":1.0008},{"date":"2023-03-04","type":"USD","value":1.0009},{"date":"2023-03-05","type":"USD","value":1.001},{"date":"2023-03-06","type":"USD","value":1.0005},{"date":"2023-03-07","type":"USD","value":1.0006},{"date":"2023-03-08","type":"USD","value":1.0006},{"date":"2023-03-09","type":"USD","value":1.0005},{"date":"2023-03-10","type":"USD","value":1.0002},{"date":"2023-03-11","type":"USD","value":1.0007},{"date":"2023-03-14","type":"USD","value":1.0055},{"date":"2023-03-15","type":"USD","value":1.0057},{"date":"2023-03-16","type":"USD","value":1.004},{"date":"2023-03-17","type":"USD","value":1.0034},{"date":"2023-03-18","type":"USD","value":1.0028},{"date":"2023-03-19","type":"USD","value":1.0044},{"date":"2023-03-20","type":"USD","value":1.0046},{"date":"2023-03-21","type":"USD","value":1.0042},{"date":"2023-03-22","type":"USD","value":1.0025},{"date":"2023-03-23","type":"USD","value":1.0033},{"date":"2023-03-24","type":"USD","value":1.0037},{"date":"2023-03-25","type":"USD","value":1.0024},{"date":"2023-03-26","type":"USD","value":1.0026},{"date":"2023-03-27","type":"USD","value":1.0025},{"date":"2023-03-28","type":"USD","value":1.0018},{"date":"2023-03-29","type":"USD","value":1.0017}]
             */

            private String name;
            private List<ValueBean> value;

            public String getName() {
                return name == null ? "" : name;
            }

            public void setName(String name) {
                this.name = name == null ? "" : name;
            }

            public List<ValueBean> getValue() {
                if (value == null) {
                    return new ArrayList<>();
                }
                return value;
            }

            public void setValue(List<ValueBean> value) {
                this.value = value;
            }

            public static class ValueBean implements Serializable {
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
        }
    }
}
