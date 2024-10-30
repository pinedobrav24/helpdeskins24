package com.ins.HelpdeskINS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ins.HelpdeskINS.entity.Equipo;
import com.ins.HelpdeskINS.repository.EquipoRepository;

@Service
public class EquipoService {

	@Autowired
	EquipoRepository repository;

	// CRUD

	// Select
	public List<Equipo> equipoSel() {
		return repository.findAll();
	}

	public List<Object[]> listarEquipos() {
		return repository.listaDetallada();
	}

	public List<Object[]> listarEquiposPrincipales() {
		return repository.listaEqPrincipales();
	}

	public Equipo equipoInsUpd(Equipo equipo) {
		return repository.save(equipo);
	}

	public Equipo equipoGet(Integer id) {
		return repository.findById(id).orElse(new Equipo());
	}

	public void equipoDel(Integer id) {
		repository.deleteById(id);
	}
}
