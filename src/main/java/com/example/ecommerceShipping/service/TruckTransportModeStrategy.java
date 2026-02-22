package com.example.ecommerceShipping.service;

import org.springframework.stereotype.Component;

@Component
public class TruckTransportModeStrategy implements TransportModeStrategy{
    @Override
    public double calculateRate(double distInKM) {
        return distInKM*2;
    }

    @Override
    public double calculateRateWithWeight(double distInKm, double weightInKg) {
        return 2*distInKm*weightInKg;
    }
}
