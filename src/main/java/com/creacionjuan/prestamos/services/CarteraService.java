package com.creacionjuan.prestamos.services;

import com.creacionjuan.prestamos.models.Cartera;
import com.creacionjuan.prestamos.models.Tasas;
import com.creacionjuan.prestamos.repository.ICartera;
import com.creacionjuan.prestamos.repository.Iclientes;
import com.creacionjuan.prestamos.repository.Itasas;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CarteraService {
    private final Iclientes iclientes;
    private final ICartera iCartera;
    private final Itasas itasas;

    public Mono<Cartera> hacerPrestamo(Cartera cartera) {
        System.out.println("La tas de prestamo que esta llegando es: "+cartera.getTasaPrestamo());

        return itasas.findByValorTasa(cartera.getTasaPrestamo()).flatMap(tasa -> {
            System.out.println(tasa.getDescripcion());

            return iCartera.save(cartera).onErrorResume(err->{
                System.out.println("Error guardando la carteras "+ err);
                return Mono.empty();
            });

        }).switchIfEmpty(Mono.error(new RuntimeException("La tasa enviada no existe"))).onErrorResume(err->{
            System.out.println("Se presento un error en la consulta de la tasa: "+err);
            return Mono.just(Cartera.builder().build());
        });


    }
}
