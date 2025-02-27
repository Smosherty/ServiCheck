package com.fichajespi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.fichajespi.entity.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long>,
        JpaSpecificationExecutor<Grupo> {

    Optional<Grupo> findByNombre(String nombre);

    Optional<Grupo> findByEmail(String email);
    
    boolean existsByNombre(String nombre);
    
    boolean existsByEmail(String email);
    
    List<Grupo> findByHorarioAtencion(String horarioAtencion);
}
