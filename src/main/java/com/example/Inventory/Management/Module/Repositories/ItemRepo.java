package com.example.Inventory.Management.Module.Repositories;

import com.example.Inventory.Management.Module.Models.ItemsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepo extends JpaRepository<ItemsModel, Integer> {

}
