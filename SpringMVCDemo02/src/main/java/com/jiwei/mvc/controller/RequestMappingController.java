package com.jiwei.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/hello")
public class RequestMappingController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }


    @RequestMapping(value = {"/first", "/second"} , method = RequestMethod.PUT)
    public String action() {
        return "success";
    }


    @RequestMapping(value = {"/testparamsAndHeaders" },
            params = {"!username" },
            headers = {"auth" , "!stoken"}
    )
    public String testParamsAndHeaders(){
        return "success";
    }


    /**
     * 支持ant表达式
     * 注意 ** 必须添加类的和path
     */
    @RequestMapping(value = {"/a?", "/b*", "/**/cbb" })
    public String testAnt(){
        return "success";
    }

    @RequestMapping(value = {"/qwe/{user}/{pwd}" })
    public String testRest(@PathVariable("user") String user, @PathVariable("pwd")String pwd){
        System.out.println(user + pwd);
        return "success";
    }

    /**
     * Rest支持map
     * @param user
     * @return
     */
    @RequestMapping(value = {"/map/{user}/{pwd}/{gaga}/{zz}" })
    public String testRestMap(@PathVariable()Map user){
        System.out.println(user.toString());
        return "success";
    }


}
