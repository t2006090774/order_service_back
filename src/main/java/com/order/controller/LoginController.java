package com.order.controller;

import com.order.bean.JSONResult;
import com.order.bean.Login;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: order-service
 * @description:
 * @author: jax
 * * @create: 2019-08-30 13:30
 **/
@RestController
@RequestMapping("back_api")
public class LoginController {

    @PostMapping(value = "/login")//, produces = "application/json;charset=UTF-8
    public JSONResult login(@RequestBody Login login){
        if(!"admin".equals(login.getUsername())){
            return JSONResult.errorMsg("用户名无效");
        }else if(!"aa123456".equals(login.getPassword())){
            return JSONResult.errorMsg("密码错误");
        }
        return JSONResult.succeed(null,"登录成功！");
    }

}
