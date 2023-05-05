package com.server.minecraftserver.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "item_type")
public class Item_type {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long type_pid;

    @Column
    private String type_name;

}
