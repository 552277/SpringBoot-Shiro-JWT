package com.example.SpringBootShiroJWT.controller;

import com.example.SpringBootShiroJWT.mapper.UserMapper;
import com.example.SpringBootShiroJWT.model.ResultMap;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhongweichang
 * @email 15090552277@163.com
 * @date 2018/7/25 下午2:42
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    private final UserMapper userMapper;
    private final ResultMap resultMap;

    @Autowired
    public AdminController(UserMapper userMapper, ResultMap resultMap) {
        this.userMapper = userMapper;
        this.resultMap = resultMap;
    }

    @GetMapping("/getUser")
    @RequiresRoles("admin")
    public ResultMap getUser() {
        List<String> list = userMapper.getUser();
        return resultMap.success().code(200).message(list);
    }

    /**
     * 封号操作
     */
    @PostMapping("/banUser")
    @RequiresRoles("admin")
    public ResultMap updatePassword(String username) {
        userMapper.banUser(username);
        return resultMap.success().code(200).message("成功封号！");
    }
}
