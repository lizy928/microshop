package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created By Lizhengyuan on 18-10-26
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public Object test(Model model){
        model.addAttribute("sfesf",123);
        return "index";
    }

}
