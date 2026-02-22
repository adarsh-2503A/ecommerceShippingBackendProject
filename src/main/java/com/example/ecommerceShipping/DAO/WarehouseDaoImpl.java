package com.example.ecommerceShipping.DAO;

import com.example.ecommerceShipping.entity.Warehouse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WarehouseDaoImpl implements WarehouseDao {
    private EntityManager entityManager;

    @Autowired
    public WarehouseDaoImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    public List<Warehouse> getAllWareHouses() {
        TypedQuery<Warehouse> query= entityManager.createQuery("select w from Warehouse w",Warehouse.class);
        return query.getResultList();
    }

    @Override
    public Warehouse findWarehouseById(int id) {
        return entityManager.find(Warehouse.class,id);
    }
}
