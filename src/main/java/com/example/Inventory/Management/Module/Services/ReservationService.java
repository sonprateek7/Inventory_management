package com.example.Inventory.Management.Module.Services;

import com.example.Inventory.Management.Module.Models.InventoryModel;
import com.example.Inventory.Management.Module.Models.ItemReservationModel;
import com.example.Inventory.Management.Module.Repositories.InventoryRepo;
import com.example.Inventory.Management.Module.Repositories.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    ReservationRepo reservationRepo;
    @Autowired
    InventoryRepo inventoryRepo;


    @Transactional
    public int addReservation(ItemReservationModel itemReservationModel){
        if(!inventoryRepo.existsById(itemReservationModel.getItem_id())){
            return -1;
        }
        Optional<InventoryModel> inventoryModel=inventoryRepo.findById(itemReservationModel.getItem_id());
        if (inventoryModel.isPresent()&&inventoryModel.get().getItem_available()<itemReservationModel.getReserved_quantity()) {
              return 0;
        }
        reservationRepo.save(itemReservationModel);
        inventoryModel.get().setItem_available(inventoryModel.get().getItem_available()-itemReservationModel.getReserved_quantity());
        inventoryRepo.save(inventoryModel.get());
        return 1;
    }


    public List<ItemReservationModel> getReservation(){
      return reservationRepo.findAll();
    }

    public Optional<ItemReservationModel> getReservationById(int reservation_id){
        return reservationRepo.findById(reservation_id);
    }


    @Transactional
    public int deleteReservation(int reservation_id){
        Optional<ItemReservationModel> itemReservationModel=reservationRepo.findById(reservation_id);
        Optional<InventoryModel> inventoryModel=inventoryRepo.findById(itemReservationModel.get().getItem_id());
        if(!itemReservationModel.isPresent()||!inventoryModel.isPresent())
            return -1;
        inventoryModel.get().setItem_available(inventoryModel.get().getItem_available()+itemReservationModel.get().getReserved_quantity());
        reservationRepo.deleteById(reservation_id);
        inventoryRepo.save(inventoryModel.get());
        return 0;
    }


    @Transactional
    public int updateReservation(ItemReservationModel itemReservationModel,int reserv_id){
       Optional<ItemReservationModel> presentReservation=reservationRepo.findById(reserv_id);
       Optional<InventoryModel> inventoryModel=inventoryRepo.findById(itemReservationModel.getItem_id());
       if(!presentReservation.isPresent())
           return -1;
       int change=presentReservation.get().getReserved_quantity()-itemReservationModel.getReserved_quantity();
       if(!(inventoryModel.get().getItem_available()>change))
           return -2;
       inventoryModel.get().setItem_available(inventoryModel.get().getItem_available()-change);
       inventoryRepo.save(inventoryModel.get());
       reservationRepo.deleteById(reserv_id);
       reservationRepo.save(itemReservationModel);
       return 0;

    }


}
