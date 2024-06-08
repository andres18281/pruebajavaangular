package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
//@EntityScan(basePackages = "com.example.demo.entity")
//@EnableJpaRepositories(basePackages = "com.example.demo.repository")
public class BackendApplication implements CommandLineRunner {

	/*
    @Autowired
    private ClienteRepository clienteRepository;
*/
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
  /*
    	
    	System.out.println("Checking Cliente entity...");
        Cliente cliente = new Cliente();
        cliente.setSharedKey("key123");
        cliente.setBusinessId("biz123");
        cliente.setEmail("test@example.com");
        cliente.setPhone(123456789);
        cliente.setDateinitial("2023-01-01");
        cliente.setDateend("2023-12-31");
        clienteRepository.save(cliente);
        System.out.println("Cliente entity saved!");
    */
    }
}