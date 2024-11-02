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
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

import com.ins.HelpdeskINS.entity.Unidad;
import com.ins.HelpdeskINS.service.SubDireccionOFService;
import com.ins.HelpdeskINS.service.UnidadService;

@Controller
@RequestMapping("/unidades")
public class UnidadController {

    @Autowired
    UnidadService service;

    @Autowired
    SubDireccionOFService subdireccionservice;

    @GetMapping()
	public String unidadSel(Model model) {
		model.addAttribute("unidades", service.unidadSel());
		return "unidades";
	}

   @GetMapping("buscarUnidad")
	@ResponseBody
	public List<Unidad> buscarUnidad(@RequestParam("SubDireccionOF") Integer value) {
		return service.selectBySubDirec(value);
	}

    
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("unidad", new Unidad());
		model.addAttribute("subdirecciones", subdireccionservice.subdireccionofSel());
		return "unidades_insert";
	}

	@PostMapping("/insert")
	public String unidadIns(@Validated Unidad unidad, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("subdirecciones", subdireccionservice.subdireccionofSel());
			return "unidades_insert";
		}
		service.unidadInsUpd(unidad);
		return "redirect:/unidades";
	}

	@GetMapping("/{id}")
	public String actualizar(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("unidad", service.unidadGet(id));
		model.addAttribute("subdirecciones", subdireccionservice.subdireccionofSel());
		return "unidades_update";
	}

	@PostMapping("/update")
	public String unidadesUpd(@Validated Unidad unidad, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "unidades_update";
		}
		service.unidadInsUpd(unidad);
		return "redirect:/unidades";
	}

	@GetMapping("/delete")
	public String unidadesDel(@RequestParam("id") Integer id) {
		service.unidadDel(id);
		return "redirect:/unidades";
	}
}
