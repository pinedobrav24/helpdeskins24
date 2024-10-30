package com.ins.HelpdeskINS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ins.HelpdeskINS.entity.Tipo_Equipo;
import com.ins.HelpdeskINS.repository.Tipo_EquipoRepository;


@Service
public class Tipo_EquipoService {
	
	@Autowired
	Tipo_EquipoRepository repository;

	//CRUD
	
	//Select
	public List<Tipo_Equipo>tipoEquipoSel(){
		return repository.findAll();
		}
	
	public Tipo_Equipo tipoEquipoInsUpd(Tipo_Equipo tipoEquipo) {
		return repository.save(tipoEquipo);	
	}
	
	public Tipo_Equipo tipoEquipoGet(Integer id) {
		return repository.findById(id).orElse(new Tipo_Equipo());
	}
	
	public void tipoEquipoDel(Integer id) {
		repository.deleteById(id);
	}
}
