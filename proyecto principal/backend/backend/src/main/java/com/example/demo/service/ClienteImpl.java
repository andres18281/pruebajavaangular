package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cliente;
import com.example.demo.repository.ClienteRepository;

@Service
public class ClienteImpl implements ICliente {
	
	@Autowired
	private ClienteRepository repository;
	@Override
	public Cliente save(Cliente client) {
		System.out.println("prueba"+ client.toString());
		this.repository.save(client);
		return client;
		
	}
	
	@Override
	public List<Cliente> consultarClientes() {
		return this.repository.findAll();
	}

	@Override
    public Optional<Cliente> findBySharedKey(String sharedKey) {
        return repository.findBySharedKey(sharedKey);
    }
	
	

}
