package com.ins.HelpdeskINS.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="area")
public class Area {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="are_id")
	private Integer id;
	
	
	@NotBlank(message="Las siglas no puede estar nulo")
	@Column(name="are_siglas")
	@Size(min = 2, max = 10, message = "Las siglas solo puede tener de 2 a 10 caracteres")
	private String siglas;
	

	@NotBlank(message="Las siglas no puede estar nulo")
	@Column(name="are_nombre")
	@Size(min = 2, max = 200, message = "El nombre solo puede tener de 2 a 200 caracteres")
	private String nombre;
	
	@JsonBackReference
	@JoinColumn(name = "are_undid", referencedColumnName = "und_id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Unidad unidad;
	
	@Column(name="are_estado")
	private Integer estado; 
}

