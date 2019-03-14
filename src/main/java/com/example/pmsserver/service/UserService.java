package com.example.pmsserver.service;

import com.example.pmsserver.bean.User;
import com.example.pmsserver.mapper.UserMapper;
import com.example.pmsserver.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.List;

/**
 * @Auther: wanjunyi
 * @Date: 2019/2/11 10:48
 * @Description:
 */
@Transactional
@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUsername(s);
        if (user == null) {
            return new User();
        }
        return user;
    }

    /**
     * @param user
     * @return 0表示成功
     * 1表示用户名重复
     * 2表示手机号已被使用
     * 3表示失败
     */
    public int reg(User user) {
        User getUserByUserName = userMapper.loadUserByUsername(user.getUsername());
        if (getUserByUserName != null) {
            return 1;
        } else if (getUserByPhone(user.getPhone()) != null) {
            return 2;
        }
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        long result = userMapper.reg(user);
        if (result == 1) {
            return 0;
        } else {
            return 3;
        }

    }

    public User getUserById(Long id) {
        User user = userMapper.getUserById(id);
        return user;
    }

    public User getUserByPhone(String phone) {
        User user = userMapper.getUserByPhone(phone);
        return user;
    }

    /**
     * @param id,username
     * @return 0表示成功
     * 1表示用户名重复
     * 2表示失败
     */
    public int updateUserName(Long id, String username) {
        if (userMapper.loadUserByUsername(username) != null) {
            return 1;
        } else {
            int result = userMapper.updateUserName(id, username);
            if (result == 1) {
                return 0;
            } else {
                return 2;
            }
        }
    }

    /**
     * @param id
     * @param password
     * @param phone
     * @return 0 ：成功
     * 1：失败、手机号不正确
     * 2：失败
     */
    public int updatePassword(Long id, String password, String phone) {
        int result;
        if (!Util.getCurrentUser().getPhone().equals(phone)) {
            return 1;
        } else {
            if (userMapper.updatePassword(id, DigestUtils.md5DigestAsHex(password.getBytes())) == 1) {
                result = 0;
            } else {
                result = 2;
            }
            return result;
        }
    }

    public int updateUserPhone(String phone) {
        Long id = Util.getCurrentUser().getId();
        return userMapper.updateUserPhone(id, phone);
    }


}
