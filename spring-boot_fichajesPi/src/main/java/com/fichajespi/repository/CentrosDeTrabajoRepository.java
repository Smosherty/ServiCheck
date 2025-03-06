package com.fichajespi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.fichajespi.entity.CentrosDeTrabajo;

@Repository
public interface CentrosDeTrabajoRepository extends JpaRepository<CentrosDeTrabajo, Long>,
        JpaSpecificationExecutor<CentrosDeTrabajo> {

    List<CentrosDeTrabajo> findByNombre(String nombre);

    List<CentrosDeTrabajo> findByGrupo_Id(Long grupoId);

    Optional<CentrosDeTrabajo> findByEmail(String email);

    boolean existsByNombre(String nombre);

    boolean existsByEmail(String email);

    boolean existsByDireccion(String direccion);
}