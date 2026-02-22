package com.example.ecommerceShipping.DAO;

import com.example.ecommerceShipping.entity.Warehouse;

import java.util.List;

public interface WarehouseDao {
    List<Warehouse> getAllWareHouses();

    Warehouse findWarehouseById(int id);
}
