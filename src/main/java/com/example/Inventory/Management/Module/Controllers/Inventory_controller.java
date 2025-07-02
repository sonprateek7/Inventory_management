package com.example.Inventory.Management.Module.Controllers;


import com.example.Inventory.Management.Module.Models.ItemsModel;
import com.example.Inventory.Management.Module.Services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class Inventory_controller {

    @Autowired
    ItemsService itemsService;

    @GetMapping("inventory/item")
    public List<ItemsModel> getAllItems(){
        return itemsService.getAllItems();
    }

    @GetMapping("inventory/item/{item_id}")
    public Optional<ItemsModel> getItemById(@PathVariable int item_id ) throws Exception {
        Optional<ItemsModel> item=itemsService.getItemById(item_id);
        if(item!=null)
            return item;
        else
            throw new Exception("Item Not found with id "+item_id);
    }

    @PostMapping("inventory/item")
    public String AddItem(@RequestBody ItemsModel itemsModel){
        if(itemsService.addItem(itemsModel))
            return "Item Saved Successfully";
        return "Item was not saved in Database";
    }

    @DeleteMapping("inventory/item/{item_id}")
    public String deleteItem(@PathVariable int item_id){
        if(itemsService.deleteItemById(item_id))
            return "Item Successfully deleted";
        return "Something Went Wrong";
    }
}
