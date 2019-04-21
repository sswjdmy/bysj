package com.example.pmsserver.bean;

import java.math.BigDecimal;

/**
 * @Auther: wanjunyi
 * @Date: 2019/4/8 09:29
 * @Description:
 */
public class MemberBean {
    private long id;
    private long uid;
    private String name;
    private String phone;
    private BigDecimal totalAmount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
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

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
