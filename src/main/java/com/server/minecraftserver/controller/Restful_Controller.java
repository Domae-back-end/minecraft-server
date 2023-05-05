package com.server.minecraftserver.controller;

import com.server.minecraftserver.model.Item;
import com.server.minecraftserver.model.User;
import com.server.minecraftserver.service.Item_Service;
import com.server.minecraftserver.service.User_Service;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.http.HttpClient;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@RestController
public class Restful_Controller {

    @Autowired
    User_Service userService;
    @Autowired
    Item_Service itemService;

    @RequestMapping(value = "/api/update_money", method = RequestMethod.POST)
    public void update_money(@RequestParam String[] user_money,
                             @RequestParam String[] user_pid,
                             HttpServletRequest req,
                             HttpServletResponse res) throws IOException {
        for (int i = 0; i < user_money.length; i++){
            userService.update_userMoney(user_money[i], user_pid[i]);
        }
        res.sendRedirect("/admin/user_list");
    }

    @RequestMapping(value = "/api/insert_item", method = RequestMethod.POST)
    public void insert_item(@ModelAttribute("item") Item item,
            HttpServletRequest req,
            HttpServletResponse res) throws IOException {
        if(item.getItem_type().equals("null")){
            System.out.println("[!] item_type 선택 안함..");
        }else{
            Date today = new Date();
            SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            item.setItem_createday(date.format(today));
            itemService.insert(item);
        }
        res.sendRedirect("/admin/item_list");
    }

    @RequestMapping(value = "/api/delete_item", method = RequestMethod.POST)
    public void delete_item(String[] delete_items,
                            HttpServletRequest req,
                            HttpServletResponse res) throws IOException {
        for(int i =0; i < delete_items.length; i++){
            itemService.delete(Long.parseLong(delete_items[i]));
        }
        res.sendRedirect("/admin/item_list");
    }

    @RequestMapping(value = "/api/update_item", method = RequestMethod.POST)
    public void update_item(
            @ModelAttribute("item") Item item,
            HttpServletRequest req,
            HttpServletResponse res) throws IOException{

        if(item.getItem_type().equals("null")){
            System.out.println("[!] item_type 선택 안함..");
        }else{
            Date today = new Date();
            SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            item.setItem_fixday(date.format(today));
            itemService.insert(item);
        }

        res.sendRedirect("/admin/item_list");
    }

}
