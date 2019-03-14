package com.example.pmsserver.controller;

import com.example.pmsserver.bean.RespBean;
import com.example.pmsserver.bean.User;
import com.example.pmsserver.service.UserService;
import com.example.pmsserver.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: wanjunyi
 * @Date: 2019/2/11 11:03
 * @Description:
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;


    @RequestMapping("/currentUserName")
    public String currentUserName() {
        return Util.getCurrentUser().getUsername();
    }

    @RequestMapping(value = "/getUserById/uid={id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        return user;
    }

    @RequestMapping(value = "/getUserByPhone/phone={phone}", method = RequestMethod.GET)
    public User getUserByPhone(@PathVariable("phone") String phone) {
        User user = userService.getUserByPhone(phone);
        return user;
    }

    @RequestMapping(value = "/updateUserName/uid={id}&username={name}", method = RequestMethod.GET)
    public void updateUserName(@PathVariable("id") Long id, @PathVariable("name") String name) {
        int result = userService.updateUserName(id, name);
        switch (result) {
            case 0:
                new RespBean("success", "修改成功！");
                break;
            case 1:
                new RespBean("error", "修改失败，该名字已被使用!");
                break;
            case 2:
                new RespBean("error", "修改失败！");
                break;
            default:
                new RespBean("error", "修改失败！");
        }
    }

    @RequestMapping(value = "/updatePwd", method = RequestMethod.PUT)
    public void updatePassword(User user) {
        int result = userService.updatePassword(user.getId(), user.getPassword(), user.getPhone());
        switch (result) {
            case 0:
                new RespBean("success", "修改成功！");
                break;
            case 1:
                new RespBean("error", "修改失败，该手机号已被使用!");
                break;
            case 2:
                new RespBean("error", "修改失败！");
                break;
            default:
                new RespBean("error", "修改失败！");
        }
    }

    @RequestMapping(value = "/updatePhone", method = RequestMethod.GET)
    public RespBean updateUserPhone(@PathVariable String phone) {
        if (userService.updateUserPhone(phone) == 1) {
            return new RespBean("success", "修改成功!");
        } else {
            return new RespBean("error", "修改失败！");
        }
    }


}
