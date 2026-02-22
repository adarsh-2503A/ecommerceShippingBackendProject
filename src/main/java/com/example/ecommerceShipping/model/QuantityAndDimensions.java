package com.example.ecommerceShipping.model;

public class QuantityAndDimensions {
    private float weight;
    private String dimensions;

    public QuantityAndDimensions(){

    }

    public QuantityAndDimensions(float weight, String dimensions) {
        this.weight = weight;
        this.dimensions = dimensions;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
}
