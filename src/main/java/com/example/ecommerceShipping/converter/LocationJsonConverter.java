package com.example.ecommerceShipping.converter;

import com.example.ecommerceShipping.model.Location;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import tools.jackson.databind.ObjectMapper;

@Converter(autoApply = false)
public class LocationJsonConverter
        implements AttributeConverter<Location, String> {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Location location) {
        try {
            return mapper.writeValueAsString(location);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error converting Location to JSON", e);
        }
    }

    @Override
    public Location convertToEntityAttribute(String dbData) {
        try {
            return mapper.readValue(dbData, Location.class);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error converting JSON to Location", e);
        }
    }
}
