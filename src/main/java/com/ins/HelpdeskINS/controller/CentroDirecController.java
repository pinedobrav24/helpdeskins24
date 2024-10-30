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

import com.ins.HelpdeskINS.entity.CentroDirec;
import com.ins.HelpdeskINS.service.CentroDirecService;

@Controller
@RequestMapping("/centro_direcciones")
public class CentroDirecController {
	
	@Autowired
	CentroDirecService service;
	
	@GetMapping()
	public String centroDirecSel(Model model) {
		model.addAttribute("centros",service.centroDirecSel());
		return "centro_direcciones";
	}
	

	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("centroDirec", new CentroDirec());
		return "centro_direcciones_insert";
	}

	@PostMapping("/insert")
	public String centroDirecIns(@Validated CentroDirec centroDirec, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("error", "Hay errores en el formulario. Por favor revisa los campos.");
			return "centro_direcciones_insert";
		}
		model.addAttribute("success", "Formulario enviado correctamente");
		service.centroDirecInsUpd(centroDirec);
		return "redirect:/centro_direcciones";
	}
	
	@GetMapping("/{id}")
	public String actualizar(@PathVariable("id") Integer id,Model model) {
		model.addAttribute("centroDirec", service.centroDirecGet(id));
		return "centro_direcciones_update";
	}
	
	@PostMapping("/update")
	public String centroDirecsUpd(@Validated CentroDirec centroDirec, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "centro_direcciones_update";
		}
		service.centroDirecInsUpd(centroDirec);
		return "redirect:/centro_direcciones";
	}
	
	@GetMapping("/delete")
	public String centroDirecsDel(@RequestParam("id") Integer id) {
		service.centroDirecDel(id);
		return "redirect:/centro_direcciones";
	}
}
