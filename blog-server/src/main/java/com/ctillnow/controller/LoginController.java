package com.ctillnow.controller;

import com.ctillnow.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by caiping on 2019/12/26.
 */
@RestController
public class LoginController {

    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestBody User user){
        if(user.getUsername().equals("test") && user.getPassword().equals("test"))
            return "登录成功,"+user.toString();
        else
            return "登录失败!";
    }
}
