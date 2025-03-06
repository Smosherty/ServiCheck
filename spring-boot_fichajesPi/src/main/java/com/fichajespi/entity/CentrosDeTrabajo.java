package com.fichajespi.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "centros_de_trabajo")
public class CentrosDeTrabajo {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @NotBlank
    private String nombre;

    @NotNull
    @NotBlank
    private String direccion;

    @NotNull
    @NotBlank
    private String telefono;

    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    private String horarioServicio;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "grupo_id", nullable = false)
    private Grupo grupo;

    @ManyToMany(mappedBy = "centrosDeTrabajo", fetch = FetchType.LAZY)
    private List<Usuario> usuarios;

    // Getter y setter para grupoId
    public Long getGrupoId() {
        return grupo != null ? grupo.getId() : null;
    }

    public void setGrupoId(Long grupoId) {
        if (grupo != null) {
            grupo.setId(grupoId);
        }
    }
}
