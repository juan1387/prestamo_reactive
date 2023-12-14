package com.creacionjuan.prestamos.services;

import com.creacionjuan.prestamos.models.Cliente;
import com.creacionjuan.prestamos.repository.Iclientes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ClienteService {
    private final Iclientes iclientes;

    public Mono<Cliente> insertClientes(Cliente cliente) {

        return iclientes.save(cliente);
    }

    public Mono<Cliente> buscarClientes(int idcliente) {
        System.out.println(idcliente);
        return iclientes.findById(idcliente);
    }

    public Mono<Cliente> buscarClientesNunDoc(String nunDoc){
        System.out.println(nunDoc);
        return  iclientes.findBynunDoc(nunDoc);
    }

    public Flux<Cliente> obtenerTodolosClientes(){
        return iclientes.findAll();
    }
}
