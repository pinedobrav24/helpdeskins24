package com.ins.HelpdeskINS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.ins.HelpdeskINS.entity.Sector;
import com.ins.HelpdeskINS.repository.SectorRepository;

@Service
public class SectorService {
 
    @Autowired
	SectorRepository repository;

	// CRUD

	// Select
	public List<Sector> sectorSel() {
		return repository.findAll();
	}

	public List<Sector> selectBySede(Integer sedeId) {
		return repository.buscarSectorporSede(sedeId);
	}

	public Sector sectorInsUpd(Sector sector) {
		return repository.save(sector);
	}

	public Sector sectorGet(Integer id) {
		return repository.findById(id).orElse(new Sector());
	}

	public void sectorDel(Integer id) {
		repository.deleteById(id);
	}
}
