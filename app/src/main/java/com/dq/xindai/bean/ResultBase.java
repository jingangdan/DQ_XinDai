package com.dq.xindai.bean;

/**
 * Created by jingang on 2018/12/22.
 */

public class ResultBase {

    /**
     * status : 1
     * info :
     * data : []
     */

    private int status;
    private String info;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "ResultBase{" +
                "status=" + status +
                ", info='" + info + '\'' +
                '}';
    }
}
