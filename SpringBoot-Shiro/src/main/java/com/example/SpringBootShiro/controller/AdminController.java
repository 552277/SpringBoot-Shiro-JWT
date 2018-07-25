package com.example.SpringBootShiro.controller;

import com.example.SpringBootShiro.model.ResultMap;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 权限：管理员
 * @Date 2018-04-06
 * @Time 20:31
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    private final ResultMap resultMap;

    @Autowired
    public AdminController(ResultMap resultMap) {
        this.resultMap = resultMap;
    }

    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    @RequiresRoles(value = "admin")
    public ResultMap getMessage() {
//        Subject subject= SecurityUtils.getSubject();
//        try {
//            subject.checkPermissions("add","update");
//        }catch (UnauthorizedException e){
//            System.out.println("..............................");
//            return resultMap.fail();
//        }

        return resultMap.success().message("您拥有管理员权限，可以获得该接口的信息！");
    }
}
