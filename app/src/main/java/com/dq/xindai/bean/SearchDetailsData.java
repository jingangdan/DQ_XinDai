package com.dq.xindai.bean;

import com.google.gson.annotations.SerializedName;

/**
 * 交易详情实体类
 * Created by jingang on 2018/12/29.
 */

public class SearchDetailsData extends ResultBase {


    /**
     * data : {"id":110,"serial":"JK-20180515-0001","dep_order":"R0JrVzIxK0VDMU1CdGt0VzN3aEQxbkFrREZFbXNBa3hWVHVMVllmMURuOGIwQXBLQlg4OXlTZ0hyVlZtM25Lbg==","title":"第JK-20180515-0001号借款","apply_title":"第JK-20180515-0001号借款申请","type_id":0,"category_id":6,"member_id":344,"member_name":"张会彬","dep_account":"KzRCTy95RCtyZ3FwemRxZU0wTmxkejNRdGRXYXFGSWNLQ2x0cmlzbVQ4OD0=","style_id":1,"license":"dEVaOTQvbjNja0pkeUdsdUlFUG1VWEc0OTVTNEs1Lzd0d1RlRVhWT2owMkNwa0dlR2dyaE1hU0tkMWF1WXN0Uw==","repayment_label":"Capital","repayment_name":"等额本息","money":60000,"term":18,"term_type":0,"loan_rate":0,"rate":11,"purpose":"短期周转","is_bset":0,"best_info":null,"guarantee_id":0,"guarantee_name":null,"guarantee_type":"","invest_min":0,"invest_max":0,"is_multiplayer":0,"insure_deadline":10,"insure_start":1526372774,"insure_end":1527236774,"insure_complete":1526548386,"date_fail":0,"fail_type":0,"fail_reason":null,"fail_operator":0,"fail_operator_name":null,"load_count":1,"load_money":60000,"repay_start_time":1526486400,"repay_end_time":1545095623,"repay_next_time":1544976029,"repay_money":22170.04,"repay_free":3247.74,"overdue_money":0,"overdue_count":0,"period":18,"has_period":7,"browse_count":0,"collection_count":0,"share_count":0,"is_aency":0,"aency_user":1,"aency_name":"管理员","service_id":0,"service_name":"","dept_id":1,"trade_id":578,"description":"","remarks":"同意","is_custody":1,"is_delete":0,"is_effect":1,"status":6,"date_created":1526372631,"date_update":1526372767,"handle_id":1,"handle_user":"管理员","handle_reason":"同意","handle_ip":"122.6.144.126","handle_date":1526548577,"service_charge":0,"auto":0,"cash_id":0,"load_id":0,"is_news":0,"is_revoke":0,"category_name":"精英贷"}
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
         * id : 110
         * serial : JK-20180515-0001
         * dep_order : R0JrVzIxK0VDMU1CdGt0VzN3aEQxbkFrREZFbXNBa3hWVHVMVllmMURuOGIwQXBLQlg4OXlTZ0hyVlZtM25Lbg==
         * title : 第JK-20180515-0001号借款
         * apply_title : 第JK-20180515-0001号借款申请
         * type_id : 0
         * category_id : 6
         * member_id : 344
         * member_name : 张会彬
         * dep_account : KzRCTy95RCtyZ3FwemRxZU0wTmxkejNRdGRXYXFGSWNLQ2x0cmlzbVQ4OD0=
         * style_id : 1
         * license : dEVaOTQvbjNja0pkeUdsdUlFUG1VWEc0OTVTNEs1Lzd0d1RlRVhWT2owMkNwa0dlR2dyaE1hU0tkMWF1WXN0Uw==
         * repayment_label : Capital
         * repayment_name : 等额本息
         * money : 60000
         * term : 18
         * term_type : 0
         * loan_rate : 0
         * rate : 11
         * purpose : 短期周转
         * is_bset : 0
         * best_info : null
         * guarantee_id : 0
         * guarantee_name : null
         * guarantee_type :
         * invest_min : 0
         * invest_max : 0
         * is_multiplayer : 0
         * insure_deadline : 10
         * insure_start : 1526372774
         * insure_end : 1527236774
         * insure_complete : 1526548386
         * date_fail : 0
         * fail_type : 0
         * fail_reason : null
         * fail_operator : 0
         * fail_operator_name : null
         * load_count : 1
         * load_money : 60000
         * repay_start_time : 1526486400
         * repay_end_time : 1545095623
         * repay_next_time : 1544976029
         * repay_money : 22170.04
         * repay_free : 3247.74
         * overdue_money : 0
         * overdue_count : 0
         * period : 18
         * has_period : 7
         * browse_count : 0
         * collection_count : 0
         * share_count : 0
         * is_aency : 0
         * aency_user : 1
         * aency_name : 管理员
         * service_id : 0
         * service_name :
         * dept_id : 1
         * trade_id : 578
         * description :
         * remarks : 同意
         * is_custody : 1
         * is_delete : 0
         * is_effect : 1
         * status : 6
         * date_created : 1526372631
         * date_update : 1526372767
         * handle_id : 1
         * handle_user : 管理员
         * handle_reason : 同意
         * handle_ip : 122.6.144.126
         * handle_date : 1526548577
         * service_charge : 0
         * auto : 0
         * cash_id : 0
         * load_id : 0
         * is_news : 0
         * is_revoke : 0
         * category_name : 精英贷
         */

