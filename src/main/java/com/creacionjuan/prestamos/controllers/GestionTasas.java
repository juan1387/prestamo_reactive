package com.creacionjuan.prestamos.controllers;

import com.creacionjuan.prestamos.models.Tasas;
import com.creacionjuan.prestamos.services.TasasServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/tasas")
@AllArgsConstructor
public class GestionTasas {
    private final TasasServices tasasServices;
    @GetMapping("obtener-tasas")
    public ResponseEntity<Flux<Tasas>> obtenerTasas(){

        return ResponseEntity.ok(tasasServices.consutarTasas());
    }
}
