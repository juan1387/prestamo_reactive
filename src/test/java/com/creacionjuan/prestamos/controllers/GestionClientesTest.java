package com.creacionjuan.prestamos.controllers;

import com.creacionjuan.prestamos.models.Cliente;
import com.creacionjuan.prestamos.services.ClienteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
public class GestionClientesTest {
    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private GestionClientes gestionClientes;

    @Test
    public void crearCLiente(){
        Cliente micliente = Cliente.builder().nombre("juan").apellido("noriega").build();
        Mockito.when(clienteService.buscarClientesNunDoc(Mockito.anyString()))
                .thenReturn(Mono.just(micliente));

        Mono<ResponseEntity<Mono<Cliente>>> res =  gestionClientes.getUserNumDoc("1");



      StepVerifier.create(res)
                .expectNextMatches(respuesta -> {
                    try {
                        return respuesta.getBody().block().equals(micliente);
                    }catch (Exception e){
                        return false;
                    }

                }).verifyComplete();

    }
}
