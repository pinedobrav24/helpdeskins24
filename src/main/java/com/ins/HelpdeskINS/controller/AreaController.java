
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

import com.ins.HelpdeskINS.entity.Area;
import com.ins.HelpdeskINS.service.UnidadService;
import com.ins.HelpdeskINS.service.AreaService;
import java.util.List;

@Controller
@RequestMapping("/areas")
public class AreaController {
    
    @Autowired
    AreaService service;

    @Autowired
    UnidadService unidadservice;

    @GetMapping()
	public String areaSel(Model model) {
		model.addAttribute("areas", service.areaSel());
		return "areas";
	}

    @GetMapping("buscarUnidad")
	@ResponseBody
	public List<Area> buscarUnidad(@RequestParam("Unidad") Integer value) {
		return service.selectByUnid(value);
    }

    
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("area", new Area());
		model.addAttribute("unidades", unidadservice.unidadSel());
		return "areas_insert";
	}

	@PostMapping("/insert")
	public String areaIns(@Validated Area area, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("unidades", unidadservice.unidadSel());
			return "areas_insert";
		}
		service.areaInsUpd(area);
		return "redirect:/areas";
	}

	@GetMapping("/{id}")
	public String actualizar(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("area", service.areaGet(id));
		model.addAttribute("unidades", unidadservice.unidadSel());
		return "areas_update";
	}

	@PostMapping("/update")
	public String areasUpd(@Validated Area area, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "areas_update";
		}
		service.areaInsUpd(area);
		return "redirect:/areas";
	}

	@GetMapping("/delete")
	public String areasDel(@RequestParam("id") Integer id) {
		service.areaDel(id);
		return "redirect:/areas";
	}
}
