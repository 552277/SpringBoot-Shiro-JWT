package com.example.SpringBootShiro.controller;

import com.example.SpringBootShiro.model.ResultMap;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 异常处理 controller
 * @Date 2018-05-02
 * @Time 20:40
 */
@RestControllerAdvice
public class ExceptionController {
    private final ResultMap resultMap;

    @Autowired
    public ExceptionController(ResultMap resultMap) {
        this.resultMap = resultMap;
    }

    /**
     * 捕捉 CustomRealm 抛出的异常
     */
    @ExceptionHandler(AccountException.class)
    public ResultMap handleShiroException(Exception ex) {
        return resultMap.fail().message(ex.getMessage());
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResultMap handShiroUnauthorizedException(Exception ex) {
        return resultMap.fail().message(ex.getMessage());
    }
}
