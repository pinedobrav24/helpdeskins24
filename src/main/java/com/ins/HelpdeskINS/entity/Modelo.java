package com.ins.HelpdeskINS.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "MODELO")
public class Modelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mod_id")
	private Integer id;

	@NotBlank(message = "La descripción del modelo no puede estar vacío")
	@Column(name = "mod_descripcion")
	@Size(min = 2, max = 80, message = "El modelo solo puede tener de 2 a 80 caracteres")
	private String descripcion;

	@JoinColumn(name = "mod_marcaid", referencedColumnName = "mar_id")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Marca marca;

	@JoinColumn(name = "mod_tipeqid", referencedColumnName = "tpe_id")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Tipo_Equipo tipoEquipo;

	@Column(name = "mod_procesador")
	@Size(min = 0, max = 20, message = "El procesador solo puede tener de 2 a 20 caracteres")
	private String procesador;

	@Column(name = "mod_memoria")
	@Size(min = 0, max = 20, message = "La memoria solo puede tener de 2 a 20 caracteres")
	private String memoria;

	@Column(name = "mod_disco")
	@Size(min = 0, max = 20, message = "El disco solo puede tener de 2 a 20 caracteres")
	private String disco;

	@Column(name = "mod_ppmbn")
	// @Pattern(regexp = "\\d+", message = "Solo se permiten números")
	private Integer ppmbn;

	@Column(name = "mod_pppc")
	// @Pattern(regexp = "\\d+", message = "Solo se permiten números")
	private Integer pppc;

	@Column(name = "mod_infadicional")
	@Size(min = 0, max = 100, message = "El modelo solo puede tener de 2 a 80 caracteres")
	private String infoadicional;

	@Column(name = "mod_estado")
	private Integer estado;

}
