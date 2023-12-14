package com.creacionjuan.prestamos.models;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@Data
@Table("cliente")
@Builder
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private String apellido;
    private String tipoDoc;
    private String nunDoc;
}
