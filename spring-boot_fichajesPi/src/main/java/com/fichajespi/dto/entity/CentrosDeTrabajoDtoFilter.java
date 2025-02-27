package com.fichajespi.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CentrosDeTrabajoDtoFilter {

    private String nombre;
    private String email;
    private String direccion;
    private String telefono;
    private Long grupoId;
}