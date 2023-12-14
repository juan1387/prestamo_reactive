package com.creacionjuan.prestamos.repository;

import com.creacionjuan.prestamos.models.Cartera;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartera extends R2dbcRepository<Cartera,Integer> {

}
