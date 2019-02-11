package com.dq.xindai.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 交易查询实体类
 * Created by jingang on 2018/12/27.
 */

public class SearchIndexData extends ResultBase {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 94
         * serial : TZ-20180517-000001
         * borrow_id : 110
         * money : 10000
         * date_created : 1526546425
         * status : 0
         * borrow : {"title":"第JK-20180515-0001号借款","rate":11,"term":18,"term_type":0,"repayment_name":"等额本息","is_revoke":0,"repay_next_time":1544976029}
         * category_name : 精英贷
         * is_aency : 0
         * borrow_moeny : 10893.34
         */

        private int id;
        private String serial;
        private int borrow_id;
        private int money;
        private int date_created;
        @SerializedName("status")
        private int statusX;
        private BorrowBean borrow;
        private String category_name;
        private int is_aency;
        private double borrow_moeny;

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

        public int getBorrow_id() {
            return borrow_id;
        }

        public void setBorrow_id(int borrow_id) {
            this.borrow_id = borrow_id;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public int getDate_created() {
            return date_created;
        }

        public void setDate_created(int date_created) {
            this.date_created = date_created;
        }

        public int getStatusX() {
            return statusX;
        }

        public void setStatusX(int statusX) {
            this.statusX = statusX;
        }

        public BorrowBean getBorrow() {
            return borrow;
        }

        public void setBorrow(BorrowBean borrow) {
            this.borrow = borrow;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public int getIs_aency() {
            return is_aency;
        }

        public void setIs_aency(int is_aency) {
            this.is_aency = is_aency;
        }

        public double getBorrow_moeny() {
            return borrow_moeny;
        }

        public void setBorrow_moeny(double borrow_moeny) {
            this.borrow_moeny = borrow_moeny;
        }

        public static class BorrowBean {
            /**
             * title : 第JK-20180515-0001号借款
             * rate : 11
             * term : 18
             * term_type : 0
             * repayment_name : 等额本息
             * is_revoke : 0
             * repay_next_time : 1544976029
             */

            private String title;
            private int rate;
            private int term;
            private int term_type;
            private String repayment_name;
            private int is_revoke;
            private int repay_next_time;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getRate() {
                return rate;
            }

            public void setRate(int rate) {
                this.rate = rate;
            }

            public int getTerm() {
                return term;
            }

            public void setTerm(int term) {
                this.term = term;
            }

            public int getTerm_type() {
                return term_type;
            }

            public void setTerm_type(int term_type) {
                this.term_type = term_type;
            }

            public String getRepayment_name() {
                return repayment_name;
            }

            public void setRepayment_name(String repayment_name) {
                this.repayment_name = repayment_name;
            }

            public int getIs_revoke() {
                return is_revoke;
            }

            public void setIs_revoke(int is_revoke) {
                this.is_revoke = is_revoke;
            }

            public int getRepay_next_time() {
                return repay_next_time;
            }

            public void setRepay_next_time(int repay_next_time) {
                this.repay_next_time = repay_next_time;
            }
        }
    }
}
