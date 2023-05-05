package com.server.minecraftserver.repository;

import com.server.minecraftserver.model.Item_type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Item_typeRepository extends JpaRepository<Item_type, Long> {
}