package com.dq.xindai.bean;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * 借款详情实体类
 * Created by jingang on 2018/12/31.
 */

public class FinanceDetailData extends ResultBase{

    /**
     * data : {"borrow":{"id":129,"serial":"JK-20181218-0001","apply_title":"第JK-20181218-0001号借款申请","category_id":6,"member_id":487,"member_name":"范春梅","repayment_name":"等额本息","money":40000,"term":9,"rate":9,"purpose":"装修房屋、购买家电","load_money":40000,"term_type":0,"insure_end":1545959369,"progress":100,"vote_money":0,"loadlist":[{"id":108,"serial":"TZ-20181218-000001","member_id":482,"member_name":"周佐亮","status":2,"money":18000,"lx":681.72},{"id":109,"serial":"TZ-20181225-000001","member_id":374,"member_name":"赵言东","status":2,"money":22000,"lx":833.22}],"repaylist":[{"id":949,"period":1,"date_repay":1548604799,"money":4612.77,"principal":4312.77,"free":300,"last_money":35687.23,"borrow_free":631.67,"status":0},{"id":950,"period":2,"date_repay":1551283199,"money":4612.77,"principal":4345.12,"free":267.65,"last_money":31342.11,"borrow_free":631.67,"status":0},{"id":951,"period":3,"date_repay":1553702399,"money":4612.77,"principal":4377.71,"free":235.07,"last_money":26964.4,"borrow_free":631.67,"status":0},{"id":952,"period":4,"date_repay":1556380799,"money":4612.77,"principal":4410.54,"free":202.23,"last_money":22553.86,"borrow_free":631.67,"status":0},{"id":953,"period":5,"date_repay":1558972799,"money":4612.77,"principal":4443.62,"free":169.15,"last_money":18110.24,"borrow_free":631.67,"status":0},{"id":954,"period":6,"date_repay":1561651199,"money":4612.77,"principal":4476.94,"free":135.83,"last_money":13633.3,"borrow_free":631.67,"status":0},{"id":955,"period":7,"date_repay":1564243199,"money":4612.77,"principal":4510.52,"free":102.25,"last_money":9122.78,"borrow_free":631.67,"status":0},{"id":956,"period":8,"date_repay":1566921599,"money":4612.77,"principal":4544.35,"free":68.42,"last_money":4578.43,"borrow_free":631.67,"status":0},{"id":957,"period":9,"date_repay":1569599999,"money":4612.77,"principal":4578.43,"free":34.34,"last_money":0,"borrow_free":631.67,"status":0}],"day":0,"msecond":0,"overdue_money":0,"repay_money":40000,"overdue_pen":0,"repay_pen":0},"profile":[{"id":119,"borrow_id":129,"type_id":1,"name":"项目信息","content":"","files":[{"hash":"63f289996736666c5d5906ec88b95f5e","type":"image","file_name":"申请表.jpg","file_type":"application/octet-stream","file_size":5031681,"file_ext":"jpg","file_path":"/data/attachment/image/20181218/09/1060c86687515b2792de806134d2edf8.jpg","date_created":1545095298,"date_update":1545095298,"ip":"122.6.144.126","browser":"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36","source":1,"status":1,"is_delete":0,"operator":1},{"hash":"a3329a6fd0ecc9d3cb94f64d7abdd733","type":"image","file_name":"1.png","file_type":"image/png","file_size":190223,"file_ext":"png","file_path":"/data/attachment/image/20181218/09/c3c8c42d8217537973b8e616e6f96c7e.png","date_created":1545095313,"date_update":1545095313,"ip":"122.6.144.126","browser":"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36","source":1,"status":1,"is_delete":0,"operator":1},{"hash":"43bf4784346e8102001a421db5b51506","type":"image","file_name":"养老保险 (1).png","file_type":"image/png","file_size":153767,"file_ext":"png","file_path":"/data/attachment/image/20181218/09/cbd8a0aa359604f9ba892d6749c6f912.png","date_created":1545095324,"date_update":1545095324,"ip":"122.6.144.126","browser":"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36","source":1,"status":1,"is_delete":0,"operator":1},{"hash":"fb33904959f2231e9be588f328fba622","type":"image","file_name":"考察报告.jpg","file_type":"application/octet-stream","file_size":2906822,"file_ext":"jpg","file_path":"/data/attachment/image/20181218/09/6edb3f200d0b5a25c81c65316d4ef232.jpg","date_created":1545095334,"date_update":1545095334,"ip":"122.6.144.126","browser":"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36","source":1,"status":1,"is_delete":0,"operator":1},{"hash":"ac3d89a742f0dfdab3397d092e0d539a","type":"image","file_name":"公司合影 (1).jpg","file_type":"image/jpeg","file_size":309645,"file_ext":"jpg","file_path":"/data/attachment/image/20181218/09/38d81af7f14139a1e2d56f5b27e63579.jpg","date_created":1545095343,"date_update":1545095343,"ip":"122.6.144.126","browser":"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36","source":1,"status":1,"is_delete":0,"operator":1},{"hash":"2f2281af770bf4bf2f99b69001f8872a","type":"image","file_name":"居住地合影.jpg","file_type":"image/jpeg","file_size":353648,"file_ext":"jpg","file_path":"/data/attachment/image/20181218/09/179518da0209c50e9484a44d6589fcfc.jpg","date_created":1545095350,"date_update":1545095350,"ip":"122.6.144.126","browser":"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36","source":1,"status":1,"is_delete":0,"operator":1}],"is_effect":1,"status":0,"date_created":1545095359,"date_update":1545095359,"aency_user":0,"aency_name":null}],"member":{"member_id":487,"date_created":1545095147,"date_update":1545095362,"xl":4,"sr":5,"sex":2,"zw":"铁路局后勤管理","hy":2,"fc":"济南市历下区","cl":"有","nx":5,"dizhi":"","adr":"113456","name":"范春梅","idcard":"370105197101233325"}}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    @SuppressLint("ParcelCreator")
    public static class DataBean implements Parcelable, Serializable {
        /**
         * borrow : {"id":129,"serial":"JK-20181218-0001","apply_title":"第JK-20181218-0001号借款申请","category_id":6,"member_id":487,"member_name":"范春梅","repayment_name":"等额本息","money":40000,"term":9,"rate":9,"purpose":"装修房屋、购买家电","load_money":40000,"term_type":0,"insure_end":1545959369,"progress":100,"vote_money":0,"loadlist":[{"id":108,"serial":"TZ-20181218-000001","member_id":482,"member_name":"周佐亮","status":2,"money":18000,"lx":681.72},{"id":109,"serial":"TZ-20181225-000001","member_id":374,"member_name":"赵言东","status":2,"money":22000,"lx":833.22}],"repaylist":[{"id":949,"period":1,"date_repay":1548604799,"money":4612.77,"principal":4312.77,"free":300,"last_money":35687.23,"borrow_free":631.67,"status":0},{"id":950,"period":2,"date_repay":1551283199,"money":4612.77,"principal":4345.12,"free":267.65,"last_money":31342.11,"borrow_free":631.67,"status":0},{"id":951,"period":3,"date_repay":1553702399,"money":4612.77,"principal":4377.71,"free":235.07,"last_money":26964.4,"borrow_free":631.67,"status":0},{"id":952,"period":4,"date_repay":1556380799,"money":4612.77,"principal":4410.54,"free":202.23,"last_money":22553.86,"borrow_free":631.67,"status":0},{"id":953,"period":5,"date_repay":1558972799,"money":4612.77,"principal":4443.62,"free":169.15,"last_money":18110.24,"borrow_free":631.67,"status":0},{"id":954,"period":6,"date_repay":1561651199,"money":4612.77,"principal":4476.94,"free":135.83,"last_money":13633.3,"borrow_free":631.67,"status":0},{"id":955,"period":7,"date_repay":1564243199,"money":4612.77,"principal":4510.52,"free":102.25,"last_money":9122.78,"borrow_free":631.67,"status":0},{"id":956,"period":8,"date_repay":1566921599,"money":4612.77,"principal":4544.35,"free":68.42,"last_money":4578.43,"borrow_free":631.67,"status":0},{"id":957,"period":9,"date_repay":1569599999,"money":4612.77,"principal":4578.43,"free":34.34,"last_money":0,"borrow_free":631.67,"status":0}],"day":0,"msecond":0,"overdue_money":0,"repay_money":40000,"overdue_pen":0,"repay_pen":0}
         * profile : [{"id":119,"borrow_id":129,"type_id":1,"name":"项目信息","content":"","files":[{"hash":"63f289996736666c5d5906ec88b95f5e","type":"image","file_name":"申请表.jpg","file_type":"application/octet-stream","file_size":5031681,"file_ext":"jpg","file_path":"/data/attachment/image/20181218/09/1060c86687515b2792de806134d2edf8.jpg","date_created":1545095298,"date_update":1545095298,"ip":"122.6.144.126","browser":"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36","source":1,"status":1,"is_delete":0,"operator":1},{"hash":"a3329a6fd0ecc9d3cb94f64d7abdd733","type":"image","file_name":"1.png","file_type":"image/png","file_size":190223,"file_ext":"png","file_path":"/data/attachment/image/20181218/09/c3c8c42d8217537973b8e616e6f96c7e.png","date_created":1545095313,"date_update":1545095313,"ip":"122.6.144.126","browser":"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36","source":1,"status":1,"is_delete":0,"operator":1},{"hash":"43bf4784346e8102001a421db5b51506","type":"image","file_name":"养老保险 (1).png","file_type":"image/png","file_size":153767,"file_ext":"png","file_path":"/data/attachment/image/20181218/09/cbd8a0aa359604f9ba892d6749c6f912.png","date_created":1545095324,"date_update":1545095324,"ip":"122.6.144.126","browser":"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36","source":1,"status":1,"is_delete":0,"operator":1},{"hash":"fb33904959f2231e9be588f328fba622","type":"image","file_name":"考察报告.jpg","file_type":"application/octet-stream","file_size":2906822,"file_ext":"jpg","file_path":"/data/attachment/image/20181218/09/6edb3f200d0b5a25c81c65316d4ef232.jpg","date_created":1545095334,"date_update":1545095334,"ip":"122.6.144.126","browser":"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36","source":1,"status":1,"is_delete":0,"operator":1},{"hash":"ac3d89a742f0dfdab3397d092e0d539a","type":"image","file_name":"公司合影 (1).jpg","file_type":"image/jpeg","file_size":309645,"file_ext":"jpg","file_path":"/data/attachment/image/20181218/09/38d81af7f14139a1e2d56f5b27e63579.jpg","date_created":1545095343,"date_update":1545095343,"ip":"122.6.144.126","browser":"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36","source":1,"status":1,"is_delete":0,"operator":1},{"hash":"2f2281af770bf4bf2f99b69001f8872a","type":"image","file_name":"居住地合影.jpg","file_type":"image/jpeg","file_size":353648,"file_ext":"jpg","file_path":"/data/attachment/image/20181218/09/179518da0209c50e9484a44d6589fcfc.jpg","date_created":1545095350,"date_update":1545095350,"ip":"122.6.144.126","browser":"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36","source":1,"status":1,"is_delete":0,"operator":1}],"is_effect":1,"status":0,"date_created":1545095359,"date_update":1545095359,"aency_user":0,"aency_name":null}]
         * member : {"member_id":487,"date_created":1545095147,"date_update":1545095362,"xl":4,"sr":5,"sex":2,"zw":"铁路局后勤管理","hy":2,"fc":"济南市历下区","cl":"有","nx":5,"dizhi":"","adr":"113456","name":"范春梅","idcard":"370105197101233325"}
         */

