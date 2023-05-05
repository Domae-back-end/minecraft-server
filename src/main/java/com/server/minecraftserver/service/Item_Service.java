package com.server.minecraftserver.service;

import com.server.minecraftserver.model.Item;
import com.server.minecraftserver.model.Item_type;
import com.server.minecraftserver.model.User;
import com.server.minecraftserver.repository.ItemRepository;
import com.server.minecraftserver.repository.Item_typeRepository;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Item_Service {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    Item_typeRepository itemTypeRepository;

    public ArrayList<Item> select_all(){
        return (ArrayList<Item>) itemRepository.findAll();
    }

    public void insert(Item item){
        itemRepository.save(item);
    }

    public void delete(long item_pid){
        itemRepository.deleteById(item_pid);
    }

    public Item findOn(Long item_pid){
        return itemRepository.findById(item_pid).get();
    }

    public ArrayList<Item_type> select_typeAll(){
        return (ArrayList<Item_type>) itemTypeRepository.findAll();
    }

}
