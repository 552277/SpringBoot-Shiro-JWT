package com.example.SpringBootShiro.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhongweichang
 * @email 15090552277@163.com
 * @date 2018/7/25 下午7:04
 */
@Mapper
public interface UserMapper {
    /**
     * 获得密码
     * @param username 用户名
     */
    String getPassword(String username);

    /**
     * 获得角色权限
     * @param username 用户名
     * @return user/admin
     */
    String getRole(String username);
}