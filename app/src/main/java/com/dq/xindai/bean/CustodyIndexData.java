package com.dq.xindai.bean;

import java.util.List;

/**
 * 我的存管信息实体类
 * Created by jingng on 2019/1/12.
 */

public class CustodyIndexData extends ResultBase{


    /**
     * data : {"custody":{"company":0,"true_name":"周涛","mobile":"15318800555","idcard":"370124197401010018","email":"","custody_id":"110391811290136647","account_id":"1039013664701","dep_type":0,"bank_card":"4340*********002","dep_bank_name":"中国建设银行","dep_bank_mobile":"153****0555"},"qianyue":[{"id":68,"member_id":478,"loan_amount":1000000,"loan_date":1862582400,"repay_amount":1000000,"repay_date":1862582400,"qianyue_status":1,"create_time":1547012945}]}
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
         * custody : {"company":0,"true_name":"周涛","mobile":"15318800555","idcard":"370124197401010018","email":"","custody_id":"110391811290136647","account_id":"1039013664701","dep_type":0,"bank_card":"4340*********002","dep_bank_name":"中国建设银行","dep_bank_mobile":"153****0555"}
         * qianyue : [{"id":68,"member_id":478,"loan_amount":1000000,"loan_date":1862582400,"repay_amount":1000000,"repay_date":1862582400,"qianyue_status":1,"create_time":1547012945}]
         */

        private CustodyBean custody;
        private List<QianyueBean> qianyue;

        public CustodyBean getCustody() {
            return custody;
        }

        public void setCustody(CustodyBean custody) {
            this.custody = custody;
        }

        public List<QianyueBean> getQianyue() {
            return qianyue;
        }

        public void setQianyue(List<QianyueBean> qianyue) {
            this.qianyue = qianyue;
        }

        public static class CustodyBean {
            /**
             * company : 0
             * true_name : 周涛
             * mobile : 15318800555
             * idcard : 370124197401010018
             * email :
             * custody_id : 110391811290136647
             * account_id : 1039013664701
             * dep_type : 0
             * bank_card : 4340*********002
             * dep_bank_name : 中国建设银行
             * dep_bank_mobile : 153****0555
             */

            private int company;
            private String true_name;
            private String mobile;
            private String idcard;
            private String email;
            private String custody_id;
            private String account_id;
            private int dep_type;
            private String bank_card;
            private String dep_bank_name;
            private String dep_bank_mobile;

            public int getCompany() {
                return company;
            }

            public void setCompany(int company) {
                this.company = company;
            }

            public String getTrue_name() {
                return true_name;
            }

            public void setTrue_name(String true_name) {
                this.true_name = true_name;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getIdcard() {
                return idcard;
            }

            public void setIdcard(String idcard) {
                this.idcard = idcard;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getCustody_id() {
                return custody_id;
            }

            public void setCustody_id(String custody_id) {
                this.custody_id = custody_id;
            }

            public String getAccount_id() {
                return account_id;
            }

            public void setAccount_id(String account_id) {
                this.account_id = account_id;
            }

            public int getDep_type() {
                return dep_type;
            }

            public void setDep_type(int dep_type) {
                this.dep_type = dep_type;
            }

            public String getBank_card() {
                return bank_card;
            }

            public void setBank_card(String bank_card) {
                this.bank_card = bank_card;
            }

            public String getDep_bank_name() {
                return dep_bank_name;
            }

            public void setDep_bank_name(String dep_bank_name) {
                this.dep_bank_name = dep_bank_name;
            }

            public String getDep_bank_mobile() {
                return dep_bank_mobile;
            }

            public void setDep_bank_mobile(String dep_bank_mobile) {
                this.dep_bank_mobile = dep_bank_mobile;
            }
        }

        public static class QianyueBean {
            /**
             * id : 68
             * member_id : 478
             * loan_amount : 1000000
             * loan_date : 1862582400
             * repay_amount : 1000000
             * repay_date : 1862582400
             * qianyue_status : 1
             * create_time : 1547012945
             */

            private int id;
            private int member_id;
            private double loan_amount;
            private int loan_date;
            private double repay_amount;
            private int repay_date;
            private int qianyue_status;
            private int create_time;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getMember_id() {
                return member_id;
            }

            public void setMember_id(int member_id) {
                this.member_id = member_id;
            }

            public double getLoan_amount() {
                return loan_amount;
            }

            public void setLoan_amount(double loan_amount) {
                this.loan_amount = loan_amount;
            }

            public int getLoan_date() {
                return loan_date;
            }

            public void setLoan_date(int loan_date) {
                this.loan_date = loan_date;
            }

            public double getRepay_amount() {
                return repay_amount;
            }

            public void setRepay_amount(double repay_amount) {
                this.repay_amount = repay_amount;
            }

            public int getRepay_date() {
                return repay_date;
            }

            public void setRepay_date(int repay_date) {
                this.repay_date = repay_date;
            }

            public int getQianyue_status() {
                return qianyue_status;
            }

            public void setQianyue_status(int qianyue_status) {
                this.qianyue_status = qianyue_status;
            }

            public int getCreate_time() {
                return create_time;
            }

            public void setCreate_time(int create_time) {
                this.create_time = create_time;
            }
        }
    }
}
