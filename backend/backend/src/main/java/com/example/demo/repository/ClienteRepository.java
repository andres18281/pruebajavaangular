package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Cliente;
import java.util.Optional;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String>{
  
	Optional<Cliente> findBySharedKey(String sharedKey);
}
