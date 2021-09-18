package com.jiwei.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ShareDataTestController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request) {
        request.setAttribute("testScope", "hell,servletAPI");
        return  "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){

        ModelAndView mv = new ModelAndView();
        mv.addObject("testScope", "hello, model and view");
        mv.setViewName("success");

        return mv;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("testScope", "hello, test model");
        return "success";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map){
        map.put("testScope", "hell,  map");
        return "success";
    }

    @RequestMapping("/testMpdelMap")
    public String testModelMap(ModelMap model){
        model.addAttribute("testScope", "hello, ModelMap");
        return "success";
    }

    @RequestMapping("/testSession")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope", "hello, session");
        return "success";
    }

    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session){
        ServletContext context = session.getServletContext();
        context.setAttribute("testAppScope", "hello, application");
        return "success";
    }

}
