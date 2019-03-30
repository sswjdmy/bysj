package com.example.pmsserver.utils;

import com.example.pmsserver.bean.User;
import org.springframework.security.core.context.SecurityContextHolder;

import java.text.SimpleDateFormat;


/**
 * @Auther: wanjunyi
 * @Date: 2019/2/11 11:06
 * @Description:
 */
//public class Util {
//    public static User getCurrentUser(){
//        User user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        return user;
//    }
//}
public class Util {

    private Util(){
        throw new AssertionError();
    }

    public static User getCurrentUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }
    public static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}