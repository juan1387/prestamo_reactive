package com.creacionjuan.prestamos.repository;

import com.creacionjuan.prestamos.models.Cliente;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface Iclientes extends R2dbcRepository<Cliente, Integer> {

    Mono<Cliente> findBynunDoc(String nunDoc);


}
