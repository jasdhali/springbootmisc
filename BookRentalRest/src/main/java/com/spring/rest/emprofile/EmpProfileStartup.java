package com.spring.rest.emprofile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
//@EnableDiscoveryClient
@SpringBootApplication
public class EmpProfileStartup 
{
    
    public static void main_do_not_use(String[] args) {
        SpringApplication.run(EmpProfileStartup.class, args);
    }
}
