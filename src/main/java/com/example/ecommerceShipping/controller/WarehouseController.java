package com.example.ecommerceShipping.controller;

import com.example.ecommerceShipping.ResponseClasses.NearestWarehouseResponse;
import com.example.ecommerceShipping.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class WarehouseController {
    private WarehouseService warehouseService;
    @Autowired
    public WarehouseController(WarehouseService warehouseService){
        this.warehouseService = warehouseService;
    }
    @GetMapping("warehouse/nearest")
    public NearestWarehouseResponse getNearestWareHouse(@RequestParam("sellerId") int sellerId,
                                                        @RequestParam("productId") int productId){
        return warehouseService.getNearestWareHouse(sellerId);
    }
}
