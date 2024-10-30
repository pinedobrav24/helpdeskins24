package com.ins.HelpdeskINS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ins.HelpdeskINS.entity.Marca;
import com.ins.HelpdeskINS.repository.MarcaRepository;

@Service
public class MarcaService {
	
	@Autowired
	MarcaRepository repository;
	
	//CRUD
	
		//Select
		public List<Marca>marcaSel(){
			return repository.findAll();
			}
		
		public Marca marcaInsUpd(Marca marca) {
			return repository.save(marca);	
		}
		
		public Marca marcaGet(Integer id) {
			return repository.findById(id).orElse(new Marca());
		}
		
		public void marcaDel(Integer id) {
			repository.deleteById(id);
		}
}
