package com.creacionjuan.prestamos.controllers;

import com.creacionjuan.prestamos.DTO.CarteraDTO;
import com.creacionjuan.prestamos.models.Cartera;
import com.creacionjuan.prestamos.services.CarteraService;
import com.creacionjuan.prestamos.services.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@RestController
@RequestMapping("/apiPrestamos")
@AllArgsConstructor
public class GestionCartera {
    private  final ClienteService clienteService;
    private final CarteraService carteraService;
    @PostMapping("/hacer-prestamo")
    public Mono<ResponseEntity<Mono<Cartera>>> hacerPrestamo(@RequestBody CarteraDTO cartera){
        System.out.println(cartera.toString());

        Mono<Cartera> carterarealizada =  clienteService.buscarClientes(cartera.cliente()).flatMap(o->{
            System.out.println(o.toString());
            Cartera miCartera = Cartera.builder()
                    .tasaPrestamo(cartera.tasaPrestamo())
                    .clienteid(o.getId())
                    .dineroPrestado(cartera.dineroPrestado())
                    .estado("Pendiente")
                    .fechaEntrega(LocalDate.now())
                    .fechaDevolucion(LocalDate.now().plusDays(30))
                    .dineroPrestado(cartera.dineroPrestado()).build();
            System.out.println(miCartera.toString());
            Mono<Cartera> miprestamo = carteraService.hacerPrestamo(miCartera);

            return miprestamo;
        });



        return Mono.just(ResponseEntity.ok(carterarealizada.onErrorResume(elerror->{
            System.out.println("Se presento un error "+elerror);
            return Mono.just(Cartera.builder().build());
        })));
    }

    public Mono<ResponseEntity<Flux<Cartera>>> pendientePorClienteDoc(@RequestBody CarteraDTO cartera){

        return null;
    }
}
