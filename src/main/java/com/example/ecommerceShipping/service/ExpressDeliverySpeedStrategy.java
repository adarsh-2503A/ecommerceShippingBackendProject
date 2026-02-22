package com.example.ecommerceShipping.service;

import org.springframework.stereotype.Component;

@Component
public class ExpressDeliverySpeedStrategy implements DeliverySpeedStrategy{
    @Override
    public double courierFee() {
        return 10.0;
    }

    @Override
    public double extraFee(double weightKg) {
        return 1.2*weightKg;
    }
}
