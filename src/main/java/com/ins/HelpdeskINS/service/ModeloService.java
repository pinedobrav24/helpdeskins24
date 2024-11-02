package com.ins.HelpdeskINS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ins.HelpdeskINS.entity.Modelo;
import com.ins.HelpdeskINS.repository.ModeloRepository;


@Service
public class ModeloService {

	@Autowired
	ModeloRepository repository;

	// CRUD

	// Select
	public List<Modelo> modeloSel() {
		return repository.findAll();
	}

	public List<Modelo> selectByTipo(Integer tipo) {
		return repository.buscarTipo(tipo);
	}

	public Modelo modeloInsUpd(Modelo modelo) {
		return repository.save(modelo);
	}

	public Modelo modeloGet(Integer id) {
		return repository.findById(id).orElse(new Modelo());
	}

	public void modeloDel(Integer id) {
		repository.deleteById(id);
	}
}
