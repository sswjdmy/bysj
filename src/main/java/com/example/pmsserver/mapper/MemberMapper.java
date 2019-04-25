package com.example.pmsserver.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.example.pmsserver.bean.MemberBean;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther: wanjunyi
 * @Date: 2019/4/8 09:34
 * @Description:
 */
@Mapper
public interface MemberMapper {
    List<MemberBean> getAll(@Param("uid") Long uid,@Param("start") int start,@Param("count") int count);

    int getCountOfUser(@Param("uid") long uid);

    int add(MemberBean member);

    int updateTotalAmount(@Param("id")Long id, @Param("totalAmount")BigDecimal totalAmount);

    MemberBean getbyId(@Param("id")Long id,@Param("uid")Long uid);

    MemberBean getbyPhone(@Param("phone")String phone,@Param("uid")long uid);
}
