package com.example.pmsserver.controller;

import com.example.pmsserver.bean.MType;
import com.example.pmsserver.bean.RespBean;
import com.example.pmsserver.service.MTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public RespBean addType(String name) {
        int result = mTypeService.addType(name);
        if (result == 0) {
            return new RespBean("success", "添加成功！");
        } else if (result == 1) {
            return new RespBean("error", "失败，该类型名已存在！");
        } else {
            return new RespBean("error", "失败！");
        }
    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public Map<String, List<MType>> getList() {
        Map<String, List<MType>> map = new HashMap<>();
        List<MType> list = mTypeService.getTypes();
        map.put("types", list);
        return map;
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public RespBean update(Long id, String name) {
        int result = mTypeService.updateName(id, name);
        if (result == 0) {
            return new RespBean("success", "修改成功！");
        } else if (result == 1) {
            return new RespBean("error", "修改失败！该类型已存在");
        } else {
            return new RespBean("error", "修改失败！");
        }
    }

    @RequestMapping(value = "delete", method = RequestMethod.PUT)
    public RespBean delete(Long id) {
        int result = mTypeService.deleteType(id);
        if ( result== 0) {
            return new RespBean("success", "删除成功！");
        } else if (result==1){
            return new RespBean("error", "删除失败！该类型下还有元素");
        }else {
            return new RespBean("error", "删除失败！");
        }
    }


//    public List<MType> getTypes()


}
