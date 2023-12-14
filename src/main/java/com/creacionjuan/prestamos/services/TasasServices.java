package com.creacionjuan.prestamos.services;

import com.creacionjuan.prestamos.DTO.TasaDTO;
import com.creacionjuan.prestamos.models.Tasas;
import com.creacionjuan.prestamos.repository.Itasas;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class TasasServices {
    private final Itasas repotasas;
    public Mono<Tasas> agregarTasa(Tasas tasa){
       return repotasas.save(tasa);
    }

    public Mono<Tasas> consutarTasaByID(TasaDTO tasa){
        return repotasas.findByValorTasa(tasa.valor());

    }

    public Flux<Tasas> consutarTasas(){
       /* Flux<Tasas> miTasa =  repotasas.findAll();
        miTasa.map(x->{
           return null ;
        }).blockFirst();*/
        return repotasas.findAll();

    }

}
