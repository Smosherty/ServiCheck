package com.fichajespi.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fichajespi.entity.Grupo;
import com.fichajespi.repository.GrupoRepository;
import com.fichajespi.service.common.CommonServiceImpl;

@Service
@Transactional
public class GrupoService extends CommonServiceImpl<Grupo, GrupoRepository> {

    public boolean existsByNombre(String nombreGrupo) {
        return repository.existsByNombre(nombreGrupo);
    }
    
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }
    
    public Optional<Grupo> findByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }
    
    public Optional<Grupo> findByEmail(String email) {
        return repository.findByEmail(email);
    }
    
    public List<Grupo> findByHorarioAtencion(String horarioAtencion) {
        return repository.findByHorarioAtencion(horarioAtencion);
    }
}
