package com.wzj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InterceptorController {
    @RequestMapping("/interceptor")
    @ResponseBody
    public String testFunction(){
        System.out.println("控制器中方法执行");
        return "hello";
    }
}
