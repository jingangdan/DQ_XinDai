package com.dq.xindai.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 首页实体类
 * Created by jingang on 2018/12/31.
 */

public class IndexData extends ResultBase {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 129
         * serial : JK-20181218-0001
         * title : 第JK-20181218-0001号借款
         * term : 9
         * rate : 9
         * purpose : 装修房屋、购买家电
         * status : 6
         * money : 40000
         * repayment_name : 等额本息
         * load_money : 40000
         * term_type : 0
         * progress : 100
         * vote_money : 0
         */

        private int id;
        private String serial;
        private String title;
        private int term;
        private int rate;
        private String purpose;
        @SerializedName("status")
        private int statusX;
        private int money;
        private String repayment_name;
        private int load_money;
        private int term_type;
        private int progress;
        private int vote_money;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSerial() {
            return serial;
        }

        public void setSerial(String serial) {
            this.serial = serial;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getTerm() {
            return term;
        }

        public void setTerm(int term) {
            this.term = term;
        }

        public int getRate() {
            return rate;
        }

        public void setRate(int rate) {
            this.rate = rate;
        }

        public String getPurpose() {
            return purpose;
        }

        public void setPurpose(String purpose) {
            this.purpose = purpose;
        }

        public int getStatusX() {
            return statusX;
        }

        public void setStatusX(int statusX) {
            this.statusX = statusX;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public String getRepayment_name() {
            return repayment_name;
        }

        public void setRepayment_name(String repayment_name) {
            this.repayment_name = repayment_name;
        }

        public int getLoad_money() {
            return load_money;
        }

        public void setLoad_money(int load_money) {
            this.load_money = load_money;
        }

        public int getTerm_type() {
            return term_type;
        }

        public void setTerm_type(int term_type) {
            this.term_type = term_type;
        }

        public int getProgress() {
            return progress;
        }

        public void setProgress(int progress) {
            this.progress = progress;
        }

        public int getVote_money() {
            return vote_money;
        }

        public void setVote_money(int vote_money) {
            this.vote_money = vote_money;
        }
    }
}
