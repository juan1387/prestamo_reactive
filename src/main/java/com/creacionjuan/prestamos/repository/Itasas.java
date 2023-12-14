package com.creacionjuan.prestamos.repository;

import com.creacionjuan.prestamos.models.Tasas;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface Itasas extends R2dbcRepository<Tasas,Integer> {

    Mono<Tasas> findByValorTasa(Double tasa);

}
