package com.example.ecommerceShipping.model;

import com.example.ecommerceShipping.model.enums.DeliverySpeed;

public class ShippingChargeForSellerToCustomerBody {
    private int sellerId;
    private int customerId;
    private DeliverySpeed deliverySpeed;

    public ShippingChargeForSellerToCustomerBody(){

    }

    public ShippingChargeForSellerToCustomerBody(int sellerId, int customerId, DeliverySpeed deliverySpeed) {
        this.sellerId = sellerId;
        this.customerId = customerId;
        this.deliverySpeed = deliverySpeed;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public DeliverySpeed getDeliverySpeed() {
        return deliverySpeed;
    }

    public void setDeliverySpeed(DeliverySpeed deliverySpeed) {
        this.deliverySpeed = deliverySpeed;
    }
}
