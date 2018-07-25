package com.example.SpringBootShiroJWT.controller;

import com.example.SpringBootShiroJWT.model.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhongweichang
 * @email 15090552277@163.com
 * @date 2018/7/25 下午2:44
 */
@RestController
@RequestMapping("/guest")
public class GuestController {
    private final ResultMap resultMap;

    @Autowired
    public GuestController(ResultMap resultMap) {
        this.resultMap = resultMap;
    }

    @GetMapping("/welcome")
    public ResultMap login() {
        return resultMap.success().code(200).message("欢迎访问游客页面！");
    }
}
