package com.dq.xindai.bean;

import java.util.List;

/**
 * 回款账单实体类
 * Created by jingang on 2018/12/27.
 */

public class SearchFlowData extends ResultBase {

    /**
     * data : {"page":1,"pagesize":10,"list":[{"description":"第【TX-20181226-000001】号提现手续费","balance":"0","date_created":1545813738},{"description":"第【TX-20181226-000001】号提现成功","balance":"-897.5","date_created":1545813738},{"description":"第【TX-20181206-00072】号提现手续费","balance":"-22","date_created":1545810801},{"description":"第【TX-20181206-00072】号提现成功","balance":"-39978","date_created":1545810801},{"description":"第【CZ-20181226-00443】号充值成功","balance":"1","date_created":1545803633},{"description":"第【CZ-20181226-00443】号充值手续费","balance":"0","date_created":1545803633},{"description":"第【6053.00】号充值成功","balance":"6053","date_created":1545803135},{"description":"第【4975.00】号充值成功","balance":"4975","date_created":1545803034},{"description":"借款【第JK-20180625-0002号借款】第【6】期偿还本金","balance":"3333.33","date_created":1545793494},{"description":"偿还借款【第JK-20180625-0002号借款】第【6】期本金","balance":"-3224.94","date_created":1545793494}]}
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
         * list : [{"description":"第【TX-20181226-000001】号提现手续费","balance":"0","date_created":1545813738},{"description":"第【TX-20181226-000001】号提现成功","balance":"-897.5","date_created":1545813738},{"description":"第【TX-20181206-00072】号提现手续费","balance":"-22","date_created":1545810801},{"description":"第【TX-20181206-00072】号提现成功","balance":"-39978","date_created":1545810801},{"description":"第【CZ-20181226-00443】号充值成功","balance":"1","date_created":1545803633},{"description":"第【CZ-20181226-00443】号充值手续费","balance":"0","date_created":1545803633},{"description":"第【6053.00】号充值成功","balance":"6053","date_created":1545803135},{"description":"第【4975.00】号充值成功","balance":"4975","date_created":1545803034},{"description":"借款【第JK-20180625-0002号借款】第【6】期偿还本金","balance":"3333.33","date_created":1545793494},{"description":"偿还借款【第JK-20180625-0002号借款】第【6】期本金","balance":"-3224.94","date_created":1545793494}]
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
             * description : 第【TX-20181226-000001】号提现手续费
             * balance : 0
             * date_created : 1545813738
             */

            private String description;
            private String balance;
            private int date_created;

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getBalance() {
                return balance;
            }

            public void setBalance(String balance) {
                this.balance = balance;
            }

            public int getDate_created() {
                return date_created;
            }

            public void setDate_created(int date_created) {
                this.date_created = date_created;
            }
        }
    }
}
