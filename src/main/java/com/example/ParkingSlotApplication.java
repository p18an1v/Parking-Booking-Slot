package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.controller","com.example.model","com.example.service"})
public class ParkingSlotApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkingSlotApplication.class, args);
        System.out.println("Application started");
    }
}
