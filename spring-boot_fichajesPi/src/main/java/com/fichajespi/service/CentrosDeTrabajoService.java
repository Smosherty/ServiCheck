package com.fichajespi.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fichajespi.entity.CentrosDeTrabajo;
import com.fichajespi.repository.CentrosDeTrabajoRepository;
import com.fichajespi.service.common.CommonServiceImpl;

@Service
@Transactional
public class CentrosDeTrabajoService extends CommonServiceImpl<CentrosDeTrabajo, CentrosDeTrabajoRepository> {

    public Optional<CentrosDeTrabajo> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public List<CentrosDeTrabajo> findByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    public List<CentrosDeTrabajo> findByGrupoId(Long grupoId) {
        return repository.findByGrupoId(grupoId);
    }

    public boolean existsByNombre(String nombre) {
        return repository.existsByNombre(nombre);
    }

    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    public boolean existsByDireccion(String direccion) {
        return repository.existsByDireccion(direccion);
    }
}