package com.example.ecommerceShipping.service;

import com.example.ecommerceShipping.DAO.CustomerDao;
import com.example.ecommerceShipping.DAO.SellerDao;
import com.example.ecommerceShipping.DAO.WarehouseDao;
import com.example.ecommerceShipping.ResponseClasses.NearestWarehouseResponse;
import com.example.ecommerceShipping.ResponseClasses.ShippingChargeResponse;
import com.example.ecommerceShipping.ResponseClasses.ShippingChargeSellerToCustomerResponse;
import com.example.ecommerceShipping.entity.Customer;
import com.example.ecommerceShipping.entity.Seller;
import com.example.ecommerceShipping.entity.Warehouse;
import com.example.ecommerceShipping.exceptionHandling.CustomerNotFoundException;
import com.example.ecommerceShipping.exceptionHandling.InvalidShippingRequestException;
import com.example.ecommerceShipping.exceptionHandling.ResourceNotFoundException;
import com.example.ecommerceShipping.exceptionHandling.WarehouseNotFoundException;
import com.example.ecommerceShipping.model.ShippingChargeForSellerToCustomerBody;
import com.example.ecommerceShipping.model.enums.DeliverySpeed;
import com.example.ecommerceShipping.model.enums.TransportMode;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ShippingService {
    private WarehouseDao warehouseDao;
    private CustomerDao customerDao;

    private SellerDao sellerDao;
    private DistanceCalculator distanceCalculator;

    private Map<DeliverySpeed, DeliverySpeedStrategy> deliverySpeedStrategyMap;

    private Map<TransportMode, TransportModeStrategy> transportModeStrategyMap;

    private WarehouseService warehouseService;
    @Autowired
    public ShippingService(WarehouseDao warehouseDao,CustomerDao customerDao,
                           DistanceCalculator distanceCalculator,Map<TransportMode,
                            TransportModeStrategy> transportModeStrategyMap,
                           Map<DeliverySpeed, DeliverySpeedStrategy> deliverySpeedStrategyMap,
                           WarehouseService warehouseService,
                           SellerDao sellerDao){
        this.warehouseDao=warehouseDao;
        this.customerDao=customerDao;
        this.distanceCalculator=distanceCalculator;
        this.deliverySpeedStrategyMap=deliverySpeedStrategyMap;
        this.transportModeStrategyMap=transportModeStrategyMap;
        this.warehouseService=warehouseService;
        this.sellerDao=sellerDao;
    }
    @Transactional
    public ShippingChargeResponse calculateShippingChargeForWarehouseToCustomer(int warehouseId, int customerId, DeliverySpeed deliverySpeed){
        Warehouse warehouse =warehouseDao.findWarehouseById(warehouseId);
        if (warehouse == null)
            throw new WarehouseNotFoundException("Warehouse not found with id: " + warehouseId);
        Customer customer=customerDao.findCustomerById(customerId);
        if (customer == null)
            throw new CustomerNotFoundException("Customer not found with id: " + customerId);
        if (warehouse.getLocation() == null)
            throw new InvalidShippingRequestException("Warehouse location is missing for warehouseId: " + warehouseId);
        if (customer.getLocation() == null)
            throw new InvalidShippingRequestException("Customer location is missing for customerId: " + customerId);
        double distance=distanceCalculator.calculateDistance(warehouse.getLocation(),customer.getLocation());
        double amount=0;
        if(distance>500)
            amount+=transportModeStrategyMap.get(TransportMode.AEROPLANE).calculateRate(distance);
        else if(distance>100)
            amount+=transportModeStrategyMap.get(TransportMode.TRUCK).calculateRate(distance);
        else
            amount+=transportModeStrategyMap.get(TransportMode.MINIVAN).calculateRate(distance);
        DeliverySpeedStrategy speedStrategy = deliverySpeedStrategyMap.get(deliverySpeed);
        if (speedStrategy == null)
            throw new InvalidShippingRequestException("Unsupported delivery speed: " + deliverySpeed);
        amount+=speedStrategy.courierFee();
        ShippingChargeResponse shippingChargeResponse=new ShippingChargeResponse();
        shippingChargeResponse.setShippingCharge(amount);
        return shippingChargeResponse;
    }

    public ShippingChargeSellerToCustomerResponse calculateShippingChargeFromSellerToCustomer(ShippingChargeForSellerToCustomerBody sellerToCustomerBody){
        NearestWarehouseResponse nearestWarehouseResponse=warehouseService.getNearestWareHouse(sellerToCustomerBody.getSellerId());
        if (nearestWarehouseResponse == null)
            throw new ResourceNotFoundException("Nearest warehouse not found for sellerId: " + sellerToCustomerBody.getSellerId());
        Customer customer=customerDao.findCustomerById(sellerToCustomerBody.getCustomerId());
        if (customer == null)
            throw new CustomerNotFoundException("Customer not found with id: " + sellerToCustomerBody.getCustomerId());
        Seller seller=sellerDao.findSellerById(sellerToCustomerBody.getSellerId());
        if (seller == null)
            throw new ResourceNotFoundException("Seller not found with id: " + sellerToCustomerBody.getSellerId());
        float weight=seller.getAttributes().getWeight();
        if (weight <= 0)
            throw new InvalidShippingRequestException("Invalid product weight for sellerId: " + sellerToCustomerBody.getSellerId());
        double distance=distanceCalculator.calculateDistance(nearestWarehouseResponse.getLocation(),customer.getLocation());
        double amount=0;
        if(distance>500)
            amount+=transportModeStrategyMap.get(TransportMode.AEROPLANE).calculateRateWithWeight(distance,weight);
        else if(distance>100)
            amount+=transportModeStrategyMap.get(TransportMode.TRUCK).calculateRateWithWeight(distance,weight);
        else
            amount+=transportModeStrategyMap.get(TransportMode.MINIVAN).calculateRateWithWeight(distance,weight);

        DeliverySpeedStrategy speedStrategy = deliverySpeedStrategyMap.get(sellerToCustomerBody.getDeliverySpeed());
        if (speedStrategy == null)
            throw new InvalidShippingRequestException("Unsupported delivery speed: " + sellerToCustomerBody.getDeliverySpeed());
        amount += speedStrategy.courierFee() + speedStrategy.extraFee(weight);
        return new ShippingChargeSellerToCustomerResponse(amount, nearestWarehouseResponse);
    }
}