        private int id;
        private String serial;
        private String member_name;
        private String repayment_name;
        private int money;
        private int term;
        private int term_type;
        private int rate;
        private String purpose;
        private int insure_start;
        private int insure_end;
        private int insure_complete;
        private int date_fail;
        private int fail_type;
        private int load_count;
        private int load_money;
        private int repay_start_time;
        private double repay_money;
        private double repay_free;
        private int overdue_money;
        private int overdue_count;
        private int is_aency;
        private String aency_name;
        private String service_name;
        @SerializedName("status")
        private int statusX;
        private int date_update;
        private int auto;
        private String category_name;

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

        public String getMember_name() {
            return member_name;
        }

        public void setMember_name(String member_name) {
            this.member_name = member_name;
        }

        public String getRepayment_name() {
            return repayment_name;
        }

        public void setRepayment_name(String repayment_name) {
            this.repayment_name = repayment_name;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
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

        public int getInsure_start() {
            return insure_start;
        }

        public void setInsure_start(int insure_start) {
            this.insure_start = insure_start;
        }

        public int getInsure_end() {
            return insure_end;
        }

        public void setInsure_end(int insure_end) {
            this.insure_end = insure_end;
        }

        public int getInsure_complete() {
            return insure_complete;
        }

        public void setInsure_complete(int insure_complete) {
            this.insure_complete = insure_complete;
        }

        public int getDate_fail() {
            return date_fail;
        }

        public void setDate_fail(int date_fail) {
            this.date_fail = date_fail;
        }

        public int getFail_type() {
            return fail_type;
        }

        public void setFail_type(int fail_type) {
            this.fail_type = fail_type;
        }

        public int getLoad_count() {
            return load_count;
        }

        public void setLoad_count(int load_count) {
            this.load_count = load_count;
        }

        public int getLoad_money() {
            return load_money;
        }

        public void setLoad_money(int load_money) {
            this.load_money = load_money;
        }

        public int getRepay_start_time() {
            return repay_start_time;
        }

        public void setRepay_start_time(int repay_start_time) {
            this.repay_start_time = repay_start_time;
        }

        public double getRepay_money() {
            return repay_money;
        }

        public void setRepay_money(double repay_money) {
            this.repay_money = repay_money;
        }

        public double getRepay_free() {
            return repay_free;
        }

        public void setRepay_free(double repay_free) {
            this.repay_free = repay_free;
        }

        public int getOverdue_money() {
            return overdue_money;
        }

        public void setOverdue_money(int overdue_money) {
            this.overdue_money = overdue_money;
        }

        public int getOverdue_count() {
            return overdue_count;
        }

        public void setOverdue_count(int overdue_count) {
            this.overdue_count = overdue_count;
        }

        public int getIs_aency() {
            return is_aency;
        }

        public void setIs_aency(int is_aency) {
            this.is_aency = is_aency;
        }

        public String getAency_name() {
            return aency_name;
        }

        public void setAency_name(String aency_name) {
            this.aency_name = aency_name;
        }

        public String getService_name() {
            return service_name;
        }

        public void setService_name(String service_name) {
            this.service_name = service_name;
        }

        public int getStatusX() {
            return statusX;
        }

        public void setStatusX(int statusX) {
            this.statusX = statusX;
        }

        public int getDate_update() {
            return date_update;
        }

        public void setDate_update(int date_update) {
            this.date_update = date_update;
        }

        public int getAuto() {
            return auto;
        }

        public void setAuto(int auto) {
            this.auto = auto;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }
    }
}
