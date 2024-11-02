package com.ins.HelpdeskINS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.ins.HelpdeskINS.entity.Unidad;
import com.ins.HelpdeskINS.repository.UnidadRepository;

@Service
public class UnidadService {
    
    @Autowired
	UnidadRepository repository;

	// CRUD

	// Select
	public List<Unidad> unidadSel() {
		return repository.findAll();
	}

	public List<Unidad> selectBySubDirec(Integer subdirec) {
		return repository.buscarUnidadporSUbD(subdirec);
	}

	public Unidad unidadInsUpd(Unidad unidad) {
		return repository.save(unidad);
	}

	public Unidad unidadGet(Integer id) {
		return repository.findById(id).orElse(new Unidad());
	}

	public void unidadDel(Integer id) {
		repository.deleteById(id);
	}
}
