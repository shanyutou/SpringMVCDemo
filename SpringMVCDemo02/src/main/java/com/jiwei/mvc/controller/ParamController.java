package com.jiwei.mvc.controller;

import com.jiwei.mvc.bin.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Array;
import java.util.Arrays;

@Controller
@RequestMapping("/param")
public class ParamController {

    @RequestMapping("/")
    public String index() {
        return "test_param";
    }


    @RequestMapping("/testServletApi")
    public String testServletApi(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        System.out.println(httpServletRequest.getParameterMap());
        return "success";
    }


    @RequestMapping("/testSpringApi")
    public String testSpringApi(String user, String pwd) {
        System.out.println(user + pwd);
        return "success";
    }

    @RequestMapping("/testSpringApiForm")
    public String testSpringApiForm(@RequestParam(value = "user") String user, String pwd, @RequestParam(value = "age_values", required = false, defaultValue = "hehe") String ageS, String[] gender) {
        System.out.println(user + pwd + ageS + Arrays.toString(gender));
        return "success";

    }

    @RequestMapping("/tesetBean")
    public String testBean(User user){
        System.out.println(user.toString());
        return "success";
    }

}


