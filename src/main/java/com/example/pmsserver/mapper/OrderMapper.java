package com.example.pmsserver.mapper;

import com.example.pmsserver.bean.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Auther: wanjunyi
 * @Date: 2019/4/14 10:15
 * @Description:
 */
@Mapper
public interface OrderMapper {
    List<Order> listOrders(@Param("uid") Long uid, @Param("start") int start, @Param("count") int count, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    int getCountOfOrder(@Param("uid") long uid ,@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    Order getOrderByOrderNumber(@Param("orderNumber") String orderNumber);

//    Order getOrderById(@Param("id") long id);

    int add(Order order);//添加订单，未完成支付

    int pay(@Param("orderNumber") String orderNumber, @Param("realAmount") BigDecimal realAmount); //设置,realAmount,状态为已支付(status=1)

    int updateAmount(@Param("orderNumber") String orderNumber, @Param("totalAmount") BigDecimal totalAmount);

    int delete(@Param("orderNumber") String orderNumber);

    String getLatestOrderNumber(@Param("uid")long uid);

}
