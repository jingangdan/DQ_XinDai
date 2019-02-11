package com.dq.xindai.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 充值记录、提现记录实体类
 * Created by jingang on 2018/12/29.
 */

public class RecordData extends ResultBase{


    /**
     * data : {"page":1,"pagesize":10,"list":[{"id":1139,"serial":"WGCZ-20180904-00061","status":0,"money":"123","free":0,"remarks":"账户充值,WGCZ-20180904-00061","date_created":1536023600,"date_complete":0},{"id":708,"serial":"WGCZ-20180601-00034","status":0,"money":"103","free":0,"remarks":"账户充值,WGCZ-20180601-00034","date_created":1527844285,"date_complete":0},{"id":557,"serial":"CZ-20180509-00187","status":1,"money":"50000","free":0,"remarks":"账户充值,CZ-20180509-00187","date_created":1525852673,"date_complete":1525852673},{"id":471,"serial":"CZ-20180420-00148","status":1,"money":"20000","free":0,"remarks":"账户充值,CZ-20180420-00148","date_created":1524214496,"date_complete":1524214496},{"id":470,"serial":"CZ-20180420-00147","status":1,"money":"50000","free":0,"remarks":"账户充值,CZ-20180420-00147","date_created":1524214463,"date_complete":1524214463},{"id":383,"serial":"WGCZ-20180329-00010","status":0,"money":"100","free":0,"remarks":"账户充值,WGCZ-20180329-00010","date_created":1522290402,"date_complete":0},{"id":345,"serial":"CZ-20180321-00071","status":1,"money":"50000","free":0,"remarks":"账户充值,CZ-20180321-00071","date_created":1521623824,"date_complete":1521623824},{"id":344,"serial":"CZ-20180321-00070","status":1,"money":"50000","free":0,"remarks":"账户充值,CZ-20180321-00070","date_created":1521623790,"date_complete":1521623790},{"id":343,"serial":"CZ-20180321-00068","status":1,"money":"50000","free":0,"remarks":"账户充值,CZ-20180321-00068","date_created":1521623752,"date_complete":1521623752},{"id":229,"serial":"CZ-20171218-0000038","status":1,"money":"159.4","free":0,"remarks":"账户充值,CZ-20171218-0000038","date_created":1513580450,"date_complete":1513580450}]}
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
         * page : 1
         * pagesize : 10
         * list : [{"id":1139,"serial":"WGCZ-20180904-00061","status":0,"money":"123","free":0,"remarks":"账户充值,WGCZ-20180904-00061","date_created":1536023600,"date_complete":0},{"id":708,"serial":"WGCZ-20180601-00034","status":0,"money":"103","free":0,"remarks":"账户充值,WGCZ-20180601-00034","date_created":1527844285,"date_complete":0},{"id":557,"serial":"CZ-20180509-00187","status":1,"money":"50000","free":0,"remarks":"账户充值,CZ-20180509-00187","date_created":1525852673,"date_complete":1525852673},{"id":471,"serial":"CZ-20180420-00148","status":1,"money":"20000","free":0,"remarks":"账户充值,CZ-20180420-00148","date_created":1524214496,"date_complete":1524214496},{"id":470,"serial":"CZ-20180420-00147","status":1,"money":"50000","free":0,"remarks":"账户充值,CZ-20180420-00147","date_created":1524214463,"date_complete":1524214463},{"id":383,"serial":"WGCZ-20180329-00010","status":0,"money":"100","free":0,"remarks":"账户充值,WGCZ-20180329-00010","date_created":1522290402,"date_complete":0},{"id":345,"serial":"CZ-20180321-00071","status":1,"money":"50000","free":0,"remarks":"账户充值,CZ-20180321-00071","date_created":1521623824,"date_complete":1521623824},{"id":344,"serial":"CZ-20180321-00070","status":1,"money":"50000","free":0,"remarks":"账户充值,CZ-20180321-00070","date_created":1521623790,"date_complete":1521623790},{"id":343,"serial":"CZ-20180321-00068","status":1,"money":"50000","free":0,"remarks":"账户充值,CZ-20180321-00068","date_created":1521623752,"date_complete":1521623752},{"id":229,"serial":"CZ-20171218-0000038","status":1,"money":"159.4","free":0,"remarks":"账户充值,CZ-20171218-0000038","date_created":1513580450,"date_complete":1513580450}]
         */

        private int page;
        private int pagesize;
        private List<ListBean> list;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPagesize() {
            return pagesize;
        }

        public void setPagesize(int pagesize) {
            this.pagesize = pagesize;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 1139
             * serial : WGCZ-20180904-00061
             * status : 0
             * money : 123
             * free : 0
             * remarks : 账户充值,WGCZ-20180904-00061
             * date_created : 1536023600
             * date_complete : 0
             */

            private int id;
            private String serial;
            @SerializedName("status")
            private int statusX;
            private String money;
            private int free;
            private String remarks;
            private int date_created;
            private int date_complete;

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

            public int getStatusX() {
                return statusX;
            }

            public void setStatusX(int statusX) {
                this.statusX = statusX;
            }

            public String getMoney() {
                return money;
            }

            public void setMoney(String money) {
                this.money = money;
            }

            public int getFree() {
                return free;
            }

            public void setFree(int free) {
                this.free = free;
            }

            public String getRemarks() {
                return remarks;
            }

            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }

            public int getDate_created() {
                return date_created;
            }

            public void setDate_created(int date_created) {
                this.date_created = date_created;
            }

            public int getDate_complete() {
                return date_complete;
            }

            public void setDate_complete(int date_complete) {
                this.date_complete = date_complete;
            }
        }
    }
}
