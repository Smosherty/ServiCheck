package com.fichajespi.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.sun.istack.NotNull;

import org.springframework.data.annotation.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "grupos")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Column(unique = true)
    private String nombre;

    @NotNull
	@NotBlank
    @Column(unique = true)
    private String email;

    private String horarioAtencion;

    @OneToMany(mappedBy = "grupo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CentrosDeTrabajo> CentrosDeTrabajo;

    @Transient
    public int getTotalLocales() {
        return CentrosDeTrabajo != null ? CentrosDeTrabajo.size() : 0;
    }

    // @Transient
    // public int getTotalEmpleados() {
    //     return CentrosDeTrabajo != null
    //             ? CentrosDeTrabajo.stream().mapToInt(local -> local.getUsuarios().size()).sum()
    //             : 0;
    // }
}
