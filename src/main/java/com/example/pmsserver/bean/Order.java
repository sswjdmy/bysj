package com.example.pmsserver.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * @Auther: wanjunyi
 * @Date: 2019/4/14 09:58
 * @Description:
 */
public class Order {
    private long id;
    private long uid;
    private long memberid;
    private String memberName;
    private String orderNumber;
    private BigDecimal totalAmount;
    private BigDecimal realAmount;
    private int status;
    private String orderDescribe;
    private Timestamp addTime;
    private List<SubOrder> subOrders;

    public String addTimeStr;

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

    public long getMemberid() {
        return memberid;
    }

    public void setMemberid(long memberid) {
        this.memberid = memberid;
    }


    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(BigDecimal realAmount) {
        this.realAmount = realAmount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOrderDescribe() {
        return orderDescribe;
    }

    public void setOrderDescribe(String orderDescribe) {
        this.orderDescribe = orderDescribe;
    }

    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    public List<SubOrder> getSubOrders() {
        return subOrders;
    }

    public void setSubOrders(List<SubOrder> subOrders) {
        this.subOrders = subOrders;
    }
}
