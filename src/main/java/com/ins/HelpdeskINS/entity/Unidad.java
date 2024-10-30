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
@Table(name="unidad")
public class Unidad {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="und_id")
	private Integer id;
	
    @NotBlank(message="Las siglas no puede estar nulo")
	@Column(name="und_siglas")
	@Size(min = 2, max = 10, message = "Las siglas solo puede tener de 2 a 10 caracteres")
	private String siglas;

    @NotBlank(message="Las siglas no puede estar nulo")
	@Column(name="und_nombre")
	@Size(min = 2, max = 200, message = "El nombre solo puede tener de 2 a 200 caracteres")
	private String nombre;

	@JsonBackReference
	@JoinColumn(name = "und_sudid", referencedColumnName = "sud_id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private SubDireccionOF subdireccion;


	@Column(name="und_estado")
	private Integer estado; 
}

