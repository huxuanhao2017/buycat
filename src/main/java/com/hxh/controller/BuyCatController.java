package com.hxh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by huxuanhao on 2017-05-20.
 */
@Controller
public class BuyCatController {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(int n, String j) {
        // output : str having value ? false
        return n + "hello 你好" + j;
    }
    @RequestMapping("/helloTest")
    public String testHello(Model model) {
        model.addAttribute("helloHxh", "你好");
        System.out.println("成功");
        return "hello";
    }
}