        private BorrowBean borrow;
        private MemberBean member;
        private List<ProfileBean> profile;

        protected DataBean(Parcel in) {
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel in) {
                return new DataBean(in);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };

        public BorrowBean getBorrow() {
            return borrow;
        }

        public void setBorrow(BorrowBean borrow) {
            this.borrow = borrow;
        }

        public MemberBean getMember() {
            return member;
        }

        public void setMember(MemberBean member) {
            this.member = member;
        }

        public List<ProfileBean> getProfile() {
            return profile;
        }

        public void setProfile(List<ProfileBean> profile) {
            this.profile = profile;
        }

        public static class BorrowBean {
            /**
             * id : 129
             * serial : JK-20181218-0001
             * apply_title : 第JK-20181218-0001号借款申请
             * category_id : 6
             * member_id : 487
             * member_name : 范春梅
             * repayment_name : 等额本息
             * money : 40000
             * term : 9
             * rate : 9
             * purpose : 装修房屋、购买家电
             * load_money : 40000
             * term_type : 0
             * insure_end : 1545959369
             * progress : 100
             * vote_money : 0
             * loadlist : [{"id":108,"serial":"TZ-20181218-000001","member_id":482,"member_name":"周佐亮","status":2,"money":18000,"lx":681.72},{"id":109,"serial":"TZ-20181225-000001","member_id":374,"member_name":"赵言东","status":2,"money":22000,"lx":833.22}]
             * repaylist : [{"id":949,"period":1,"date_repay":1548604799,"money":4612.77,"principal":4312.77,"free":300,"last_money":35687.23,"borrow_free":631.67,"status":0},{"id":950,"period":2,"date_repay":1551283199,"money":4612.77,"principal":4345.12,"free":267.65,"last_money":31342.11,"borrow_free":631.67,"status":0},{"id":951,"period":3,"date_repay":1553702399,"money":4612.77,"principal":4377.71,"free":235.07,"last_money":26964.4,"borrow_free":631.67,"status":0},{"id":952,"period":4,"date_repay":1556380799,"money":4612.77,"principal":4410.54,"free":202.23,"last_money":22553.86,"borrow_free":631.67,"status":0},{"id":953,"period":5,"date_repay":1558972799,"money":4612.77,"principal":4443.62,"free":169.15,"last_money":18110.24,"borrow_free":631.67,"status":0},{"id":954,"period":6,"date_repay":1561651199,"money":4612.77,"principal":4476.94,"free":135.83,"last_money":13633.3,"borrow_free":631.67,"status":0},{"id":955,"period":7,"date_repay":1564243199,"money":4612.77,"principal":4510.52,"free":102.25,"last_money":9122.78,"borrow_free":631.67,"status":0},{"id":956,"period":8,"date_repay":1566921599,"money":4612.77,"principal":4544.35,"free":68.42,"last_money":4578.43,"borrow_free":631.67,"status":0},{"id":957,"period":9,"date_repay":1569599999,"money":4612.77,"principal":4578.43,"free":34.34,"last_money":0,"borrow_free":631.67,"status":0}]
             * day : 0
             * msecond : 0
             * overdue_money : 0
             * repay_money : 40000
             * overdue_pen : 0
             * repay_pen : 0
             */

