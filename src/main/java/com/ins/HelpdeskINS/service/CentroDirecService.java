package com.ins.HelpdeskINS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ins.HelpdeskINS.entity.CentroDirec;
import com.ins.HelpdeskINS.repository.CentroDirecRepository;

@Service
public class CentroDirecService {

	@Autowired
	CentroDirecRepository repository;
	
	//CRUD
	
			//Select
			public List<CentroDirec>centroDirecSel(){
				return repository.findAll();
				}
			
			public CentroDirec centroDirecInsUpd(CentroDirec centroDirec) {
				return repository.save(centroDirec);	
			}
			
			public CentroDirec centroDirecGet(Integer id) {
				return repository.findById(id).orElse(new CentroDirec());
			}
			
			public void centroDirecDel(Integer id) {
				repository.deleteById(id);
			}
}
