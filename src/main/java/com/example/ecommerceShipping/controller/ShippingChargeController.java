package com.example.ecommerceShipping.controller;

import com.example.ecommerceShipping.ResponseClasses.ShippingChargeResponse;
import com.example.ecommerceShipping.ResponseClasses.ShippingChargeSellerToCustomerResponse;
import com.example.ecommerceShipping.model.ShippingChargeForSellerToCustomerBody;
import com.example.ecommerceShipping.model.enums.DeliverySpeed;
import com.example.ecommerceShipping.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/shipping-charge")
public class ShippingChargeController {
    private ShippingService shippingService;
    @Autowired
    public ShippingChargeController(ShippingService shippingService){
        this.shippingService=shippingService;
    }
    @GetMapping()
    public ShippingChargeResponse getShippingCharge(@RequestParam("warehouseId") int warehouseId, @RequestParam("customerId") int customerId, @RequestParam("deliverySpeed") DeliverySpeed deliverySpeed){
        return shippingService.calculateShippingChargeForWarehouseToCustomer(warehouseId,customerId,deliverySpeed);
    }

    @PostMapping("/calculate")
    public ShippingChargeSellerToCustomerResponse getShippingChargeForSellerToCustomer(@RequestBody ShippingChargeForSellerToCustomerBody sellerToCustomerBody){
        return shippingService.calculateShippingChargeFromSellerToCustomer(sellerToCustomerBody);
    }
}
