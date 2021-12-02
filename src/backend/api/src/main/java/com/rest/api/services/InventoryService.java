package com.rest.api.services;

import java.util.ArrayList;
import java.util.Optional;

import com.rest.api.models.InventoryModel;
import com.rest.api.repositories.InventoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;

    public ArrayList<InventoryModel> getInventory() {
        return (ArrayList<InventoryModel>) inventoryRepository.findAll();
    }

    public InventoryModel saveInventoryProduct(InventoryModel inventoryProduct) {
        return inventoryRepository.save(inventoryProduct);
    }

    public Optional<InventoryModel> findById(Integer id) {
        return inventoryRepository.findById(id);
    }
    
    public boolean deleteInventoryproduct(Integer id) {
        try {
            inventoryRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
