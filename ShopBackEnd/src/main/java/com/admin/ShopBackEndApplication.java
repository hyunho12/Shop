package com.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.common.entity"})
public class ShopBackEndApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopBackEndApplication.class, args);
    }
}
