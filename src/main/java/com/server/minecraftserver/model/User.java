package com.server.minecraftserver.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_pid;

    @Column
    private String user_name;
    @Column
    private String user_uuid;
    @Column
    private int user_money;
    @Column
    private String user_createday;
    @Column
    private String user_leaveday;

}
