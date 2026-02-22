package com.example.ecommerceShipping.ResponseClasses;

import com.example.ecommerceShipping.model.Location;

public class NearestWarehouseResponse {
    private int warehouseId;
    private Location location;

    private Double distance;
    public NearestWarehouseResponse(){

    }
    public NearestWarehouseResponse(int warehouseId, Location location,Double distance){
        this.warehouseId=warehouseId;
        this.location=location;
        this.distance=distance;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}
