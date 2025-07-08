package com.example.Inventory.Management.Module.Repositories;

import com.example.Inventory.Management.Module.Models.ItemReservationModel;
import com.example.Inventory.Management.Module.Models.ItemsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepo extends JpaRepository<ItemReservationModel, Integer> {
}
