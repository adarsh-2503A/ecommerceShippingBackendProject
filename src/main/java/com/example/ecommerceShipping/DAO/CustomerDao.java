package com.example.ecommerceShipping.DAO;

import com.example.ecommerceShipping.entity.Customer;

public interface CustomerDao {
    Customer findCustomerById(int id);
}
