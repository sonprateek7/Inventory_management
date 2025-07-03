package com.example.Inventory.Management.Module.Controllers;


import com.example.Inventory.Management.Module.Models.InventoryModel;
import com.example.Inventory.Management.Module.Services.InventoryService;
import com.example.Inventory.Management.Module.Services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class Supply_controller {

    @Autowired
    ItemsService itemsService;
    @Autowired
    InventoryService inventoryService;


    @GetMapping("item/{item_id}/supply")
    public Optional<InventoryModel> getSupplyById(@PathVariable int item_id){
        return inventoryService.getInventoryById(item_id);
    }

    @GetMapping("items/supply")
    public List<InventoryModel> getFullSupply(){
        return inventoryService.getFullInventory();
    }

    @PostMapping("item/supply")
    public boolean addSupply(@RequestBody InventoryModel supply){
        return inventoryService.addSupply(supply);
    }

    @DeleteMapping("item/{item_id}/supply")
    public boolean deleteSupply(@PathVariable int item_id){
        return inventoryService.deleteSupply(item_id);
    }
}
