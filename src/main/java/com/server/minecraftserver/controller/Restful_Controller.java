package com.server.minecraftserver.controller;

import com.server.minecraftserver.service.User_Service;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.Arrays;

@RestController
public class Restful_Controller {

    @Autowired
    User_Service userService;

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

}
