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
@Table(name="sector")
public class Sector {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sec_id")
	private Integer id;
	
	@JsonBackReference
	@JoinColumn(name = "sec_sedid", referencedColumnName = "sed_id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Sede sede;

	@NotBlank(message="Las siglas no puede estar nulo")
	@Column(name="sec_nombre")
	@Size(min = 2, max = 20, message = "El nombre solo puede tener de 2 a 200 caracteres")
	private String nombre;
	
    @Column(name = "sec_descripcion")
	private String descripcion;
	
	@Column(name="sec_estado")
	private Integer estado; 
}


