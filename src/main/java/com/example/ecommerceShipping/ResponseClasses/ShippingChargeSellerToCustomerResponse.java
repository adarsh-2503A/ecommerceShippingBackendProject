package com.example.ecommerceShipping.ResponseClasses;

public class ShippingChargeSellerToCustomerResponse {
    private double shippingCharge;
    protected NearestWarehouseResponse nearestWarehouse;
    public ShippingChargeSellerToCustomerResponse(){

    }

    public ShippingChargeSellerToCustomerResponse(double shippingCharge, NearestWarehouseResponse nearestWarehouse) {
        this.shippingCharge = shippingCharge;
        this.nearestWarehouse = nearestWarehouse;
    }

    public double getShippingCharge() {
        return shippingCharge;
    }

    public void setShippingCharge(double shippingCharge) {
        this.shippingCharge = shippingCharge;
    }

    public NearestWarehouseResponse getNearestWarehouse() {
        return nearestWarehouse;
    }

    public void setNearestWarehouse(NearestWarehouseResponse nearestWarehouse) {
        this.nearestWarehouse = nearestWarehouse;
    }
}
