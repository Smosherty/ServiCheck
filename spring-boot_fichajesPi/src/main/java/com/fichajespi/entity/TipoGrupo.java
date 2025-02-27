package com.fichajespi.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fichajespi.entity.enums.TipoGrupoEnum;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tipo_grupos")
public class TipoGrupo {
	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoGrupoEnum TipoGrupoEnum;
}
