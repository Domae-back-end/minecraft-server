package com.server.minecraftserver.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "item_list")
public class Item {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long item_pid;

    @Column
    private String item_name;
    @Column
    private String item_info;
    @Column
    private String item_type;
    @Column
    private String item_make;
    @Column
    private String item_createday;
    @Column
    private String item_fixday;

}
