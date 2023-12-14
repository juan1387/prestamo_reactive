package com.creacionjuan.prestamos.controllers;

import com.creacionjuan.prestamos.models.Cliente;
import com.creacionjuan.prestamos.services.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/apiGestionUsuario")
@AllArgsConstructor
public class GestionClientes {
    private final ClienteService clienteService;

    @PostMapping("/crear-cliente")
    public Mono<ResponseEntity<Mono<Cliente>>> createUser(@RequestBody Cliente cliente){
        //System.out.println(cliente.toString());

        return Mono.just(ResponseEntity.ok(clienteService.insertClientes(cliente)));
    }

    @GetMapping("/consultarUser")    public Mono<ResponseEntity<Mono<Cliente>>> getUser(@RequestParam int  id){
        //System.out.println(cliente.toString());

        return Mono.just(ResponseEntity.ok(clienteService.buscarClientes(id)));
    }

    @GetMapping("/consultarUserNumDoc")    public Mono<ResponseEntity<Mono<Cliente>>> getUserNumDoc(@RequestParam String  nunDoc){
        //System.out.println(cliente.toString());

        return Mono.just(ResponseEntity.ok(clienteService.buscarClientesNunDoc(nunDoc)));
    }

    @GetMapping("/todosclientes")    public Flux<Cliente> todosClientes(){
        //System.out.println(cliente.toString());

        return clienteService.obtenerTodolosClientes();
    }


}
