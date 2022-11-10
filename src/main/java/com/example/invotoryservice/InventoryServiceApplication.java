package com.example.invotoryservice;

import com.example.invotoryservice.entities.Product;
import com.example.invotoryservice.entities.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ProductRepository productRepository){
        return args -> {
            productRepository.save(new Product(null,"DELL",1000.23,10.00));
            productRepository.save(new Product(null,"ASUS",2000.23,20.00));
            productRepository.save(new Product(null,"ACER",3000.23,30.00));
            productRepository.save(new Product(null,"HP",4000.23,40.00));
            productRepository.findAll().forEach(product -> {
                System.out.println(product.toString());
            });
        };
    }
}
