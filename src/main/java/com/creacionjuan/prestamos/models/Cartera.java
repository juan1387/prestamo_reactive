package com.creacionjuan.prestamos.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("cartera")
@Builder
public class Cartera {
    @Id
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int clienteid;
    private long dineroPrestado;
    private LocalDate fechaEntrega;
    private LocalDate fechaDevolucion;
    private Double tasaPrestamo;
    private String estado;
}
