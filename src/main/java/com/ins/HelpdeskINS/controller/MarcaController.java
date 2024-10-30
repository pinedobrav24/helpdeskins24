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

import com.ins.HelpdeskINS.service.MarcaService;
import com.ins.HelpdeskINS.entity.Marca;


@Controller
@RequestMapping("/marcas")
public class MarcaController {

	@Autowired
	MarcaService service;
	
	@GetMapping()
	public String marcaSel(Model model) {
		model.addAttribute("marcas",service.marcaSel());
		return "marcas";
	}
	

	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("marca", new Marca());
		return "marcas_insert";
	}

	@PostMapping("/insert")
	public String marcaIns(@Validated Marca marca, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("error", "Hay errores en el formulario. Por favor revisa los campos.");
			return "marcas_insert";
		}
		model.addAttribute("success", "Formulario enviado correctamente");
		service.marcaInsUpd(marca);
		return "redirect:/marcas";
	}
	
	@GetMapping("/{id}")
	public String actualizar(@PathVariable("id") Integer id,Model model) {
		model.addAttribute("marca", service.marcaGet(id));
		return "marcas_update";
	}
	
	@PostMapping("/update")
	public String marcasUpd(@Validated Marca marca, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "marcas_update";
		}
		service.marcaInsUpd(marca);
		return "redirect:/marcas";
	}
	
	@GetMapping("/delete")
	public String marcasDel(@RequestParam("id") Integer id) {
		service.marcaDel(id);
		return "redirect:/marcas";
	}
}
