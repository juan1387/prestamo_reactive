package com.creacionjuan.prestamos.controllers;

import com.creacionjuan.prestamos.models.Fondos;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/gestion-fondos")
public class GestionFondos {
    @PostMapping("/ingresar")
    public Mono<ResponseEntity<Mono<Fondos>>> agregarFondos(){
        return null;
    }
}
