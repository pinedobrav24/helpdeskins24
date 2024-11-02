package com.ins.HelpdeskINS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

import com.ins.HelpdeskINS.entity.Unidad;

public interface UnidadRepository extends JpaRepository <Unidad,Integer> {
  // JPQL
    @Query("FROM Unidad u WHERE u.SubDireccionOF.id =:subdirec")
    List<Unidad> buscarUnidadporSUbD(Integer subdirec);
}

