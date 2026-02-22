package com.example.ecommerceShipping.entity;

import com.example.ecommerceShipping.converter.LocationJsonConverter;
import com.example.ecommerceShipping.model.Location;
import jakarta.persistence.*;

@Entity
@Table(name = "warehouse")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "location", columnDefinition = "json")
    @Convert(converter = LocationJsonConverter.class)
    private Location location;

    public Warehouse(String name, Location location) {
        this.name = name;
        this.location = location;
    }
    public Warehouse(){

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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location=" + location +
                '}';
    }
}
