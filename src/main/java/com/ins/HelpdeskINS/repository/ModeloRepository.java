package com.ins.HelpdeskINS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ins.HelpdeskINS.entity.Modelo;
import com.ins.HelpdeskINS.entity.SubDireccionOF;
import com.ins.HelpdeskINS.entity.Tipo_Equipo;

public interface ModeloRepository
		extends JpaRepository<Modelo, Integer> {

	List<Modelo> findByTipoEquipo_Id(Integer tipoEquipoId);

	// JPQL
	@Query("FROM Modelo d WHERE d.tipoEquipo.id =:tipo")
	List<Modelo> buscarTipo(Integer tipo);

}
