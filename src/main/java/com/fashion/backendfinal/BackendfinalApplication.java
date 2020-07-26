package com.fashion.backendfinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class BackendfinalApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendfinalApplication.class, args);


    }


}
