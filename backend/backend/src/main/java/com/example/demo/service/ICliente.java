package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Cliente;

public interface ICliente {
 
	Cliente save(Cliente client);
	List<Cliente> consultarClientes();
	Optional<Cliente> findBySharedKey(String sharedKey);
	
}
