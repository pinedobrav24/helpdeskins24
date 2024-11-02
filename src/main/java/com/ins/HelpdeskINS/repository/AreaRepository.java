package com.ins.HelpdeskINS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ins.HelpdeskINS.entity.Area;


import java.util.List;

public interface AreaRepository extends JpaRepository <Area,Integer>{
// JPQL
    @Query("FROM Area a WHERE a.Unidad.id =:unidad")
    List<Area> buscarAreaporUnd(Integer unidad);
}
