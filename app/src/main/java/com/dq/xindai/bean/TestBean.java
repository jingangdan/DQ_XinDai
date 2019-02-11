package com.dq.xindai.bean;

import java.util.List;

/**
 * Created by asus on 2018/6/6.
 */

public class TestBean {
    private String name;
    private List<DateBean> dateBeanList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DateBean> getDateBeanList() {
        return dateBeanList;
    }

    public void setDateBeanList(List<DateBean> dateBeanList) {
        this.dateBeanList = dateBeanList;
    }

    public static class DateBean {
        private String name;
        private String phone;

        public DateBean(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}
