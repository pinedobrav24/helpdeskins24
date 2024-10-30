package com.ins.HelpdeskINS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ins.HelpdeskINS.entity.Modelo;
import com.ins.HelpdeskINS.repository.ModeloRepository;
import com.ins.HelpdeskINS.service.MarcaService;
import com.ins.HelpdeskINS.service.ModeloService;
import com.ins.HelpdeskINS.service.Tipo_EquipoService;

@Controller
@RequestMapping("/modelos")
public class ModeloController {

	@Autowired
	ModeloService service;

	@Autowired
	MarcaService marcaService;

	@Autowired
	Tipo_EquipoService tipoEquiposervice;

	@Autowired
	ModeloRepository repository;

	@GetMapping()
	public String modeloSel(Model model) {
		model.addAttribute("modelos", service.modeloSel());
		return "modelos";
	}

	/*
	 * @GetMapping("buscarTipo")
	 * public String buscarTipo(Model model, @RequestParam("tipoEquipo") Integer
	 * value) {
	 * model.addAttribute("modelos", service.selectByTipo(value));
	 * return "modelos";
	 * }
	 */

	@GetMapping("buscarTipo")
	@ResponseBody
	public List<Modelo> buscarTipo(@RequestParam("tipoEquipo") Integer value) {
		return service.selectByTipo(value);
	}

	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("modelo", new Modelo());
		model.addAttribute("marcas", marcaService.marcaSel());
		model.addAttribute("tipoequipos", tipoEquiposervice.tipoEquipoSel());
		return "modelos_insert";
	}

	@PostMapping("/insert")
	public String modeloIns(@Validated Modelo modelo, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("marcas", marcaService.marcaSel());
			model.addAttribute("tipoequipos", tipoEquiposervice.tipoEquipoSel());
			return "modelos_insert";
		}
		service.modeloInsUpd(modelo);
		return "redirect:/modelos";
	}

	@GetMapping("/{id}")
	public String actualizar(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("modelo", service.modeloGet(id));
		model.addAttribute("marcas", marcaService.marcaSel());
		model.addAttribute("tipoequipos", tipoEquiposervice.tipoEquipoSel());
		return "modelos_update";
	}

	@PostMapping("/update")
	public String modelosUpd(@Validated Modelo modelo, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "modelos_update";
		}
		service.modeloInsUpd(modelo);
		return "redirect:/modelos";
	}

	@GetMapping("/delete")
	public String modelosDel(@RequestParam("id") Integer id) {
		service.modeloDel(id);
		return "redirect:/modelos";
	}
}
