package com.mvgx.common.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Arthur
 * @Date 2023/3/29 10:20
 */
public class HomePieResponse implements Serializable {


    /**
     * sequence : 1
     * type : orderAsset
     * title : Asset Under Management
     * value : {"total":998949.91,"list":[{"name":"BTC","value":0},{"name":"SGD","value":0},{"name":"EUR","value":0},{"name":"USDC","value":0},{"name":"EQP","value":0},{"name":"HR1","value":0},{"name":"USDT","value":200020},{"name":"USD","value":798929.91},{"name":"LNK","value":0},{"name":"ETH","value":0},{"name":"CNT","value":0},{"name":"CNV","value":0},{"name":"MBT","value":0}]}
     */

    private int sequence;
    private String type;
    private String title;
    private ValueBean value;

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

    public ValueBean getValue() {
        return value;
    }

    public void setValue(ValueBean value) {
        this.value = value;
    }

    public static class ValueBean implements Serializable {
        /**
         * total : 998949.91
         * list : [{"name":"BTC","value":0},{"name":"SGD","value":0},{"name":"EUR","value":0},{"name":"USDC","value":0},{"name":"EQP","value":0},{"name":"HR1","value":0},{"name":"USDT","value":200020},{"name":"USD","value":798929.91},{"name":"LNK","value":0},{"name":"ETH","value":0},{"name":"CNT","value":0},{"name":"CNV","value":0},{"name":"MBT","value":0}]
         */

        private double total;
        private List<ListBean> list;


        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }

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
             * name : BTC
             * value : 0
             */
            private String name;
            @SerializedName("value")
            private Object childValue;


            public String getName() {
                return name == null ? "" : name;
            }

            public void setName(String name) {
                this.name = name == null ? "" : name;
            }

            public Object getChildValue() {
                return childValue;
            }

            public void setChildValue(Object childValue) {
                this.childValue = childValue;
            }
        }
    }
}
