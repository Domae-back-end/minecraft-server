package com.server.minecraftserver.repository;

import com.server.minecraftserver.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}