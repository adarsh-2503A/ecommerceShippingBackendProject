package com.example.ecommerceShipping.model.enums;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToDeliverySpeedConverter
        implements Converter<String, DeliverySpeed> {

    @Override
    public DeliverySpeed convert(String source) {
        return DeliverySpeed.from(source);
    }
}