package com.dq.xindai.bean;

/**
 * 交易搜索（状态）实体类
 * Created by jingang on 2018/12/30.
 */

public class TransactionStatusData {
    private String id;
    private String title;
    private boolean isChange;

    public TransactionStatusData(String id, String title, boolean isChange) {
        this.id = id;
        this.title = title;
        this.isChange = isChange;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isChange() {
        return isChange;
    }

    public void setChange(boolean change) {
        isChange = change;
    }
}
