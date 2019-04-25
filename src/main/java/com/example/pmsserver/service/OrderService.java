package com.example.pmsserver.service;

import com.example.pmsserver.bean.Order;
import com.example.pmsserver.bean.SubOrder;
import com.example.pmsserver.mapper.MedicineMapper;
import com.example.pmsserver.mapper.OrderMapper;
import com.example.pmsserver.mapper.SubOrderMapper;
import com.example.pmsserver.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Auther: wanjunyi
 * @Date: 2019/4/15 10:13
 * @Description:
 */
@Service
@Transactional
public class OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    SubOrderMapper subOrderMapper;
    @Autowired
    MemberService memberService;
    @Autowired
    MedicineMapper medicineMapper;

    public List<Order> listOrders(int page, int count, Date startDate, Date endDate) {
        int start = (page - 1) * count;
        if (startDate == null) {
            startDate = new Date(1555294908589L);//2019-04-15 10:21:48
        }
        if (endDate == null) {//
            endDate = new Date();
        }
        return orderMapper.listOrders(Util.getCurrentUser().getId(), start, count, startDate, endDate);
    }

    public int getCountOfOrder(Date startDate, Date endDate) {
        if (startDate == null) {
            startDate = new Date(1555294908589L);//2019-04-15 10:21:48
        }
        if (endDate == null) {
            endDate = new Date();
        }
        return orderMapper.getCountOfOrder(Util.getCurrentUser().getId(), startDate, endDate);
    }

    public Order getOrderByOrderNumber(String orderNumber) {
        Order order = orderMapper.getOrderByOrderNumber(orderNumber);
        List subOrder = subOrderMapper.listSubOrders(orderNumber);
        order.setSubOrders(subOrder);
        return order;
    }

    /**
     * 添加订单
     *
     * @param memberid
     * @param subOrders
     * @return 0 失败
     * 1 成功
     */
    public int add(Long memberid, List<SubOrder> subOrders) {
        Order order = new Order();
        String orderNumber = "" + System.currentTimeMillis() + Util.getCurrentUser().getId();
        order.setOrderNumber(orderNumber);
        order.setUid(Util.getCurrentUser().getId());
        if (memberid==null){
            memberid = 0L;
        }
        order.setMemberid(memberid);
        order.setAddTime(new Timestamp(new Date().getTime()));
        BigDecimal totalAmount = new BigDecimal(0);
        if (orderMapper.add(order) == 1) {
            for (SubOrder subOrder : subOrders) {
                subOrder.setOrderNumber(orderNumber);
                subOrder.setUid(Util.getCurrentUser().getId());
                totalAmount = totalAmount.add(subOrder.getCharge().multiply(new BigDecimal(subOrder.getSaleNumber())));
                // 添加子订单失败 或 减少库存失败
                if (subOrderMapper.add(subOrder) != 1||medicineMapper.setNumber(subOrder.getMid(),-(subOrder.getSaleNumber()))!=1) {
                    return 0;
                }
            }
            if (updateAmount(orderNumber, totalAmount) == 1)
                return 1;
            return 0;
        } else {
            return 0;
        }
    }

    /**
     * 支付
     *
     * @param orderNumber
     * @param realAmount
     * @return 0 失败
     * 1 成功
     */
    public int pay(long mid, String orderNumber, BigDecimal realAmount) {
        if (orderMapper.pay(orderNumber, realAmount) == 1) {
            if (memberService.updateTotalAmount(mid,realAmount)==1)
                return 1;
        }
        return 0;
    }

    /**
     *  更新订单总价
     * @param orderNumber
     * @param totalAmount
     * @return
     */
    int updateAmount(String orderNumber, BigDecimal totalAmount) {
        return orderMapper.updateAmount(orderNumber,totalAmount);
    }

    /**
     * 删除订单并删除子订单 并更新库存  仅可删除未支付订单
     * @param orderNumber
     * @return 0 失败
     *         1 成功
     *         2 不可删除已完成订单
     */
    public int delete(String orderNumber){
        if(getOrderByOrderNumber(orderNumber).getStatus()==1)
            return 2;
        if (orderMapper.delete(orderNumber)==1){
            List<SubOrder> list = subOrderMapper.listSubOrders(orderNumber);
            for (SubOrder subOrder : list) {
                medicineMapper.setNumber(subOrder.getMid(),subOrder.getSaleNumber());
            }
            subOrderMapper.deleteAll(orderNumber);
            return 1;
        }
        return 0;
    }

    /**
     * @Description:根据订单号获取子订单列表
     * @param orderNumber
     * @return
     */
    public List<SubOrder> listSubOrders(String orderNumber){
        return subOrderMapper.listSubOrders(orderNumber);
    }

    /**
     * @Description: 获取药品销量
     * @param page
     * @param count
     * @param startDate
     * @param endDate
     * @return
     */
    public List<SubOrder> listSales(int page, int count, Date startDate, Date endDate){
        int start = (page-1)*count;
        if (startDate == null)
            startDate = new Date(1555294908589L);//2019-04-15 10:21:48
        if (endDate == null)
            endDate = new Date();
        return subOrderMapper.listSales(Util.getCurrentUser().getId(),start,count,startDate,endDate);
    }

    /**
     * @Description: 销量总条数
     * @param startDate
     * @param endDate
     * @return
     */
   public int getCountOfMedicine(Date startDate, Date endDate){
        if (startDate == null)
            startDate = new Date(1555294908589L);//2019-04-15 10:21:48
        if (endDate == null)
            endDate = new Date();
        return subOrderMapper.getCountOfMedicine(Util.getCurrentUser().getId(),startDate,endDate);
    }

    /**
     * 获取最新订单号
     * @return
     */
    public String getLatestOrderNumber(){
        return orderMapper.getLatestOrderNumber(Util.getCurrentUser().getId());
    }
}

