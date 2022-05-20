package com.example.adminpanel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j(topic = "PRODUCT_CONTROLLER")
@SpringBootApplication
public class AdminPanelApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminPanelApplication.class, args);
    }

}
