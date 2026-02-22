package com.example.ecommerceShipping.service;

public interface DeliverySpeedStrategy {
    double courierFee();
    double extraFee(double weightKg);
}
