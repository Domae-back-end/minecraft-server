package com.server.minecraftserver.controller;

import com.server.minecraftserver.service.Item_Service;
import com.server.minecraftserver.service.User_Service;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Main_Controller {

    @Autowired
    User_Service userService;
    @Autowired
    Item_Service itemService;

    @RequestMapping("/")
    public String main(HttpServletRequest req, HttpServletResponse res){
        req.setAttribute("page","page/main_page");
        return "index";
    }
    @RequestMapping("/admin/user_list")
    public String main_user(HttpServletRequest req, HttpServletResponse res){
        req.setAttribute("page","page/user_list");
        req.setAttribute("user_list",userService.select_all());
        return "index";
    }

    @RequestMapping("/admin/item_list")
    public String main_item(HttpServletRequest req, HttpServletResponse res){
        req.setAttribute("page","page/item_list");
        req.setAttribute("item_list",itemService.select_all());
        return "index";
    }

    @RequestMapping("/admin/item_create")
    public String item_create(HttpServletRequest req){
        req.setAttribute("page","page/item_create");
        req.setAttribute("item_type",itemService.select_typeAll());
        return "index";
    }

    @RequestMapping("/admin/item_update")
    public String item_update(HttpServletRequest req,
                              @RequestParam String item_pid){
        req.setAttribute("page","page/item_update");
        req.setAttribute("data",itemService.findOn(Long.parseLong(item_pid)));
        req.setAttribute("item_type",itemService.select_typeAll());
        return "index";
    }



}
