package com.example.ecommerceShipping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EcommerceShippingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceShippingApplication.class, args);
	}

}
