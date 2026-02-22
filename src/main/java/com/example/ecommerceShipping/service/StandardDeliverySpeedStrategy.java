package com.example.ecommerceShipping.service;

import org.springframework.stereotype.Component;

@Component
public class StandardDeliverySpeedStrategy implements DeliverySpeedStrategy{
    @Override
    public double courierFee() {
        return 10.0;
    }
    @Override
    public double extraFee(double weightKg) {
        return 0.0;
    }
}
