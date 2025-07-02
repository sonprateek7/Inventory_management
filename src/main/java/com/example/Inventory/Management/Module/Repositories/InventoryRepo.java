package com.example.Inventory.Management.Module.Repositories;

import com.example.Inventory.Management.Module.Models.InventoryModel;
import com.example.Inventory.Management.Module.Models.ItemsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<InventoryModel, Integer> {
}
