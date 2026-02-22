package com.example.ecommerceShipping.config;

import com.example.ecommerceShipping.model.enums.DeliverySpeed;
import com.example.ecommerceShipping.service.DeliverySpeedStrategy;
import com.example.ecommerceShipping.service.ExpressDeliverySpeedStrategy;
import com.example.ecommerceShipping.service.StandardDeliverySpeedStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class DeliverySpeedConfig {
    @Bean
    public Map<DeliverySpeed, DeliverySpeedStrategy> deliveryStrategyMap(
            StandardDeliverySpeedStrategy std,
            ExpressDeliverySpeedStrategy exp) {

        return Map.of(
                DeliverySpeed.STANDARD, std,
                DeliverySpeed.EXPRESS, exp
        );
    }
}
