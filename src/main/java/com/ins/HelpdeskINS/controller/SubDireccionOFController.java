package com.ins.HelpdeskINS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ins.HelpdeskINS.entity.SubDireccionOF;
import com.ins.HelpdeskINS.service.CentroDirecService;
import com.ins.HelpdeskINS.service.SubDireccionOFService;
import com.ins.HelpdeskINS.service.Tipo_EquipoService;

@Controller
@RequestMapping("/subdireccionesof")
public class SubDireccionOFController {

	@Autowired
	SubDireccionOFService service;
	
	@Autowired
	CentroDirecService centroService;
	
	@GetMapping()
	public String subdireccionofSel(Model model) {
		model.addAttribute("subdireccionesof",service.subdireccionofSel());
		return "subdireccionesof";
	}
	
	
	@GetMapping("buscarCent")
	public String buscarCent(Model model, @RequestParam("centro")Integer value) {
		model.addAttribute("subdireccionesof",service.buscarCentro(value));
		return "subdireccionesof";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("subdireccionof", new SubDireccionOF());
		model.addAttribute("centros", centroService.centroDirecSel());
		return "subdireccionesof_insert";
	}

	@PostMapping("/insert")
	public String subdireccionofIns(@Validated SubDireccionOF subdireccionof, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("centros", centroService.centroDirecSel());
			model.addAttribute("error", "Hay errores en el formulario. Por favor revisa los campos.");
			return "subdireccionesof_insert";
		}
		model.addAttribute("success", "Formulario enviado correctamente");
		service.subdireccionofInsUpd(subdireccionof);
		return "redirect:/subdireccionesof";
	}
	
	@GetMapping("/{id}")
	public String actualizar(@PathVariable("id") Integer id,Model model) {
		model.addAttribute("centros", centroService.centroDirecSel());
		model.addAttribute("subdireccionof", service.subdireccionofGet(id));
		return "subdireccionesof_update";
	}
	
	@PostMapping("/update")
	public String subdireccionofsUpd(@Validated SubDireccionOF subdireccionof, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "subdireccionesof_update";
		}
		service.subdireccionofInsUpd(subdireccionof);
		return "redirect:/subdireccionesof";
	}
	
	@GetMapping("/delete")
	public String subdireccionofsDel(@RequestParam("id") Integer id) {
		service.subdireccionofDel(id);
		return "redirect:/subdireccionesof";
	}
}
