package com.example.pmsserver.controller;

import com.example.pmsserver.bean.MType;
import com.example.pmsserver.bean.RespBean;
import com.example.pmsserver.service.MTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: wanjunyi
 * @Date: 2019/3/12 19:50
 * @Description:
 */
@RestController
@RequestMapping("/type")
public class MTypeController {
    @Autowired
    MTypeService mTypeService;

    @RequestMapping(value = "/add?name={name}",method = RequestMethod.PUT)
    public RespBean addType(@PathVariable("name") String name){
        int result = mTypeService.addType(name);
        if(result==0){
            return new RespBean("success","添加成功！");
        }else if(result == 1){
            return new RespBean("error","失败，该类型名已存在！");
        }else {
            return new RespBean("error","失败！");
        }
    }

//    public List<MType> getTypes()


}
