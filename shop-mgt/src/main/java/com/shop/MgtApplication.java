package com.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created By Lizhengyuan on 18-10-24
 */
@SpringBootApplication
@EnableAutoConfiguration
public class MgtApplication {

    public static void main(String[] args) {
        SpringApplication.run(MgtApplication.class, args);
    }

}
