package com.example.Inventory.Management.Module.Services;


import com.example.Inventory.Management.Module.Models.InventoryModel;
import com.example.Inventory.Management.Module.Repositories.InventoryRepo;
import com.example.Inventory.Management.Module.Repositories.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    InventoryRepo inventoryRepo;
    @Autowired
    ItemRepo itemRepo;


    public Optional<InventoryModel> getInventoryById(int item_id){
        if(!itemRepo.existsById(item_id))
            return Optional.empty();
       return inventoryRepo.findById(item_id);
    }

    public List<InventoryModel> getFullInventory(){
        return inventoryRepo.findAll();
    }

    public synchronized boolean addSupply(InventoryModel inventoryModel){
        if(!itemRepo.existsById(inventoryModel.getItem_id()))
            return false;
        try {
            inventoryRepo.save(inventoryModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean updateSupply(InventoryModel inventoryModel){
        if(!itemRepo.existsById(inventoryModel.getItem_id()))
            return false;
        inventoryRepo.save(inventoryModel);
        return true;
    }

    public boolean deleteSupply(int item_id){
        if(!itemRepo.existsById(item_id))
            return false;
        inventoryRepo.deleteById(item_id);
        return true;
    }
}
