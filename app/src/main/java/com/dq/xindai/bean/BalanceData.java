package com.dq.xindai.bean;

/**
 * 可用余额实体类
 * Created by jingang on 2019/1/5.
 */

public class BalanceData extends ResultBase {

    /**
     * data : {"balance":0}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * balance : 0
         */

        private double balance;

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }
    }
}
