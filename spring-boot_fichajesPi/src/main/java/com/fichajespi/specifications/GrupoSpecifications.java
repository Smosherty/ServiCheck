package com.fichajespi.specifications;

import java.util.List;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.fichajespi.entity.Grupo;

@Component
public final class GrupoSpecifications {

    public static Specification<Grupo> nombreGrupoContains(String nombre) {
        return (root, query, criteriaBuilder) -> 
            criteriaBuilder.like(root.get("nombre"), "%" + nombre + "%");
    }
    
    public static Specification<Grupo> emailContains(String email) {
        return (root, query, criteriaBuilder) -> 
            criteriaBuilder.like(root.get("email"), "%" + email + "%");
    }
    
    public static Specification<Grupo> horarioAtencionEquals(String horarioAtencion) {
        return (root, query, criteriaBuilder) -> 
            criteriaBuilder.equal(root.get("horarioAtencion"), horarioAtencion);
    }

    public static Specification<Grupo> centrosDeTrabajoIn(List<Long> centrosDeTrabajoIds) {
        return (root, query, criteriaBuilder) -> {
            if (centrosDeTrabajoIds == null || centrosDeTrabajoIds.isEmpty()) {
                return criteriaBuilder.conjunction();
            }

            Join<Object, Object> join = root.join("CentrosDeTrabajo", JoinType.INNER); 
            return join.get("id").in(centrosDeTrabajoIds);
        };
    }
    
}