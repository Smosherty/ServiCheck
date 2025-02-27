package com.fichajespi.specifications;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.fichajespi.entity.CentrosDeTrabajo;

@Component
public final class CentrosDeTrabajoSpecifications {

    public Specification<CentrosDeTrabajo> nombreContains(String nombre) {
        return (root, query, builder) -> 
            nombre == null ? null : builder.like(builder.lower(root.get("nombre")), "%" + nombre.toLowerCase() + "%");
    }

    public Specification<CentrosDeTrabajo> emailEquals(String email) {
        return (root, query, builder) -> 
            email == null ? null : builder.equal(root.get("email"), email);
    }

    public Specification<CentrosDeTrabajo> direccionContains(String direccion) {
        return (root, query, builder) -> 
            direccion == null ? null : builder.like(builder.lower(root.get("direccion")), "%" + direccion.toLowerCase() + "%");
    }

    public Specification<CentrosDeTrabajo> telefonoEquals(String telefono) {
        return (root, query, builder) -> 
            telefono == null ? null : builder.equal(root.get("telefono"), telefono);
    }

    public Specification<CentrosDeTrabajo> horarioServicioEquals(String horarioServicio) {
        return (root, query, builder) -> 
            horarioServicio == null ? null : builder.equal(root.get("horarioServicio"), horarioServicio);
    }
}
