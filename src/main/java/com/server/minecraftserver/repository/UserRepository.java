package com.server.minecraftserver.repository;

import com.server.minecraftserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}