package com.example.pmsserver.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @Auther: wanjunyi
 * @Date: 2019/4/14 10:05
 * @Description:
 */
public class SubOrder {
    private long id;
    private String orderNumber;
    private long uid;
    private long mid;//药品id
    private int saleNumber;
    private BigDecimal charge;
    private String mname;
    private Timestamp addtime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getMid() {
        return mid;
    }

    public void setMid(long mid) {
        this.mid = mid;
    }

    public int getSaleNumber() {
        return saleNumber;
    }

    public void setSaleNumber(int saleNumber) {
        this.saleNumber = saleNumber;
    }

    public BigDecimal getCharge() {
        return charge;
    }

    public void setCharge(BigDecimal charge) {
        this.charge = charge;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public Timestamp getAddtime() {
        return addtime;
    }

    public void setAddtime(Timestamp addtime) {
        this.addtime = addtime;
    }
}
