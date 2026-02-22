package com.example.ecommerceShipping.converter;

import com.example.ecommerceShipping.model.QuantityAndDimensions;
import tools.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class QuantityAndDimensionsJsonConverter
        implements AttributeConverter<QuantityAndDimensions, String> {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(QuantityAndDimensions value) {
        if (value == null) return null;

        try {
            return mapper.writeValueAsString(value);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "Error converting QuantityAndDimensions to JSON", e);
        }
    }

    @Override
    public QuantityAndDimensions convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isBlank()) return null;

        try {
            return mapper.readValue(dbData, QuantityAndDimensions.class);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "Error converting JSON to QuantityAndDimensions", e);
        }
    }
}