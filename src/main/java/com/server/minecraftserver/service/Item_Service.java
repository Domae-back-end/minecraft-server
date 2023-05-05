package com.server.minecraftserver.service;

import com.server.minecraftserver.model.Item;
import com.server.minecraftserver.repository.ItemRepository;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Item_Service {

    @Autowired
    ItemRepository itemRepository;

    public ArrayList<Item> select_all(){
        return (ArrayList<Item>) itemRepository.findAll();
    }

}
