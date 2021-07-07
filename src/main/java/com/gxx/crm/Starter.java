package com.gxx.crm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("com.gxx.crm.dao")
public class Starter {
    public static void main( String[] args ) {
        SpringApplication.run(Starter.class);
    }
}
