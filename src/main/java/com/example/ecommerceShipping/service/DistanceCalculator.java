package com.example.ecommerceShipping.service;

import com.example.ecommerceShipping.model.Location;
import org.springframework.stereotype.Component;

@Component
public class DistanceCalculator {
    public Double calculateDistance(Location location1, Location location2){
        double lat1=location1.getLat();
        double lat2=location2.getLat();
        double lon1=location1.getLng();
        double lon2=location2.getLng();

        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return Math.ceil(6371 * c);
    }
}
