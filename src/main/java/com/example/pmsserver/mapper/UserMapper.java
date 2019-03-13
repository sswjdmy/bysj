package com.example.pmsserver.mapper;

import com.example.pmsserver.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Auther: wanjunyi
 * @Date: 2019/2/11 10:11
 * @Description:
 */
@Mapper
public interface UserMapper {
    int reg(User user);
    User getUserById(@Param("id")Long id);
    User getUserByPhone(@Param("phone") String phone);
    int updateUserName(@Param("id") Long id,@Param("name") String name);
    int updatePassword(@Param("id") Long id,@Param("password") String password);
    int updateUserPhone(@Param("id") Long id,@Param("phone") String phone);
//    int deleteUserById(@Param("id") Long id);
    User loadUserByUsername(@Param("username") String username);
}
