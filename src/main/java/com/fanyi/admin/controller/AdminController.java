package com.fanyi.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin")
    public String listUsers(Model model) {
        model.addAttribute("title","首页");
        return "admin/index";
    }
}
