package com.example.ecommerceShipping.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TransportMode {
    AEROPLANE("aeroplane"),TRUCK("truck"),MINIVAN("minivan");
    private String mode;
    TransportMode(String mode){
        this.mode=mode;
    }

    @JsonValue
    public String getMode() {
        return mode;
    }

    @JsonCreator
    public static TransportMode from(String value) {
        for (TransportMode t : values()) {
            if (t.mode.equalsIgnoreCase(value)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unsupported delivery speed: " + value);
    }
}
