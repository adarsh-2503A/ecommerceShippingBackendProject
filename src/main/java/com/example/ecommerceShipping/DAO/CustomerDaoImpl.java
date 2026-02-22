package com.example.ecommerceShipping.DAO;

import com.example.ecommerceShipping.entity.Customer;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl implements CustomerDao{
    private EntityManager entityManager;

    @Autowired
    public CustomerDaoImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    public Customer findCustomerById(int id) {
        return entityManager.find(Customer.class,id);
    }
}
