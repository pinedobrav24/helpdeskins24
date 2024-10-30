package com.ins.HelpdeskINS.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import lombok.Setter;

@Entity
@Getter
@Setter
public class Equipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "equ_id")
	private Integer id;

	@JsonBackReference
	@JoinColumn(name = "equ_modid", referencedColumnName = "mod_id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Modelo modelo;

	@NotBlank(message = "El código patrimonial del equipo no puede estar vacío")
	@Column(name = "equ_patrimonial")
	@Size(min = 12, max = 14, message = "El patrimonial debe tener 12 caracteres")
	private String patrimonial;

	@NotBlank(message = "La serie del equipo no puede estar vacío")
	@Column(name = "equ_serie")
	@Size(min = 2, max = 20, message = "La serie permite hasta 20 caracteres")
	private String serie;

	@Column(name = "equ_codinterno")
	private String codinterno;

	@ManyToOne
	@JoinColumn(name = "equ_asocid")
	private Equipo equipoPrincipal;

	@Column(name = "equ_condicion")
	private Integer condicion;

	@Column(name = "equ_estado")
	private Integer estado;

	@Column(name = "equ_infoadicional")
	private String infoadicional;
}
