package com.creacionjuan.prestamos.models;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Fondos {
    @Id
    private Integer id;
    private Long ingreso;
    private LocalDate fechaIngreso;
    private String descripcion;

}
