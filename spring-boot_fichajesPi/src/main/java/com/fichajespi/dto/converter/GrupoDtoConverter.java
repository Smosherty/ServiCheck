package com.fichajespi.dto.converter;

import org.springframework.stereotype.Component;

import com.fichajespi.dto.entity.GrupoDto;
import com.fichajespi.dto.entity.GrupoDtoEdit;
import com.fichajespi.entity.Grupo;

@Component
public class GrupoDtoConverter {

    public Grupo transformNew(GrupoDto dto) {
        Grupo grupo = new Grupo();
        grupo.setNombre(dto.getNombre());
        grupo.setEmail(dto.getEmail());
        grupo.setHorarioAtencion(dto.getHorarioAtencion());
        return grupo;
    }

    public GrupoDto inverseTransform(Grupo grupo) {
        return GrupoDto
                .builder()
                .id(grupo.getId())
                .nombre(grupo.getNombre())
                .email(grupo.getEmail())
                .horarioAtencion(grupo.getHorarioAtencion())
                .build();
    }

    public Grupo transformEdit(Grupo grupo, GrupoDtoEdit editar) {
        grupo.setNombre(editar.getNombre());
        grupo.setEmail(editar.getEmail());
        grupo.setHorarioAtencion(editar.getHorarioAtencion());
        return grupo;
    }
}
