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


import com.ins.HelpdeskINS.entity.Tipo_Equipo;
import com.ins.HelpdeskINS.service.Tipo_EquipoService;

@Controller
@RequestMapping("/tipo_equipos")
public class Tipo_EquipoController {

	@Autowired
	Tipo_EquipoService service;

	@GetMapping()
	public String tipoEquipoSel(Model model) {
		model.addAttribute("tipoEquipos",service.tipoEquipoSel());
		return "tipo_equipos";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("tipoEquipo", new Tipo_Equipo());
		return "tipo_equipos_insert";
	}

	@PostMapping("/insert")
	public String tipoEquipoIns(@Validated Tipo_Equipo tipoEquipo, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("error", "Hay errores en el formulario. Por favor revisa los campos.");
			return "tipo_equipos_insert";
		}
		model.addAttribute("success", "Formulario enviado correctamente");
		service.tipoEquipoInsUpd(tipoEquipo);
		return "redirect:/tipo_equipos";
	}
	
	@GetMapping("/{id}")
	public String actualizar(@PathVariable("id") Integer id,Model model) {
		model.addAttribute("tipoEquipo", service.tipoEquipoGet(id));
		return "tipo_equipos_update";
	}
	
	@PostMapping("/update")
	public String tipoEquiposUpd(@Validated Tipo_Equipo tipoEquipo, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "tipo_equipos_update";
		}
		service.tipoEquipoInsUpd(tipoEquipo);
		return "redirect:/tipo_equipos";
	}
	
	@GetMapping("/delete")
	public String tipoEquiposDel(@RequestParam("id") Integer id) {
		service.tipoEquipoDel(id);
		return "redirect:/tipo_equipos";
	}
}

