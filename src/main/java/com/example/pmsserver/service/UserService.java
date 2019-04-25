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
     * 先判断新的用户名是否已经存在，只有新用户名不存在时才会操作成功
     * @param username
     * @return 0表示成功
     * 1表示用户名重复
     * 2表示失败
     */
    public int updateUserName( String username) {
        if (userMapper.loadUserByUsername(username) != null) {
            return 1;
        } else {
            int result = userMapper.updateUserName(Util.getCurrentUser().getId(), username);
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
     * @return
     */
    public int updatePassword(Long id, String password) {
           return userMapper.updatePassword(id, DigestUtils.md5DigestAsHex(password.getBytes())) ;
    }

    public int updateUserPhone(String phone) {
        Long id = Util.getCurrentUser().getId();
        return userMapper.updateUserPhone(id, phone);
    }


}
