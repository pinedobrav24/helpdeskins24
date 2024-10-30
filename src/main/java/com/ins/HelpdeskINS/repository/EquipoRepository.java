package com.ins.HelpdeskINS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ins.HelpdeskINS.entity.Equipo;

public interface EquipoRepository
		extends JpaRepository<Equipo, Integer> {

	@Query(value = "SELECT e.equ_id, e.equ_patrimonial, e.equ_serie, tp.tpe_descripcion, m.mar_nombre, mo.mod_descripcion, "
			+
			" CASE " +
			" WHEN e.equ_condicion='1' THEN 'REGULAR'" +
			" WHEN e.equ_condicion='2' THEN 'BUENO'" +
			" WHEN e.equ_condicion='3' THEN 'MALO'" +
			" WHEN e.equ_condicion='4' THEN 'P/BAJA'" +
			" END as condicion, " +
			" ep.equ_patrimonial" +
			" FROM equipo e " +
			" LEFT JOIN equipo ep ON e.equ_asocid=ep.equ_id" +
			" JOIN modelo mo ON e.equ_modid=mo.mod_id" +
			" JOIN marca m ON mo.mod_marcaid=m.mar_id" +
			" JOIN tipo_equipo tp ON mo.mod_tipeqid=tp.tpe_id", nativeQuery = true)
	List<Object[]> listaDetallada();

	@Query(value = "SELECT e.equ_id, e.equ_patrimonial, ma.mar_nombre, mo.mod_descripcion, tp.tpe_descripcion " +
			" FROM equipo e " +
			" JOIN modelo mo on e.equ_modid=mo.mod_id " +
			" join marca ma on mo.mod_marcaid=ma.mar_id " +
			" join tipo_equipo tp on mo.mod_tipeqid=tp.tpe_id " +
			" WHERE e.equ_patrimonial like '74089950%' or e.equ_patrimonial like '74080500%'", nativeQuery = true)
	List<Object[]> listaEqPrincipales();
}
