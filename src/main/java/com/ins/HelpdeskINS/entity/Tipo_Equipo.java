package com.ins.HelpdeskINS.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="TIPO_EQUIPO")
public class Tipo_Equipo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tpe_id")
	private Integer id;
	
	@Column(name = "tpe_descripcion")
	@NotBlank(message = "La descripción del tipo de equipo no puede estar vacío")
	@Pattern(regexp="^[^0-9]+$",message="La descripción del equipo no puede contener números")
	@Size(min = 2, max = 40, message = "La persona de contacto solo puede tener hasta 40 caracteres")
	private String descripcion;
	
	@NotBlank(message = "El prefijo de patrimonial no puede estar vacío")
	@Digits(integer = 8, fraction = 0, message = "El prefijo patrimonial solo puede contener números")
	@Column(name="tpe_prefpatrimonial")
	private String prefijo1;
	
	
	@Column(name="tpe_prefpat1")
	private String prefijo2;
	

	@Column(name="tpe_prefpat2")
	private String prefijo3;
	
	@Column(name="tpe_estado")
	private Integer estado;
	
	@Column(name="tpe_tipo")
	private Integer tipo;
	
}
