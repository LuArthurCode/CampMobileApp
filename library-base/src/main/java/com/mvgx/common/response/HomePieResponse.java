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
     * sequence : 1
     * type : orderAsset
     * title : Asset Under Management
     * value : {"total":3.01401458553E9,"list":[{"name":"LNK","value":1.0467834376E8},{"name":"CNT","value":0},{"name":"CNV","value":0},{"name":"ALW","value":0},{"name":"NS1","value":0},{"name":"THB","value":0},{"name":"AUD","value":0},{"name":"JPY","value":0},{"name":"TS1","value":0},{"name":"GBP","value":0},{"name":"IDR","value":0},{"name":"NBS","value":0},{"name":"MBT","value":0},{"name":"HKD","value":0},{"name":"EUR","value":2.637660123E7},{"name":"USDC","value":1.200368187E7},{"name":"TBS","value":0},{"name":"HR1","value":0},{"name":"USD","value":2.394549977E7},{"name":"CAD","value":0},{"name":"NOK","value":0},{"name":"BTC","value":3.5684161381E8},{"name":"SGD","value":1.878956387E7},{"name":"USDT","value":2.46415442995E9},{"name":"SEK","value":0},{"name":"ETH","value":7224851.27},{"name":"NZD","value":0},{"name":"CNH","value":0}]}
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
         * total : 3.01401458553E9
         * list : [{"name":"LNK","value":1.0467834376E8},{"name":"CNT","value":0},{"name":"CNV","value":0},{"name":"ALW","value":0},{"name":"NS1","value":0},{"name":"THB","value":0},{"name":"AUD","value":0},{"name":"JPY","value":0},{"name":"TS1","value":0},{"name":"GBP","value":0},{"name":"IDR","value":0},{"name":"NBS","value":0},{"name":"MBT","value":0},{"name":"HKD","value":0},{"name":"EUR","value":2.637660123E7},{"name":"USDC","value":1.200368187E7},{"name":"TBS","value":0},{"name":"HR1","value":0},{"name":"USD","value":2.394549977E7},{"name":"CAD","value":0},{"name":"NOK","value":0},{"name":"BTC","value":3.5684161381E8},{"name":"SGD","value":1.878956387E7},{"name":"USDT","value":2.46415442995E9},{"name":"SEK","value":0},{"name":"ETH","value":7224851.27},{"name":"NZD","value":0},{"name":"CNH","value":0}]
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
             * name : LNK
             * value : 1.0467834376E8
             */

            private String name;

            private double value;

            public String getName() {
                return name == null ? "" : name;
            }

            public void setName(String name) {
                this.name = name == null ? "" : name;
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
