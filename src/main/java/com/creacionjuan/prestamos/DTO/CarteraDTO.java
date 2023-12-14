package com.creacionjuan.prestamos.DTO;

import java.time.LocalDate;

public record CarteraDTO(Integer codigo, Integer cliente, long dineroPrestado, LocalDate fechaEntrega, LocalDate fechaDevolucion, Double tasaPrestamo, String estado) {
}
