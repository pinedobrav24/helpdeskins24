package com.ins.HelpdeskINS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ins.HelpdeskINS.entity.SubDireccionOF;
import com.ins.HelpdeskINS.repository.SubDireccionOFRepository;

@Service
public class SubDireccionOFService {

	@Autowired
	SubDireccionOFRepository repository;
	
	//CRUD
	
		//Select
		public List<SubDireccionOF>subdireccionofSel(){
			return repository.findAll();
			}
		
		public SubDireccionOF subdireccionofInsUpd(SubDireccionOF subdireccionof) {
			return repository.save(subdireccionof);	
		}
		
		public SubDireccionOF subdireccionofGet(Integer id) {
			return repository.findById(id).orElse(new SubDireccionOF());
		}
		
		public void subdireccionofDel(Integer id) {
			repository.deleteById(id);
		}

		
		public List<SubDireccionOF>buscarCentro(Integer cen){
			return repository.buscarCentro(cen);
		
		}
}
