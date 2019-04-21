package com.example.pmsserver.controller;

import com.example.pmsserver.bean.Medicine;
import com.example.pmsserver.bean.RespBean;
import com.example.pmsserver.bean.RespMedicine;
import com.example.pmsserver.service.MTypeService;
import com.example.pmsserver.service.MedicineService;
import com.example.pmsserver.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.*;

/**
 * @Auther: wanjunyi
 * @Date: 2019/3/15 20:09
 * @Description:
 */
@RestController
@RequestMapping("/medicine")
public class MedicineController {
    @Autowired
    MedicineService medicineService;
    @Autowired
    MTypeService mTypeService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public RespBean add(Medicine medicine){
        medicine.setUid(Util.getCurrentUser().getId());
        medicine.setAddTime(new Timestamp(new Date().getTime()));
        int result = medicineService.addNewMedicine(medicine);
        if (result==0){
            return new RespBean("success","添加成功！");
        }else if(result ==1){
            return new RespBean("error","添加失败，已存在该名称！");
        }else {
            return new RespBean("error","添加失败！");
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public RespBean update(Medicine medicine){
        int result = medicineService.updateMedicine(medicine);
        if (result==0){
            return new RespBean("success","修改成功！");
        }else if(result ==1){
            return new RespBean("error","修改失败，已存在该名称！");
        }else {
            return new RespBean("error","修改失败！");
        }
    }
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Map<String, Object> getMedicineByUser( @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                  @RequestParam(value = "count", defaultValue = "6") Integer count, String keywords) {
        int totalCount = medicineService.getMedicineCountOfUser(Util.getCurrentUser().getId(),keywords);

        List<Medicine> items = medicineService.getMedicinesByUser(Util.getCurrentUser().getId(),page,count,keywords);
        List<RespMedicine> medicines = new ArrayList<>();
        for (Medicine item:items){
            RespMedicine respMedicine = new RespMedicine();
            respMedicine.setMedicine(item);
            respMedicine.setAddTime(Util.sdf.format(item.getAddTime()));
            respMedicine.setmType(mTypeService.getTypeById(item.getTid()));
            medicines.add(respMedicine);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("totalCount", totalCount);
        map.put("medicines", medicines);
        return map;
    }

    @RequestMapping(value = "/getByType", method = RequestMethod.GET)
    public Map<String, Object> getMedicineByType(@RequestParam(value = "tid")Long tid, @RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "count", defaultValue = "10") Integer count, String keywords) {
        int totalCount = medicineService.getMedicineCountOfType(tid,keywords);

        List<Medicine> items = medicineService.getMedicinesByType(tid,page,count,keywords);
        List<RespMedicine> medicines = new ArrayList<>();
        for (Medicine item:items){
            RespMedicine respMedicine = new RespMedicine();
            respMedicine.setMedicine(item);
            respMedicine.setAddTime(Util.sdf.format(item.getAddTime()));
            respMedicine.setmType(mTypeService.getTypeById(item.getTid()));
            medicines.add(respMedicine);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("totalCount", totalCount);
        map.put("medicines", medicines);
        return map;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.PUT)
    public RespBean delete(Long id){
        int result =medicineService.deleteMedicineById(id);
        if (result ==0){
            return new RespBean("success","删除成功！");
        }else{
            return  new RespBean("error","删除失败！");
        }
    }



}
