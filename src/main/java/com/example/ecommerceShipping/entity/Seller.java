package com.example.ecommerceShipping.entity;

import com.example.ecommerceShipping.converter.LocationJsonConverter;
import com.example.ecommerceShipping.converter.QuantityAndDimensionsJsonConverter;
import com.example.ecommerceShipping.model.Location;
import com.example.ecommerceShipping.model.QuantityAndDimensions;
import jakarta.persistence.*;

@Entity
@Table(name = "seller")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "price")
    private float price;
    @Column(name = "attributes", columnDefinition = "json")
    @Convert(converter = QuantityAndDimensionsJsonConverter.class)
    private QuantityAndDimensions attributes;

    @Column(name = "location", columnDefinition = "json")
    @Convert(converter = LocationJsonConverter.class)
    private Location location;
    public Seller(){

    }

    public Seller(String name, String productName, float price, QuantityAndDimensions attributes,Location location) {
        this.name = name;
        this.productName = productName;
        this.price = price;
        this.attributes = attributes;
        this.location=location;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public QuantityAndDimensions getAttributes() {
        return attributes;
    }

    public void setAttributes(QuantityAndDimensions attributes) {
        this.attributes = attributes;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", attributes=" + attributes +
                ", location=" + location +
                '}';
    }
}
