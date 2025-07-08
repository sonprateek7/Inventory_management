package com.example.Inventory.Management.Module.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class InventoryModel {

    @Id
//    @ManyToOne
//    @JoinColumn(name = "item_id")
    private int item_id;
    private int item_stock;
    private int  item_available;
    //private LocalDateTime updatedAt = LocalDateTime.now();


    //private ItemsModel item;

}