package com.creacionjuan.prestamos.models;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tasas {
    @Id
    private Integer id;
    private String nombreTasa;
    private Double valorTasa;
    private String descripcion;

}
