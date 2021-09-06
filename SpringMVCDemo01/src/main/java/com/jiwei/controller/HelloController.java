package com.jiwei.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 你好控制器
 *
 * @author guagua
 * @date 2021/09/03
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public String sayHello(){
        return "index";
    }

    @RequestMapping("/target")
    public String toTarget() {
        return "target";
    }
}
