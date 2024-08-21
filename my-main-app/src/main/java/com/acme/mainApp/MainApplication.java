package com.acme.mainApp;

import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.acme")
public class MainApplication {
    public static void main(String[] args) {
        //MDC.put("application","THCUDDGB01");
        SpringApplication.run(MainApplication.class, args);
    }
}
