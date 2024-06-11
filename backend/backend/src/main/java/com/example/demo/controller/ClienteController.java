package com.example.demo.controller;


import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;

import com.example.demo.entity.Cliente;
import com.example.demo.service.ICliente;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.core.io.FileSystemResource;

@RestController
@RequestMapping("/api/clientes")

public class ClienteController {

	@Autowired
	private ICliente iCliente;
	
	/*
	@PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
		
        return iCliente.save(cliente);
    }*/
	
	/*
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "Requestor-Type", exposedHeaders = "X-Get-Header")
	@PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
		cliente.generarSharedKey();
        Cliente savedCliente = iCliente.save(cliente);
        return ResponseEntity.ok(savedCliente);
    }*/
	
	
	@PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
		cliente.generarSharedKey();
        Cliente savedCliente = iCliente.save(cliente);
        return new ResponseEntity<>(savedCliente, HttpStatus.CREATED);
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

	 @GetMapping("/export/csv")
	 public ResponseEntity<FileSystemResource> exportClientesToCSV() {
	     List<Cliente> clientes = iCliente.consultarClientes();
	    
	     String csvFilePath = "clientes.csv";

	     try (FileWriter writer = new FileWriter(csvFilePath)) {
	         // Escribir la cabecera del archivo CSV
	         writer.append("SharedKey, BusinessId, Email, Phone, DateInitial, DateEnd\n");

	         // Escribir los datos de los clientes en el archivo CSV
	         for (Cliente cliente : clientes) {
	             writer.append(String.join(",", 
	                 cliente.getSharedKey(),
	                 cliente.getBusinessId(),
	                 cliente.getEmail(),
	                 String.valueOf(cliente.getPhone()),
	                 cliente.getDateinitial(),
	                 cliente.getDateend()
	             ));
	             writer.append("\n");
	         }
	       
	         writer.flush();
	         
	         // Crear un recurso FileSystemResource para el archivo CSV
	         FileSystemResource fileResource = new FileSystemResource(csvFilePath);
	         
	         // Devolver el archivo CSV como un recurso para ser descargado
	         HttpHeaders headers = new HttpHeaders();
	         headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=clientes.csv");

	         return ResponseEntity.ok()
	             .headers(headers)
	             .contentLength(fileResource.contentLength())
	             .contentType(MediaType.parseMediaType("application/octet-stream"))
	             .body(fileResource);
	     } catch (IOException e) {
	         e.printStackTrace();
	         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	     }
	 }
	
	
	
	
}
