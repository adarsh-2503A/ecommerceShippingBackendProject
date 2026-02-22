package com.example.ecommerceShipping.service;

public interface TransportModeStrategy {
    double calculateRate(double distInKM);

    double calculateRateWithWeight(double distInKm,double weightInKg);
}
