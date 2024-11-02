package com.ins.HelpdeskINS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ins.HelpdeskINS.entity.Sede;
import com.ins.HelpdeskINS.repository.SedeRepository;

import java.util.List;

@Service
public class SedeService {

    @Autowired
	SedeRepository repository;

	// CRUD

	// Select
	public List<Sede> SedeSel() {
		return repository.findAll();
	}

	public Sede sedeInsUpd(Sede sede) {
		return repository.save(sede);
	}

	public Sede sedeGet(Integer id) {
		return repository.findById(id).orElse(new Sede());
	}

	public void sedeDel(Integer id) {
		repository.deleteById(id);
	}
}
