package com.ins.HelpdeskINS.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="MARCA")
public class Marca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="mar_id")
	private Integer id;
	
	@NotBlank(message="El nombre de la marca no puede estar vacío")
	@Column(name="mar_nombre")
	@Pattern(regexp="^[^0-9]+$",message="La nombre de la marca no puede contener números")
	@Size(min = 2, max = 20, message = "La marca solo puede tener hasta de 2 a 20 caracteres")
	private String nombre;
	
	@Column(name="mar_estado")
	private Integer estado; 
}
