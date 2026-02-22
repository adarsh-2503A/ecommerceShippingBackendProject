package com.example.ecommerceShipping.service;

import org.springframework.stereotype.Component;

@Component
public class AeroplaneTransportModeStrategy implements TransportModeStrategy{
    @Override
    public double calculateRate(double distInKM) {
        return distInKM;
    }

    @Override
    public double calculateRateWithWeight(double distInKm, double weightInKg) {
        return distInKm*weightInKg;
    }
}
