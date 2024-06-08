package com.example.demo.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import com.example.demo.entity.Cliente;
import com.example.demo.repository.ClienteRepository;



class ClienteImplTest {
	
	
	@Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteImpl clienteService;

    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        cliente = new Cliente();
        cliente.setSharedKey("key1");
        cliente.setBusinessId("business1");
        cliente.setEmail("test@example.com");
        cliente.setPhone(123456789);
        cliente.setDateinitial("2021-01-01");
        cliente.setDateend("2021-12-31");
    }

    @Test
    public void testCreateCliente() {
        when(clienteRepository.save(cliente)).thenReturn(cliente);
        Cliente created = clienteService.save(cliente);
        assertEquals(cliente, created);
        verify(clienteRepository).save(cliente);
    }

    @Test
    public void testConsultarClientes() {
        List<Cliente> clientes = Arrays.asList(cliente);
        when(clienteRepository.findAll()).thenReturn(clientes);
        List<Cliente> result = clienteService.consultarClientes();
        assertEquals(clientes, result);
        verify(clienteRepository).findAll();
    }
	
	

}
