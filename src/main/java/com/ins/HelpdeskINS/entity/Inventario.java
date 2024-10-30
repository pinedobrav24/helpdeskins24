package com.ins.HelpdeskINS.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="asignacion_equipo")
public class Inventario implements Serializable {
	
	@Id
	private Integer idsede;
	
	@Id
	private Integer idarea;
	
	@Id
	private Integer idpersonal;
	
	@Id
	private Integer idequipo;
}
