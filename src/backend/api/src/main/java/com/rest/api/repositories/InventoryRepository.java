package com.rest.api.repositories;

import java.util.ArrayList;

import com.rest.api.models.InventoryModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends CrudRepository<InventoryModel, Integer> {
    public abstract ArrayList<InventoryModel> findByID(Integer id);
}
