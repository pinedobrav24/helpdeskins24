package com.ins.HelpdeskINS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ins.HelpdeskINS.entity.Tipo_Equipo;

/* extends CrudRepository <clase a castear, tipo de dato del Id (clave principal> */
public interface Tipo_EquipoRepository extends JpaRepository<Tipo_Equipo,Integer>{

}
