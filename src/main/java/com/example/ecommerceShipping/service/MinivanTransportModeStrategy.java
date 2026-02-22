package com.example.ecommerceShipping.service;

import org.springframework.stereotype.Component;

@Component
public class MinivanTransportModeStrategy implements TransportModeStrategy{
    @Override
    public double calculateRate(double distInKM) {
        return distInKM*3;
    }

    @Override
    public double calculateRateWithWeight(double distInKm, double weightInKg) {
        return 3*distInKm*weightInKg;
    }
}
