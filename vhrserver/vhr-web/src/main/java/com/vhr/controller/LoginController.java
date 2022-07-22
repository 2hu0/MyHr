package com.vhr.controller;

import com.vhr.model.bean.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping("/login")
//    @CrossOrigin("*")
    public RespBean login() {
        return RespBean.error("尚未登陆，请登录");
    }
}
