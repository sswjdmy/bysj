package com.example.pmsserver.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.example.pmsserver.bean.MType;

import java.util.List;

/**
 * @Auther: wanjunyi
 * @Date: 2019/3/11 10:54
 * @Description: medicine type mapper
 */
@Mapper
public interface MTypeMapper {
    int addType(MType mType);

    List<MType> getTypes(@Param("uid") Long uid);

    MType getTypeByName(@Param("uid")Long uid,@Param("cateName")String cateName);

    MType getTypeById(@Param("id") Long id);

    int updateName(@Param("id")Long id,@Param("cateName") String cateName);

    int updateNumber(@Param("id")Long id,@Param("subNumber")int number);

    int deleteType(@Param("id") Long id);
}
