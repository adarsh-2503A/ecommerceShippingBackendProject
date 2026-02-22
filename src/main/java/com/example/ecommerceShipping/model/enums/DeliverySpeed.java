package com.example.ecommerceShipping.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DeliverySpeed {
    STANDARD("standard"), EXPRESS("express");
    public final String mode;
    DeliverySpeed(String mode){
        this.mode=mode;
    }

    @JsonValue
    public String getMode() {
        return mode;
    }

    @JsonCreator
    public static DeliverySpeed from(String value) {
        for (DeliverySpeed s : values()) {
            if (s.mode.equalsIgnoreCase(value)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Unsupported delivery speed: " + value);
    }
}
