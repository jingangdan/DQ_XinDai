package com.dq.xindai.bean;

/**
 * 用户基础信息实体类
 * Created by jingang on 2018/12/25.
 */

public class RemData extends ResultBase {

    /**
     * data : {"id":1025,"token":"a807dde735069514fa6eb9a0c25a4ff1","device_id":null,"uid":25,"user_name":"刘永达","os":null,"date_lastactivity":1545874336,"model":null,"balance":0,"dep_status":2,"total":0,"invest":0,"styles":1,"mobile":"15969958979","custody":{"true_name":"刘*达","mobile":"159****8979","idcard":"3713121990****5757","email":"159*****@qq.com","custody":"11039171********43","account":"10390009********","bank_card":"6212************7471","bank_mobile":"159****8979"}}
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
         * id : 1025
         * token : a807dde735069514fa6eb9a0c25a4ff1
         * device_id : null
         * uid : 25
         * user_name : 刘永达
         * os : null
         * date_lastactivity : 1545874336
         * model : null
         * balance : 0
         * dep_status : 2
         * total : 0
         * invest : 0
         * styles : 1
         * mobile : 15969958979
         * custody : {"true_name":"刘*达","mobile":"159****8979","idcard":"3713121990****5757","email":"159*****@qq.com","custody":"11039171********43","account":"10390009********","bank_card":"6212************7471","bank_mobile":"159****8979"}
         */

        private int id;
        private String token;
        private Object device_id;
        private int uid;
        private String user_name;
        private Object os;
        private int date_lastactivity;
        private Object model;
        private double balance;
        private int dep_status;
        private double total;
        private int invest;
        private int styles;
        private String mobile;
        private CustodyBean custody;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public Object getDevice_id() {
            return device_id;
        }

        public void setDevice_id(Object device_id) {
            this.device_id = device_id;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public Object getOs() {
            return os;
        }

        public void setOs(Object os) {
            this.os = os;
        }

        public int getDate_lastactivity() {
            return date_lastactivity;
        }

        public void setDate_lastactivity(int date_lastactivity) {
            this.date_lastactivity = date_lastactivity;
        }

        public Object getModel() {
            return model;
        }

        public void setModel(Object model) {
            this.model = model;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public int getDep_status() {
            return dep_status;
        }

        public void setDep_status(int dep_status) {
            this.dep_status = dep_status;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }

        public int getInvest() {
            return invest;
        }

        public void setInvest(int invest) {
            this.invest = invest;
        }

        public int getStyles() {
            return styles;
        }

        public void setStyles(int styles) {
            this.styles = styles;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public CustodyBean getCustody() {
            return custody;
        }

        public void setCustody(CustodyBean custody) {
            this.custody = custody;
        }

        public static class CustodyBean {
            /**
             * true_name : 刘*达
             * mobile : 159****8979
             * idcard : 3713121990****5757
             * email : 159*****@qq.com
             * custody : 11039171********43
             * account : 10390009********
             * bank_card : 6212************7471
             * bank_mobile : 159****8979
             */

            private String true_name;
            private String mobile;
            private String idcard;
            private String email;
            private String custody;
            private String account;
            private String bank_card;
            private String bank_mobile;

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

            public String getCustody() {
                return custody;
            }

            public void setCustody(String custody) {
                this.custody = custody;
            }

            public String getAccount() {
                return account;
            }

            public void setAccount(String account) {
                this.account = account;
            }

            public String getBank_card() {
                return bank_card;
            }

            public void setBank_card(String bank_card) {
                this.bank_card = bank_card;
            }

            public String getBank_mobile() {
                return bank_mobile;
            }

            public void setBank_mobile(String bank_mobile) {
                this.bank_mobile = bank_mobile;
            }
        }
    }
}
