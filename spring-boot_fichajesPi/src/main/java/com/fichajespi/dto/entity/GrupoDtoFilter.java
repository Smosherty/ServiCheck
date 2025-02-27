package com.fichajespi.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GrupoDtoFilter {

    private String nombre;
    private String email;
    private String horarioAtencion;
}
