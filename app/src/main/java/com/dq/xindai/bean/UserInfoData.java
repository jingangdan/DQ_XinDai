package com.dq.xindai.bean;

/**
 * 登录返回实体类
 * Created by jingang on 2018/12/22.
 */

public class UserInfoData extends ResultBase {
    /**
     * data : {"uid":456,"user_name":"赵金刚","token":"cfcd208495d565ef66e7dff9f98764da","balance":0,"dep_status":2,"total":0,"invest":0,"styles":1,"mobile":"17865069350","custody":{"true_name":"赵*刚","mobile":"178****9350","idcard":"3713241992****3518","email":"","custody":"11039180********12","account":"10390089********","bank_card":"************","bank_mobile":""}}
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
         * uid : 456
         * user_name : 赵金刚
         * token : cfcd208495d565ef66e7dff9f98764da
         * balance : 0
         * dep_status : 2
         * total : 0
         * invest : 0
         * styles : 1
         * mobile : 17865069350
         * custody : {"true_name":"赵*刚","mobile":"178****9350","idcard":"3713241992****3518","email":"","custody":"11039180********12","account":"10390089********","bank_card":"************","bank_mobile":""}
         */

        private int uid;
        private String user_name;
        private String token;
        private double balance;
        private int dep_status;
        private double total;
        private int invest;
        private int styles;
        private String mobile;
        private CustodyBean custody;

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

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
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
             * true_name : 赵*刚
             * mobile : 178****9350
             * idcard : 3713241992****3518
             * email :
             * custody : 11039180********12
             * account : 10390089********
             * bank_card : ************
             * bank_mobile :
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


//    private DataBean dataBean;
//
//    public DataBean getDataBean() {
//        return dataBean;
//    }
//
//    public void setDataBean(DataBean dataBean) {
//        this.dataBean = dataBean;
//    }
//
//    public static class DataBean {
//        /**
//         * uid : 456
//         * user_name : 赵金刚
//         * token : 1679091c5a880faf6fb5e6087eb1b2dc
//         * balance : 0
//         * dep_status : 2
//         * total : 0
//         * invest : 0
//         * styles : 1
//         * mobile : 17865069350
//         * custody : {"true_name":"赵*刚","mobile":"178****9350","idcard":"3713241992****3518","email":"","custody":"11039180********12","account":"10390089********","bank_card":"************","bank_mobile":""}
//         */
//
//        private String uid;
//        private String user_name;
//        private String token;
//        private int balance;
//        private int dep_status;
//        private int total;
//        private int invest;
//        private int styles;
//        private String mobile;
//        private CustodyBean custody;
//
//        public String getUid() {
//            return uid;
//        }
//
//        public void setUid(String uid) {
//            this.uid = uid;
//        }
//
//        public String getUser_name() {
//            return user_name;
//        }
//
//        public void setUser_name(String user_name) {
//            this.user_name = user_name;
//        }
//
//        public String getToken() {
//            return token;
//        }
//
//        public void setToken(String token) {
//            this.token = token;
//        }
//
//        public int getBalance() {
//            return balance;
//        }
//
//        public void setBalance(int balance) {
//            this.balance = balance;
//        }
//
//        public int getDep_status() {
//            return dep_status;
//        }
//
//        public void setDep_status(int dep_status) {
//            this.dep_status = dep_status;
//        }
//
//        public int getTotal() {
//            return total;
//        }
//
//        public void setTotal(int total) {
//            this.total = total;
//        }
//
//        public int getInvest() {
//            return invest;
//        }
//
//        public void setInvest(int invest) {
//            this.invest = invest;
//        }
//
//        public int getStyles() {
//            return styles;
//        }
//
//        public void setStyles(int styles) {
//            this.styles = styles;
//        }
//
//        public String getMobile() {
//            return mobile;
//        }
//
//        public void setMobile(String mobile) {
//            this.mobile = mobile;
//        }
//
//        public CustodyBean getCustody() {
//            return custody;
//        }
//
//        public void setCustody(CustodyBean custody) {
//            this.custody = custody;
//        }
//
//        public static class CustodyBean {
//            /**
//             * true_name : 赵*刚
//             * mobile : 178****9350
//             * idcard : 3713241992****3518
//             * email :
//             * custody : 11039180********12
//             * account : 10390089********
//             * bank_card : ************
//             * bank_mobile :
//             */
//
//            private String true_name;
//            private String mobile;
//            private String idcard;
//            private String email;
//            private String custody;
//            private String account;
//            private String bank_card;
//            private String bank_mobile;
//
//            public String getTrue_name() {
//                return true_name;
//            }
//
//            public void setTrue_name(String true_name) {
//                this.true_name = true_name;
//            }
//
//            public String getMobile() {
//                return mobile;
//            }
//
//            public void setMobile(String mobile) {
//                this.mobile = mobile;
//            }
//
//            public String getIdcard() {
//                return idcard;
//            }
//
//            public void setIdcard(String idcard) {
//                this.idcard = idcard;
//            }
//
//            public String getEmail() {
//                return email;
//            }
//
//            public void setEmail(String email) {
//                this.email = email;
//            }
//
//            public String getCustody() {
//                return custody;
//            }
//
//            public void setCustody(String custody) {
//                this.custody = custody;
//            }
//
//            public String getAccount() {
//                return account;
//            }
//
//            public void setAccount(String account) {
//                this.account = account;
//            }
//
//            public String getBank_card() {
//                return bank_card;
//            }
//
//            public void setBank_card(String bank_card) {
//                this.bank_card = bank_card;
//            }
//
//            public String getBank_mobile() {
//                return bank_mobile;
//            }
//
//            public void setBank_mobile(String bank_mobile) {
//                this.bank_mobile = bank_mobile;
//            }
//
//            @Override
//            public String toString() {
//                return "CustodyBean{" +
//                        "true_name='" + true_name + '\'' +
//                        ", mobile='" + mobile + '\'' +
//                        ", idcard='" + idcard + '\'' +
//                        ", email='" + email + '\'' +
//                        ", custody='" + custody + '\'' +
//                        ", account='" + account + '\'' +
//                        ", bank_card='" + bank_card + '\'' +
//                        ", bank_mobile='" + bank_mobile + '\'' +
//                        '}';
//            }
//        }
//
//        @Override
//        public String toString() {
//            return "DataBean{" +
//                    "uid='" + uid + '\'' +
//                    ", user_name='" + user_name + '\'' +
//                    ", token='" + token + '\'' +
//                    ", balance=" + balance +
//                    ", dep_status=" + dep_status +
//                    ", total=" + total +
//                    ", invest=" + invest +
//                    ", styles=" + styles +
//                    ", mobile='" + mobile + '\'' +
//                    ", custody=" + custody +
//                    '}';
//        }
//    }
}
