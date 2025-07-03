package com.example.Inventory.Management.Module.Services;

import com.example.Inventory.Management.Module.Models.ItemsModel;
import com.example.Inventory.Management.Module.Repositories.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemsService {

    @Autowired
    ItemRepo itemRepo;


    public boolean addItem(ItemsModel itemsModel){
        if(!itemRepo.existsById(itemsModel.getItem_id())) {
            itemRepo.save(itemsModel);
            return true;
        }
        return false;
    }

    public List<ItemsModel> getAllItems(){
        return itemRepo.findAll();
    }

    public Optional<ItemsModel> getItemById(int item_id){
        return itemRepo.findById(item_id);
    }

    public boolean deleteItemById(int item_id){
        if(itemRepo.existsById(item_id)){
             itemRepo.deleteById(item_id);
             return true;
        }
        return false;
    }
}
