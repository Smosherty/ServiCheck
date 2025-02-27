package com.fichajespi.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fichajespi.dto.entity.CentrosDeTrabajoDto;
import com.fichajespi.dto.entity.CentrosDeTrabajoDtoEdit;
import com.fichajespi.entity.CentrosDeTrabajo;

@Component
public class CentrosDeTrabajoDtoConverter {

    public CentrosDeTrabajo transformNew(CentrosDeTrabajoDto dto) {
        CentrosDeTrabajo centroDeTrabajo = new CentrosDeTrabajo();
        centroDeTrabajo.setNombre(dto.getNombre());
        centroDeTrabajo.setEmail(dto.getEmail());
        centroDeTrabajo.setDireccion(dto.getDireccion());
        centroDeTrabajo.setTelefono(dto.getTelefono());
        centroDeTrabajo.setHorarioServicio(dto.getHorarioServicio());
        centroDeTrabajo.setGrupoId(dto.getGrupoId());
        return centroDeTrabajo;
    }

    public CentrosDeTrabajoDto inverseTransform(CentrosDeTrabajo centroDeTrabajo) {
        return CentrosDeTrabajoDto.builder()
                .id(centroDeTrabajo.getId())
                .nombre(centroDeTrabajo.getNombre())
                .email(centroDeTrabajo.getEmail())
                .direccion(centroDeTrabajo.getDireccion())
                .telefono(centroDeTrabajo.getTelefono())
                .horarioServicio(centroDeTrabajo.getHorarioServicio())
                .grupoId(centroDeTrabajo.getGrupoId())
                .build();
    }

    public CentrosDeTrabajo transformEdit(CentrosDeTrabajo centroDeTrabajo, CentrosDeTrabajoDtoEdit editar) {
        centroDeTrabajo.setNombre(editar.getNombre());
        centroDeTrabajo.setEmail(editar.getEmail());
        centroDeTrabajo.setDireccion(editar.getDireccion());
        centroDeTrabajo.setTelefono(editar.getTelefono());
        centroDeTrabajo.setHorarioServicio(editar.getHorarioServicio());
        return centroDeTrabajo;
    }
}