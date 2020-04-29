package com.bhozida.backend.config.core_controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    //root is now opportunity view
   /* @GetMapping("/")
    public String root() {
        //return "index";
        return "opportunity/list";
    } */

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
 /*
    @GetMapping("/user")
    public String userIndex() {
        //return "user/index";
        return "opportunity/list";
    } */
}