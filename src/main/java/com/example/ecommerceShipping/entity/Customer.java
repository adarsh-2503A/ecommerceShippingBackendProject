package com.example.ecommerceShipping.entity;

import com.example.ecommerceShipping.converter.LocationJsonConverter;
import com.example.ecommerceShipping.model.Location;
import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private long phoneNumber;

    @Column(name = "location", columnDefinition = "json")
    @Convert(converter = LocationJsonConverter.class)
    private Location location;

    public Customer(){

    }
    public Customer(String name,long phoneNumber, Location location){
        this.name=name;
        this.phoneNumber=phoneNumber;
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

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", location=" + location +
                '}';
    }
}
