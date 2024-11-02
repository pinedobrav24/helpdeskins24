package com.ins.HelpdeskINS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.ins.HelpdeskINS.entity.Area;
import com.ins.HelpdeskINS.repository.AreaRepository;

@Service
public class AreaService {
    @Autowired
	AreaRepository repository;



	// CRUD

	// Select
	public List<Area> areaSel() {
		return repository.findAll();
	}

	public List<Area> selectByUnid(Integer unidad) {
		return repository.buscarAreaporUnd(unidad);
	}

	public Area areaInsUpd(Area area) {
		return repository.save(area);
	}

	public Area areaGet(Integer id) {
		return repository.findById(id).orElse(new Area());
	}

	public void areaDel(Integer id) {
		repository.deleteById(id);
	}
}
