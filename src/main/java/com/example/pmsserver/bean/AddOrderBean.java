package com.example.pmsserver.bean;

import java.util.List;

/**
 * @Auther: wanjunyi
 * @Date: 2019/4/15 14:52
 * @Description: 添加订单，提交类型
 */
public class AddOrderBean {
    private Long mid;
    private List<SubOrder> subOrders;

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public List<SubOrder> getSubOrders() {
        return subOrders;
    }

    public void setSubOrders(List<SubOrder> subOrders) {
        this.subOrders = subOrders;
    }
}