            private int id;
            private String serial;
            private String apply_title;
            private int category_id;
            private int member_id;
            private String member_name;
            private String repayment_name;
            private double money;
            private int term;
            private int rate;
            private String purpose;
            private double load_money;
            private int term_type;
            private int insure_end;
            private int progress;
            private double vote_money;
            private int day;
            private int msecond;
            private double overdue_money;
            private double repay_money;
            private int overdue_pen;
            private int repay_pen;
            private List<LoadlistBean> loadlist;
            private List<RepaylistBean> repaylist;

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

            public String getApply_title() {
                return apply_title;
            }

            public void setApply_title(String apply_title) {
                this.apply_title = apply_title;
            }

            public int getCategory_id() {
                return category_id;
            }

            public void setCategory_id(int category_id) {
                this.category_id = category_id;
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

            public String getRepayment_name() {
                return repayment_name;
            }

            public void setRepayment_name(String repayment_name) {
                this.repayment_name = repayment_name;
            }

            public double getMoney() {
                return money;
            }

            public void setMoney(double money) {
                this.money = money;
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

            public double getLoad_money() {
                return load_money;
            }

            public void setLoad_money(double load_money) {
                this.load_money = load_money;
            }

            public int getTerm_type() {
                return term_type;
            }

            public void setTerm_type(int term_type) {
                this.term_type = term_type;
            }

            public int getInsure_end() {
                return insure_end;
            }

            public void setInsure_end(int insure_end) {
                this.insure_end = insure_end;
            }

            public int getProgress() {
                return progress;
            }

            public void setProgress(int progress) {
                this.progress = progress;
            }

            public double getVote_money() {
                return vote_money;
            }

            public void setVote_money(double vote_money) {
                this.vote_money = vote_money;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }

            public int getMsecond() {
                return msecond;
            }

            public void setMsecond(int msecond) {
                this.msecond = msecond;
            }

            public double getOverdue_money() {
                return overdue_money;
            }

            public void setOverdue_money(double overdue_money) {
                this.overdue_money = overdue_money;
            }

            public double getRepay_money() {
                return repay_money;
            }

            public void setRepay_money(double repay_money) {
                this.repay_money = repay_money;
            }

            public int getOverdue_pen() {
                return overdue_pen;
            }

            public void setOverdue_pen(int overdue_pen) {
                this.overdue_pen = overdue_pen;
            }

            public int getRepay_pen() {
                return repay_pen;
            }

            public void setRepay_pen(int repay_pen) {
                this.repay_pen = repay_pen;
            }

            public List<LoadlistBean> getLoadlist() {
                return loadlist;
            }

            public void setLoadlist(List<LoadlistBean> loadlist) {
                this.loadlist = loadlist;
            }

            public List<RepaylistBean> getRepaylist() {
                return repaylist;
            }

            public void setRepaylist(List<RepaylistBean> repaylist) {
                this.repaylist = repaylist;
            }

            @SuppressLint("ParcelCreator")
            public static class LoadlistBean  implements Parcelable {
                /**
                 * id : 108
                 * serial : TZ-20181218-000001
                 * member_id : 482
                 * member_name : 周佐亮
                 * status : 2
                 * money : 18000
                 * lx : 681.72
                 */

                private int id;
                private String serial;
                private int member_id;
                private String member_name;
                @SerializedName("status")
                private int statusX;
                private double money;
                private double lx;
                private int date_created;

                public int getDate_created() {
                    return date_created;
                }

                public void setDate_created(int date_created) {
                    this.date_created = date_created;
                }

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

                public int getStatusX() {
                    return statusX;
                }

                public void setStatusX(int statusX) {
                    this.statusX = statusX;
                }

                public double getMoney() {
                    return money;
                }

                public void setMoney(double money) {
                    this.money = money;
                }

                public double getLx() {
                    return lx;
                }

                public void setLx(double lx) {
                    this.lx = lx;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel parcel, int i) {

                }
            }

            @SuppressLint("ParcelCreator")
            public static class RepaylistBean implements Parcelable{
                /**
                 * id : 949
                 * period : 1
                 * date_repay : 1548604799
                 * money : 4612.77
                 * principal : 4312.77
                 * free : 300
                 * last_money : 35687.23
                 * borrow_free : 631.67
                 * status : 0
                 */

                private int id;
                private int period;
                private int date_repay;
                private double money;
                private double principal;
                private double free;
                private double last_money;
                private double borrow_free;
                @SerializedName("status")
                private int statusX;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getPeriod() {
                    return period;
                }

                public void setPeriod(int period) {
                    this.period = period;
                }

                public int getDate_repay() {
                    return date_repay;
                }

                public void setDate_repay(int date_repay) {
                    this.date_repay = date_repay;
                }

                public double getMoney() {
                    return money;
                }

                public void setMoney(double money) {
                    this.money = money;
                }

                public double getPrincipal() {
                    return principal;
                }

                public void setPrincipal(double principal) {
                    this.principal = principal;
                }

                public double getFree() {
                    return free;
                }

                public void setFree(double free) {
                    this.free = free;
                }

                public double getLast_money() {
                    return last_money;
                }

                public void setLast_money(double last_money) {
                    this.last_money = last_money;
                }

                public double getBorrow_free() {
                    return borrow_free;
                }

                public void setBorrow_free(double borrow_free) {
                    this.borrow_free = borrow_free;
                }

                public int getStatusX() {
                    return statusX;
                }

                public void setStatusX(int statusX) {
                    this.statusX = statusX;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel parcel, int i) {

                }
            }
        }

        public static class MemberBean  implements Serializable{
            /**
             * member_id : 487
             * date_created : 1545095147
             * date_update : 1545095362
             * xl : 4
             * sr : 5
             * sex : 2
             * zw : 铁路局后勤管理
             * hy : 2
             * fc : 济南市历下区
             * cl : 有
             * nx : 5
             * dizhi :
             * adr : 113456
             * name : 范春梅
             * idcard : 370105197101233325
             */

            private int member_id;
            private int date_created;
            private int date_update;
            private int xl;
            private int sr;
            private int sex;
            private String zw;
            private int hy;
            private String fc;
            private String cl;
            private int nx;
            private String dizhi;
            private String adr;
            private String name;
            private String idcard;

            public int getMember_id() {
                return member_id;
            }

            public void setMember_id(int member_id) {
                this.member_id = member_id;
            }

            public int getDate_created() {
                return date_created;
            }

            public void setDate_created(int date_created) {
                this.date_created = date_created;
            }

            public int getDate_update() {
                return date_update;
            }

            public void setDate_update(int date_update) {
                this.date_update = date_update;
            }

            public int getXl() {
                return xl;
            }

            public void setXl(int xl) {
                this.xl = xl;
            }

            public int getSr() {
                return sr;
            }

            public void setSr(int sr) {
                this.sr = sr;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }

            public String getZw() {
                return zw;
            }

            public void setZw(String zw) {
                this.zw = zw;
            }

            public int getHy() {
                return hy;
            }

            public void setHy(int hy) {
                this.hy = hy;
            }

            public String getFc() {
                return fc;
            }

            public void setFc(String fc) {
                this.fc = fc;
            }

            public String getCl() {
                return cl;
            }

            public void setCl(String cl) {
                this.cl = cl;
            }

            public int getNx() {
                return nx;
            }

            public void setNx(int nx) {
                this.nx = nx;
            }

            public String getDizhi() {
                return dizhi;
            }

            public void setDizhi(String dizhi) {
                this.dizhi = dizhi;
            }

            public String getAdr() {
                return adr;
            }

            public void setAdr(String adr) {
                this.adr = adr;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getIdcard() {
                return idcard;
            }

            public void setIdcard(String idcard) {
                this.idcard = idcard;
            }
        }

        public static class ProfileBean implements Parcelable{
            /**
             * id : 119
             * borrow_id : 129
             * type_id : 1
             * name : 项目信息
             * content :
             * files : [{"hash":"63f289996736666c5d5906ec88b95f5e","type":"image","file_name":"申请表.jpg","file_type":"application/octet-stream","file_size":5031681,"file_ext":"jpg","file_path":"/data/attachment/image/20181218/09/1060c86687515b2792de806134d2edf8.jpg","date_created":1545095298,"date_update":1545095298,"ip":"122.6.144.126","browser":"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36","source":1,"status":1,"is_delete":0,"operator":1},{"hash":"a3329a6fd0ecc9d3cb94f64d7abdd733","type":"image","file_name":"1.png","file_type":"image/png","file_size":190223,"file_ext":"png","file_path":"/data/attachment/image/20181218/09/c3c8c42d8217537973b8e616e6f96c7e.png","date_created":1545095313,"date_update":1545095313,"ip":"122.6.144.126","browser":"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36","source":1,"status":1,"is_delete":0,"operator":1},{"hash":"43bf4784346e8102001a421db5b51506","type":"image","file_name":"养老保险 (1).png","file_type":"image/png","file_size":153767,"file_ext":"png","file_path":"/data/attachment/image/20181218/09/cbd8a0aa359604f9ba892d6749c6f912.png","date_created":1545095324,"date_update":1545095324,"ip":"122.6.144.126","browser":"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36","source":1,"status":1,"is_delete":0,"operator":1},{"hash":"fb33904959f2231e9be588f328fba622","type":"image","file_name":"考察报告.jpg","file_type":"application/octet-stream","file_size":2906822,"file_ext":"jpg","file_path":"/data/attachment/image/20181218/09/6edb3f200d0b5a25c81c65316d4ef232.jpg","date_created":1545095334,"date_update":1545095334,"ip":"122.6.144.126","browser":"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36","source":1,"status":1,"is_delete":0,"operator":1},{"hash":"ac3d89a742f0dfdab3397d092e0d539a","type":"image","file_name":"公司合影 (1).jpg","file_type":"image/jpeg","file_size":309645,"file_ext":"jpg","file_path":"/data/attachment/image/20181218/09/38d81af7f14139a1e2d56f5b27e63579.jpg","date_created":1545095343,"date_update":1545095343,"ip":"122.6.144.126","browser":"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36","source":1,"status":1,"is_delete":0,"operator":1},{"hash":"2f2281af770bf4bf2f99b69001f8872a","type":"image","file_name":"居住地合影.jpg","file_type":"image/jpeg","file_size":353648,"file_ext":"jpg","file_path":"/data/attachment/image/20181218/09/179518da0209c50e9484a44d6589fcfc.jpg","date_created":1545095350,"date_update":1545095350,"ip":"122.6.144.126","browser":"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36","source":1,"status":1,"is_delete":0,"operator":1}]
             * is_effect : 1
             * status : 0
             * date_created : 1545095359
             * date_update : 1545095359
             * aency_user : 0
             * aency_name : null
             */
            private int id;
            private int borrow_id;
            private int type_id;
            private String name;
            private String content;
            private int is_effect;
            @SerializedName("status")
            private int statusX;
            private int date_created;
            private int date_update;
            private int aency_user;
            private Object aency_name;
            private List<FilesBean> files;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getBorrow_id() {
                return borrow_id;
            }

            public void setBorrow_id(int borrow_id) {
                this.borrow_id = borrow_id;
            }

            public int getType_id() {
                return type_id;
            }

            public void setType_id(int type_id) {
                this.type_id = type_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getIs_effect() {
                return is_effect;
            }

            public void setIs_effect(int is_effect) {
                this.is_effect = is_effect;
            }

            public int getStatusX() {
                return statusX;
            }

            public void setStatusX(int statusX) {
                this.statusX = statusX;
            }

            public int getDate_created() {
                return date_created;
            }

            public void setDate_created(int date_created) {
                this.date_created = date_created;
            }

            public int getDate_update() {
                return date_update;
            }

            public void setDate_update(int date_update) {
                this.date_update = date_update;
            }

            public int getAency_user() {
                return aency_user;
            }

            public void setAency_user(int aency_user) {
                this.aency_user = aency_user;
            }

            public Object getAency_name() {
                return aency_name;
            }

            public void setAency_name(Object aency_name) {
                this.aency_name = aency_name;
            }

            public List<FilesBean> getFiles() {
                return files;
            }

            public void setFiles(List<FilesBean> files) {
                this.files = files;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel parcel, int i) {

            }

            public static class FilesBean {
                /**
                 * hash : 63f289996736666c5d5906ec88b95f5e
                 * type : image
                 * file_name : 申请表.jpg
                 * file_type : application/octet-stream
                 * file_size : 5031681
                 * file_ext : jpg
                 * file_path : /data/attachment/image/20181218/09/1060c86687515b2792de806134d2edf8.jpg
                 * date_created : 1545095298
                 * date_update : 1545095298
                 * ip : 122.6.144.126
                 * browser : Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36
                 * source : 1
                 * status : 1
                 * is_delete : 0
                 * operator : 1
                 */

                private String hash;
                private String type;
                private String file_name;
                private String file_type;
                private int file_size;
                private String file_ext;
                private String file_path;
                private int date_created;
                private int date_update;
                private String ip;
                private String browser;
                private int source;
                @SerializedName("status")
                private int statusX;
                private int is_delete;
                private int operator;
                private String tmpimg;

                public String getTmpimg() {
                    return tmpimg;
                }

                public void setTmpimg(String tmpimg) {
                    this.tmpimg = tmpimg;
                }

                public String getHash() {
                    return hash;
                }

                public void setHash(String hash) {
                    this.hash = hash;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getFile_name() {
                    return file_name;
                }

                public void setFile_name(String file_name) {
                    this.file_name = file_name;
                }

                public String getFile_type() {
                    return file_type;
                }

                public void setFile_type(String file_type) {
                    this.file_type = file_type;
                }

                public int getFile_size() {
                    return file_size;
                }

                public void setFile_size(int file_size) {
                    this.file_size = file_size;
                }

                public String getFile_ext() {
                    return file_ext;
                }

                public void setFile_ext(String file_ext) {
                    this.file_ext = file_ext;
                }

                public String getFile_path() {
                    return file_path;
                }

                public void setFile_path(String file_path) {
                    this.file_path = file_path;
                }

                public int getDate_created() {
                    return date_created;
                }

                public void setDate_created(int date_created) {
                    this.date_created = date_created;
                }

                public int getDate_update() {
                    return date_update;
                }

                public void setDate_update(int date_update) {
                    this.date_update = date_update;
                }

                public String getIp() {
                    return ip;
                }

                public void setIp(String ip) {
                    this.ip = ip;
                }

                public String getBrowser() {
                    return browser;
                }

                public void setBrowser(String browser) {
                    this.browser = browser;
                }

                public int getSource() {
                    return source;
                }

                public void setSource(int source) {
                    this.source = source;
                }

                public int getStatusX() {
                    return statusX;
                }

                public void setStatusX(int statusX) {
                    this.statusX = statusX;
                }

                public int getIs_delete() {
                    return is_delete;
                }

                public void setIs_delete(int is_delete) {
                    this.is_delete = is_delete;
                }

                public int getOperator() {
                    return operator;
                }

                public void setOperator(int operator) {
                    this.operator = operator;
                }
            }
        }
    }
}
