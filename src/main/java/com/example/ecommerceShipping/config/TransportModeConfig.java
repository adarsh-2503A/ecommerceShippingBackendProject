package com.example.ecommerceShipping.config;

import com.example.ecommerceShipping.model.enums.TransportMode;
import com.example.ecommerceShipping.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class TransportModeConfig {
    @Bean
    public Map<TransportMode, TransportModeStrategy> transportModeStrategyMap(
            AeroplaneTransportModeStrategy ats,
            TruckTransportModeStrategy tts,
            MinivanTransportModeStrategy mts) {

        return Map.of(
                TransportMode.AEROPLANE, ats,
                TransportMode.TRUCK, tts,
                TransportMode.MINIVAN, mts
        );
    }
}
