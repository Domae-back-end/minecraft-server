package com.server.minecraftserver.service;

import com.server.minecraftserver.model.User;
import com.server.minecraftserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class User_Service {

    @Autowired
    UserRepository userRepository;

    public ArrayList<User> select_all(){
        return (ArrayList<User>) userRepository.findAll();
    }

    public void update_userMoney(String user_money, String user_pid){
        User findUser = userRepository.findById(Long.parseLong(user_pid)).get();
        findUser.setUser_money(Integer.parseInt(user_money));
        userRepository.save(findUser);
    }

}
