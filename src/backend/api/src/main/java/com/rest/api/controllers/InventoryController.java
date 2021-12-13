package com.rest.api.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.rest.api.models.InventoryModel;
import com.rest.api.services.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    InventoryService inventoryService;
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping()
    public ArrayList<InventoryModel> getInventory() {
        return inventoryService.getInventory();
    }

    @PostMapping
    public InventoryModel saveInventoryProduct(@RequestBody InventoryModel inventoryProduct) {
        return this.inventoryService.saveInventoryProduct(inventoryProduct);
    }

    @GetMapping(path = "/{id}")
    public Optional<InventoryModel> findInventoryProductById(@PathVariable("id") Integer id) {
        return this.inventoryService.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        boolean deletedInventoryProduct = this.inventoryService.deleteInventoryproduct(id);
        if (deletedInventoryProduct) {
            return String.format("Product with id %s has been deleted from the inventory DB.", id);
        } else {
            return String.format("Product with id %s could NOT be deleted from the inventory DB.", id);
        }
    }
}
