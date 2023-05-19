package com.server.minecraftserver.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Chat_Controller {

    @RequestMapping("/apis/login")
    public String login_api(HttpServletRequest req){
        return "chat/chatting";
    }

}
