package com.github.acnaweb.mvc_rh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.acnaweb.mvc_rh.controller.dto.FormPais;
import com.github.acnaweb.mvc_rh.model.Pais;
import com.github.acnaweb.mvc_rh.repository.PaisRepository;

@Controller
@RequestMapping("paises")
public class PaisController {

	@Autowired
	private PaisRepository paisRepository;

	@GetMapping()
	public String list(Model model) {
		List<Pais> paises = 
				paisRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
		model.addAttribute("paises", paises);
		return "pais/list";
	}

	@GetMapping("regioes")
	public String regioesByPais() {
		return "pais/list_regioes";
	}

	@GetMapping("add")
	public String create(Model model) {
		model.addAttribute("pais", new FormPais());
		return "pais/form";
	}

	@PostMapping("save")
	public String save(@ModelAttribute FormPais pais) {		
		Pais entity = pais.toModel();
		
		paisRepository.save(entity);
		return "redirect:/paises";
	}

	@GetMapping("update/{id}")
	public String update(@PathVariable Long id, Model model) {
		Pais entity = paisRepository.findById(id).orElse(new Pais());
		
		FormPais pais = new FormPais().toForm(entity);
		
		model.addAttribute("pais", pais);
		return "pais/form";
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable Long id) {
		paisRepository.deleteById(id);
		return "redirect:/paises";
	}
}
