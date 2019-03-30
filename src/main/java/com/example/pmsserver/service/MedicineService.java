package com.example.pmsserver.service;

import com.example.pmsserver.bean.Medicine;
import com.example.pmsserver.mapper.MTypeMapper;
import com.example.pmsserver.mapper.MedicineMapper;
import com.example.pmsserver.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: wanjunyi
 * @Date: 2019/3/15 19:26
 * @Description:
 */
@Transactional
@Service
public class MedicineService {
    @Autowired
    MedicineMapper medicineMapper;
    @Autowired
    MTypeMapper mTypeMapper;

    /**
     * @param medicine
     * @return 0 : 成功
     *    失败 1：该用户已定义该名称药品
     *         2：错误
     */
    public int addNewMedicine(Medicine medicine){
        medicine.setUid(Util.getCurrentUser().getId());
        if (medicineMapper.getMedicineByName(medicine.getMedicineName(), Util.getCurrentUser().getId())!=null){
            return 1;
        }else {
            if (mTypeMapper.updatesubNumber(medicine.getTid(),mTypeMapper.getTypeById(medicine.getTid()).getSubNumber()+1)==1 && medicineMapper.addNewMedicine(medicine)==1){
                return 0;
            }else {
                return 2;
            }
        }
    }

    /**
     * @param medicine
     * @return
     *          0 成功
     *          1 失败：该用户已定义该名称药品
     *          2 修改失败
     */
    public int updateMedicine(Medicine medicine){
        if (medicineMapper.getMedicineByName(medicine.getMedicineName(),Util.getCurrentUser().getId())==null||medicineMapper.getMedicineByName(medicine.getMedicineName(),Util.getCurrentUser().getId()).getId()==medicine.getId()){
           if (medicineMapper.updateMedicine(medicine)==1){
            return 0;
           }else {
               return 2;
           }
        }else {
            return 1;
        }
    }

    public int getMedicineCountOfUser(Long uid,String keywords){
        return medicineMapper.getMedicineCountOfUser(uid,keywords);
    }

    public int getMedicineCountOfType(Long tid,String keywords){
        return medicineMapper.getMedicineCountOfType(tid,keywords);
    }

    public List<Medicine> getMedicinesByType(Long tid,int page,int count,String keywords){
        int start =(page-1)*count;
        return medicineMapper.getMedicinesByType(tid,start,count,keywords);
    }

    public List<Medicine> getMedicinesByUser(Long uid,int page,int count,String keywords){
        int start =(page-1)*count;
        return medicineMapper.getMedicinesByUser(uid,start,count,keywords);
    }

    /**
     * @param id
     * @return 0 成功
     *          1 失败
     */
    public int deleteMedicineById(Long id){
        if (medicineMapper.deleteMedicineById(id)==1){
            return 0;
        }
        return 1;
    }
}
