package com.example.demo.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;



import com.example.demo.entity.Cliente;
import com.example.demo.service.ICliente;


@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	@Autowired
	private ICliente iCliente;
	
	@PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
		cliente.generarSharedKey();
        return iCliente.save(cliente);
    }
	
	@GetMapping
	public List<Cliente> GetCliente() {

		return this.iCliente.consultarClientes();
	}
	
	 @GetMapping("/{sharedKey}")
	 public Optional<Cliente> getClienteBySharedKey(@PathVariable String sharedKey) {
		System.out.println(iCliente.findBySharedKey(sharedKey));
	    return iCliente.findBySharedKey(sharedKey);
	 }

	
	
	
	
}
