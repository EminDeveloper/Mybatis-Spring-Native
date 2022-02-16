package com.natives;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MybatisSpringNativeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisSpringNativeApplication.class, args);
    }

    @Bean
    ApplicationRunner runner(CustomerMapper mapper) {
        return args -> {
            var customer = new Customer(1, "JL", "jl@email.com");
            mapper.insert(customer);
            var result = mapper.findById(customer.getId());
            System.out.println("the inserted customer: " + customer);
            System.out.println("the resulting customer: " + result);
        };
    }
}
