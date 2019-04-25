package com.example.pmsserver.controller;

import com.alibaba.fastjson.JSON;
import com.example.pmsserver.bean.Order;
import com.example.pmsserver.bean.RespBean;
import com.example.pmsserver.bean.SubOrder;
import com.example.pmsserver.service.MemberService;
import com.example.pmsserver.service.OrderService;
import com.example.pmsserver.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @Auther: wanjunyi
 * @Date: 2019/4/15 14:19
 * @Description:
 */

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    MemberService memberService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> listOrders(@RequestParam(value = "page", defaultValue = "1") int page,
                                          @RequestParam(value = "count", defaultValue = "10") int count,
                                          @RequestParam(value = "startDate", defaultValue = "") Long startDate,
                                          @RequestParam(value = "endDate", defaultValue = "") Long endDate) {
        Map<String, Object> result = new HashMap<>();
        int totalCount = orderService.getCountOfOrder(new Date(startDate),new Date(endDate));
        List<Order> orders = orderService.listOrders(page, count, new Date(startDate),new Date(endDate));
        for (Order order : orders) {
            if(order.getMemberid()==0){
                order.setMemberName("非会员");
            }else {
                order.setMemberName(memberService.getById(order.getMemberid()).getName());
            }
            order.addTimeStr = Util.sdf.format(order.getAddTime());
        }
        result.put("totalCount", totalCount);
        result.put("orders", orders);
        return result;
    }

    /**
     * 订单详情
     *
     * @param orderNumber
     * @return
     */
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Order getOrder(@RequestParam(value = "orderNumber") String orderNumber) {
        return orderService.getOrderByOrderNumber(orderNumber);
    }

    /**
     * @param mid  会员号，
     * @param json 子订单
     * @return
     * @Description: 提交订单 并返回该定单
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, Object> addOrder(Long mid, String json) {
        List<SubOrder> orders = JSON.parseArray(json, SubOrder.class);
        if (orders.isEmpty()) {
            return null;
        }
        Map<String, Object> result = new HashMap<>();
        if (orderService.add(mid, orders) == 1) {
            result.put("status", "success");
            result.put("order", orderService.getOrderByOrderNumber(orderService.getLatestOrderNumber()));
            return result;
        }
        result.put("status", "error");
        return result;
    }

    /**
     * 支付
     *
     * @param order 只需会员号，订单号，实际支付金额
     * @return
     */
    @RequestMapping(value = "/pay", method = RequestMethod.PUT)
    public RespBean pay(Order order) {
        if (orderService.pay(order.getMemberid(), order.getOrderNumber(), order.getRealAmount()) == 1)
            return new RespBean("success", "成功！");
        return new RespBean("error", "失败！");
    }

    /**
     * 通过订单号删除订单
     *
     * @param orderNumber
     * @return
     */
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public RespBean delete(@RequestParam(value = "orderNumber", defaultValue = "") String orderNumber) {
        int result = orderService.delete(orderNumber);
        switch (result) {
            case 0:
                return new RespBean("error", "删除失败！");
            case 1:
                return new RespBean("success", "删除成功！");
            case 2:
                return new RespBean("error", "不可删除已完成订单");
            default:
                return new RespBean("error", "删除失败！");
        }
    }
}