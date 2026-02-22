package com.example.ecommerceShipping.DAO;

import com.example.ecommerceShipping.entity.Seller;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SellerDaoImpl implements SellerDao{

    private EntityManager entityManager;

    @Autowired
    public SellerDaoImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    public Seller findSellerById(int id) {
        return entityManager.find(Seller.class,id);
    }
}
