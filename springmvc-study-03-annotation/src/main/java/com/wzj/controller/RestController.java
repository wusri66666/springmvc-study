package com.wzj.controller;

import com.wzj.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RestController {
    @RequestMapping(value = "/commit/{p1}/{p2}", method = RequestMethod.POST)
    public String index(@PathVariable int p1, @PathVariable String p2, Model model) {
        String res = p1 + p2;
        model.addAttribute("msg", "结果：" + res);
        return "rest";
    }

//    提交的域名称和处理方法的参数名一致
    @RequestMapping("/hello")
    public String hello(String name){
        System.out.println(name);
        return "hello";
    }

//    提交的域名称和处理方法的参数名不一致
    @RequestMapping("/hello2")
    public String hello2(@RequestParam("username") String name){
        System.out.println(name);
        return "hello";
    }

//    提交的是一个对象
    @RequestMapping("/hello3")
    public String hello3(User user){
        System.out.println(user);
        return "hello";
    }

//    乱码问题
    @RequestMapping("/e/t")
    public String test(Model model, String name){
        model.addAttribute("msg",name);
        return "test";
    }
}
