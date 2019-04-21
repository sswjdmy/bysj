package com.example.pmsserver.controller;

import com.example.pmsserver.bean.MemberBean;
import com.example.pmsserver.bean.RespBean;
import com.example.pmsserver.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: wanjunyi
 * @Date: 2019/4/8 10:19
 * @Description:
 */
@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberService memberService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Map<String, Object> getAllMember(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "count", defaultValue = "10") int count) {
        int totalCount = memberService.getCountOfUser();
        List<MemberBean> items = new ArrayList<>();
        items.addAll(memberService.getAll(page, count));
        Map<String, Object> map = new HashMap<>();
        map.put("totalCount", totalCount);
        map.put("members", items);
        return map;
    }

    @RequestMapping(value = "/id", method = RequestMethod.PUT)
    public MemberBean getById( Long id) {
        return memberService.getById(id);

    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public RespBean add(MemberBean memberBean){
        int result = memberService.addMember(memberBean);
        if (result==0){
            return new RespBean("error","该号码已注册会员！");
        }else if (result ==1){
            return new RespBean("success","成功！");
        }else {
            return new RespBean("error","失败！");
        }
    }

}
