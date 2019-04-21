package com.example.pmsserver.mapper;

import com.example.pmsserver.bean.SubOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Auther: wanjunyi
 * @Date: 2019/4/15 09:20
 * @Description: 子订单，一条记录对应一种药品
 */
@Mapper
public interface SubOrderMapper {
    /**
     * 根据订单号获取订单列表
     * @return
     */
    List<SubOrder> listSubOrders(@Param("orderNumber") String orderNumber);

    /**
     * 获取药品销量
     * @param uid
     * @param start
     * @param count
     * @param startDate
     * @param endDate
     * @return String 药名
     *          Integer 数量
     */
    List<Map<String,Integer>> listSales(@Param("uid")long uid, @Param("start") int start, @Param("count") int count, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    int getCountOfMedicine(@Param("uid") long uid ,@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    int add(SubOrder subOrder);

    int delete(@Param("id") long id);

    /**
     * 根据订单号删除所有
     * @param orderNumber
     * @return
     */
    int deleteAll(@Param("orderNumber") String orderNumber);
}
