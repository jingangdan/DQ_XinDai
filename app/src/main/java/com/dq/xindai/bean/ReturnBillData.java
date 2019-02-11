package com.dq.xindai.bean;

import java.util.List;

/**
 * 回款账单实体类
 * Created by jingang on 2018/12/27.
 */

public class ReturnBillData extends ResultBase {

    /**
     * status : 1
     * info : success
     * data : {"allcount":25,"page":1,"pagesize":10,"list":[{"serial":"HK-20181207-000015","member_id":25,"member_name":"刘永达","money":1018.77,"remarks":"借款【第JK-20180403-0002号借款】第【7】期偿还","date_created":1544144629,"date_complete":1544144629},{"serial":"HK-20181207-000010","member_id":25,"member_name":"刘永达","money":1018.77,"remarks":"借款【第JK-20180403-0002号借款】第【6】期偿还","date_created":1544144624,"date_complete":1544144624},{"serial":"HK-20181121-000002","member_id":25,"member_name":"刘永达","money":6812.6,"remarks":"借款【第JK-20180318-0001号借款】第【8】期偿还","date_created":1542766222,"date_complete":1542766222},{"serial":"HK-20181020-000002","member_id":25,"member_name":"刘永达","money":6812.6,"remarks":"借款【第JK-20180318-0001号借款】第【7】期偿还","date_created":1539998923,"date_complete":1539998923},{"serial":"HK-20181007-000003","member_id":25,"member_name":"刘永达","money":1018.77,"remarks":"借款【第JK-20180403-0002号借款】第【5】期偿还","date_created":1538872707,"date_complete":1538872707},{"serial":"HK-20180921-000002","member_id":25,"member_name":"刘永达","money":6812.6,"remarks":"借款【第JK-20180318-0001号借款】第【6】期偿还","date_created":1537497628,"date_complete":1537497628},{"serial":"HK-20180904-000043","member_id":25,"member_name":"刘永达","money":4894.8,"remarks":"借款【第JK-20180315-0002号借款】第【5】期偿还","date_created":1536049139,"date_complete":1536049139},{"serial":"HK-20180904-000026","member_id":25,"member_name":"刘永达","money":1018.77,"remarks":"借款【第JK-20180403-0002号借款】第【4】期偿还","date_created":1536048376,"date_complete":1536048376},{"serial":"HK-20180904-000015","member_id":25,"member_name":"刘永达","money":6812.6,"remarks":"借款【第JK-20180318-0001号借款】第【5】期偿还","date_created":1536048115,"date_complete":1536048115},{"serial":"HK-20180904-000001","member_id":25,"member_name":"刘永达","money":4236.3,"remarks":"借款【第JK-20180417-0001号借款】第【3】期偿还","date_created":1536024034,"date_complete":1536024034}]}
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
         * allcount : 25
         * page : 1
         * pagesize : 10
         * list : [{"serial":"HK-20181207-000015","member_id":25,"member_name":"刘永达","money":1018.77,"remarks":"借款【第JK-20180403-0002号借款】第【7】期偿还","date_created":1544144629,"date_complete":1544144629},{"serial":"HK-20181207-000010","member_id":25,"member_name":"刘永达","money":1018.77,"remarks":"借款【第JK-20180403-0002号借款】第【6】期偿还","date_created":1544144624,"date_complete":1544144624},{"serial":"HK-20181121-000002","member_id":25,"member_name":"刘永达","money":6812.6,"remarks":"借款【第JK-20180318-0001号借款】第【8】期偿还","date_created":1542766222,"date_complete":1542766222},{"serial":"HK-20181020-000002","member_id":25,"member_name":"刘永达","money":6812.6,"remarks":"借款【第JK-20180318-0001号借款】第【7】期偿还","date_created":1539998923,"date_complete":1539998923},{"serial":"HK-20181007-000003","member_id":25,"member_name":"刘永达","money":1018.77,"remarks":"借款【第JK-20180403-0002号借款】第【5】期偿还","date_created":1538872707,"date_complete":1538872707},{"serial":"HK-20180921-000002","member_id":25,"member_name":"刘永达","money":6812.6,"remarks":"借款【第JK-20180318-0001号借款】第【6】期偿还","date_created":1537497628,"date_complete":1537497628},{"serial":"HK-20180904-000043","member_id":25,"member_name":"刘永达","money":4894.8,"remarks":"借款【第JK-20180315-0002号借款】第【5】期偿还","date_created":1536049139,"date_complete":1536049139},{"serial":"HK-20180904-000026","member_id":25,"member_name":"刘永达","money":1018.77,"remarks":"借款【第JK-20180403-0002号借款】第【4】期偿还","date_created":1536048376,"date_complete":1536048376},{"serial":"HK-20180904-000015","member_id":25,"member_name":"刘永达","money":6812.6,"remarks":"借款【第JK-20180318-0001号借款】第【5】期偿还","date_created":1536048115,"date_complete":1536048115},{"serial":"HK-20180904-000001","member_id":25,"member_name":"刘永达","money":4236.3,"remarks":"借款【第JK-20180417-0001号借款】第【3】期偿还","date_created":1536024034,"date_complete":1536024034}]
         */

        private int allcount;
        private int page;
        private int pagesize;
        private List<ListBean> list;

        public int getAllcount() {
            return allcount;
        }

        public void setAllcount(int allcount) {
            this.allcount = allcount;
        }

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
             * serial : HK-20181207-000015
             * member_id : 25
             * member_name : 刘永达
             * money : 1018.77
             * remarks : 借款【第JK-20180403-0002号借款】第【7】期偿还
             * date_created : 1544144629
             * date_complete : 1544144629
             */

            private String serial;
            private int member_id;
            private String member_name;
            private double money;
            private String remarks;
            private int date_created;
            private int date_complete;

            public String getSerial() {
                return serial;
            }

            public void setSerial(String serial) {
                this.serial = serial;
            }

            public int getMember_id() {
                return member_id;
            }

            public void setMember_id(int member_id) {
                this.member_id = member_id;
            }

            public String getMember_name() {
                return member_name;
            }

            public void setMember_name(String member_name) {
                this.member_name = member_name;
            }

            public double getMoney() {
                return money;
            }

            public void setMoney(double money) {
                this.money = money;
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
