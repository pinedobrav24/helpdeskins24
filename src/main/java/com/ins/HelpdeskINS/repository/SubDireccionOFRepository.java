package com.ins.HelpdeskINS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ins.HelpdeskINS.entity.SubDireccionOF;

public interface SubDireccionOFRepository
	extends JpaRepository<SubDireccionOF,Integer>{
	
	//JPQL
	@Query("FROM SubDireccionOF s WHERE s.centro.id=:cen")
	List<SubDireccionOF>buscarCentro(Integer cen);
}
