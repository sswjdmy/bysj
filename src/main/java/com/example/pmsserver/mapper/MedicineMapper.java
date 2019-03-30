package com.example.pmsserver.mapper;

import com.example.pmsserver.bean.Medicine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: wanjunyi
 * @Date: 2019/3/15 18:22
 * @Description:
 */
@Mapper
public interface MedicineMapper {
    int addNewMedicine(Medicine medicine);

    int updateMedicine(Medicine medicine);

    Medicine getMedicineByName(@Param("medicineName")String medicineName,@Param("uid")Long uid);

    int getMedicineCountOfUser(@Param("uid")Long uid,@Param("keywords")String keywords);

    int getMedicineCountOfType(@Param("tid")Long tid,@Param("keywords")String keywords);


    List<Medicine> getMedicinesByType(@Param("tid")Long tid,@Param("start")int start,@Param("count")
                                int count,@Param("keywords")String keywords);

    List<Medicine> getMedicinesByUser(@Param("uid")Long uid,@Param("start")int start,@Param("count")
                                int count,@Param("keywords")String keywords);
    int deleteMedicineById(@Param("id")Long id);

}
