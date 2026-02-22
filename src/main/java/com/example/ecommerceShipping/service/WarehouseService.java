package com.example.ecommerceShipping.service;

import com.example.ecommerceShipping.DAO.WarehouseDao;
import com.example.ecommerceShipping.DAO.SellerDao;
import com.example.ecommerceShipping.entity.Seller;
import com.example.ecommerceShipping.entity.Warehouse;
import com.example.ecommerceShipping.ResponseClasses.NearestWarehouseResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService {

    private WarehouseDao warehouseDao;
    private SellerDao sellerDao;
    private DistanceCalculator distanceCalculator;

    @Autowired
    public WarehouseService(WarehouseDao warehouseDao, SellerDao sellerDao, DistanceCalculator distanceCalculator){
        this.warehouseDao = warehouseDao;
        this.sellerDao=sellerDao;
        this.distanceCalculator = distanceCalculator;
    }

    @Transactional
    @Cacheable(value = "nearestWarehouse", key = "#sellerId")
    public NearestWarehouseResponse getNearestWareHouse(int sellerId){
        List<Warehouse> warehouseList= warehouseDao.getAllWareHouses();
        NearestWarehouseResponse nearestWarehouseResponse =new NearestWarehouseResponse();
        Seller seller=sellerDao.findSellerById(sellerId);
        Double min=Double.MAX_VALUE;
        for(Warehouse warehouse:warehouseList){
            Double distance= distanceCalculator.calculateDistance(seller.getLocation(),warehouse.getLocation());
            if(min>distance){
                min=distance;
                nearestWarehouseResponse.setWarehouseId(warehouse.getId());
                nearestWarehouseResponse.setLocation(warehouse.getLocation());
                nearestWarehouseResponse.setDistance(min);
            }
        }
        return nearestWarehouseResponse;
    }
}