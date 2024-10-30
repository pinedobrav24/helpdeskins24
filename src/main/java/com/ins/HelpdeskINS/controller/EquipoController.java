package com.ins.HelpdeskINS.controller;

import java.util.List;
import java.util.Map;

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

import com.ins.HelpdeskINS.entity.Equipo;
import com.ins.HelpdeskINS.service.ModeloService;
import com.ins.HelpdeskINS.service.EquipoService;
import com.ins.HelpdeskINS.service.Tipo_EquipoService;

@Controller
@RequestMapping("equipos")
public class EquipoController {

	@Autowired
	EquipoService service;

	@Autowired
	ModeloService modeloService;

	@Autowired
	Tipo_EquipoService tipoEquiposervice;

	/*
	 * @GetMapping()
	 * public String equipoSel(Model model) {
	 * model.addAttribute("equipos", service.equipoSel());
	 * return "equipos";
	 * }
	 */

	@GetMapping()
	public String mostrarEquipos(Model model) {
		List<Object[]> listarEquipos = service.listarEquipos();
		model.addAttribute("equipos", listarEquipos);
		return "equipos";
	}

	/*
	 * @GetMapping()
	 * public String mostrarEquiposPri(Model model) {
	 * List<Object[]> listarPrincipales = service.listarEquiposPrincipales();
	 * model.addAttribute("equiposprincipales", listarPrincipales);
	 * return "equipos";
	 * }
	 */

	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("equipo", new Equipo());
		model.addAttribute("tipoequipos", tipoEquiposervice.tipoEquipoSel());
		model.addAttribute("modelos", modeloService.modeloSel());
		model.addAttribute("equiposprincipales", service.listarEquiposPrincipales());
		return "equipos_insert";
	}

	@PostMapping("/insert")
	public String equipoIns(@Validated Equipo equipo, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("tipoequipos", tipoEquiposervice.tipoEquipoSel());
			model.addAttribute("modelos", modeloService.modeloSel());
			model.addAttribute("equiposprincipales", service.listarEquiposPrincipales());
			return "equipos_insert";
		}
		service.equipoInsUpd(equipo);
		return "redirect:/equipos";
	}

	@GetMapping("/{id}")
	public String actualizar(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("equipo", service.equipoGet(id));
		model.addAttribute("tipoequipos", tipoEquiposervice.tipoEquipoSel());
		model.addAttribute("modelos", modeloService.modeloSel());
		model.addAttribute("equiposprincipales", service.listarEquiposPrincipales());
		return "equipos_update";
	}

	@PostMapping("/update")
	public String equiposUpd(@Validated Equipo equipo, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "equipos_update";
		}
		service.equipoInsUpd(equipo);
		return "redirect:/equipos";
	}

	@GetMapping("/delete")
	public String equiposDel(@RequestParam("id") Integer id) {
		service.equipoDel(id);
		return "redirect:/equipos";
	}
}
