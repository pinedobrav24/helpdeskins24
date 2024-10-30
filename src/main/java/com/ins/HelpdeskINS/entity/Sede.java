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
@Table(name="sede")
public class Sede {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sed_id")
	private Integer id;
	

    @NotBlank(message="Las siglas no puede estar nulo")
	@Column(name="sed_abr")
	@Size(min = 2, max = 6, message = "Las siglas solo puede tener de 2 a 6 caracteres")
	private String abreviatura;

	@NotBlank(message="Las descripcion no puede estar nulo")
	@Column(name="sed_descripcion")
	@Size(min = 2, max = 200, message = "La descripcion solo puede tener de 2 a 200 caracteres")
	private String descripcion;
	
    @Column(name = "sed_direccion")
	private String direccion;

	@Column(name="sed_estado")
	private Integer estado; 
}

