package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.entity.Cliente;
import com.example.demo.service.ICliente;
import com.fasterxml.jackson.databind.ObjectMapper;
	
@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ICliente clienteService;

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
    @WithMockUser
    public void testGetCliente() throws Exception {
        when(clienteService.consultarClientes()).thenReturn(Arrays.asList(cliente));
        mockMvc.perform(get("/api/clientes").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"sharedKey\":\"key1\",\"businessId\":\"business1\",\"email\":\"test@example.com\",\"phone\":123456789,\"dateinitial\":\"2021-01-01\",\"dateend\":\"2021-12-31\"}]"));
    }

    @Test
    @WithMockUser
    public void testCreateCliente() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(cliente);
        
        // Depuración: Asegúrate de que el JSON se imprime correctamente
        System.out.println("JSON Request: " + json);

        when(clienteService.save(cliente)).thenReturn(cliente);
        mockMvc.perform(post("/api/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"sharedKey\":\"key1\",\"businessId\":\"business1\",\"email\":\"test@example.com\",\"phone\":123456789,\"dateinitial\":\"2021-01-01\",\"dateend\":\"2021-12-31\"}"));
    }
    
    @Test
    public void testGetClienteBySharedKey() throws Exception {
        // Crear un cliente de ejemplo
        Cliente cliente = new Cliente();
        //cliente.setId(1L);
        cliente.setSharedKey("example Key");
        cliente.setBusinessId("business1");
        cliente.setEmail("test@example.com");
        cliente.setPhone(123456789);
        cliente.setDateinitial("2021-01-01");
        cliente.setDateend("2021-12-31");

        // Configurar el comportamiento del servicio mock
        when(clienteService.findBySharedKey(Mockito.anyString())).thenReturn(Optional.of(cliente));

        // Realizar la solicitud GET al endpoint y verificar la respuesta
        mockMvc.perform(get("/api/clientes/{sharedKey}", "ekey")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.sharedKey").value("exampleKey"))
                .andExpect(jsonPath("$.businessId").value("business1"))
                .andExpect(jsonPath("$.email").value("test@example.com"))
                .andExpect(jsonPath("$.phone").value(123456789))
                .andExpect(jsonPath("$.dateinitial").value("2021-01-01"))
                .andExpect(jsonPath("$.dateend").value("2021-12-31"));
    }
}