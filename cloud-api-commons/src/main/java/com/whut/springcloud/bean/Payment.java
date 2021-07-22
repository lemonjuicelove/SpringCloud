package com.whut.springcloud.bean;

import java.io.Serializable;

// 实体订单
public class Payment implements Serializable {

    private String id;
    private String serial;

    public Payment() {
    }

    public Payment(String id, String serial) {
        this.id = id;
        this.serial = serial;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", serial='" + serial + '\'' +
                '}';
    }

}
