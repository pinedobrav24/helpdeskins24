package com.ins.HelpdeskINS.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="centro_dir")
public class CentroDirec {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cend_id")
	private Integer id;
	
	
	@NotBlank(message="Las siglas no puede estar nulo")
	@Size(min = 2, max = 10, message = "Las siglas solo puede tener de 2 a 10 caracteres")
	@Column(name="cend_siglas")
	private String siglas;
	

	@NotBlank(message="Las siglas no puede estar nulo")
	@Size(min = 2, max = 200, message = "El nombre solo puede tener de 2 a 200 caracteres")
	@Column(name="cend_nombre")
	private String nombre;
	
	@Column(name="cend_estado")
	private Integer estado; 
}

