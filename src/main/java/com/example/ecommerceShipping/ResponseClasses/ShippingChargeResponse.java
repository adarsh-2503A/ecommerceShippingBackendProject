package com.example.ecommerceShipping.ResponseClasses;

public class ShippingChargeResponse {
    private double shippingCharge;
    public ShippingChargeResponse(){}
    public ShippingChargeResponse(double shippingCharge){
        this.shippingCharge=shippingCharge;
    }

    public double getShippingCharge() {
        return shippingCharge;
    }

    public void setShippingCharge(double shippingCharge) {
        this.shippingCharge = shippingCharge;
    }
}
