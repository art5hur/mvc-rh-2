package com.github.acnaweb.mvc_rh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.acnaweb.mvc_rh.controller.dto.FormRegiao;
import com.github.acnaweb.mvc_rh.lov.ListOfValueBuilder;
import com.github.acnaweb.mvc_rh.model.Pais;
import com.github.acnaweb.mvc_rh.model.Regiao;
import com.github.acnaweb.mvc_rh.repository.RegiaoRepository;
import com.github.acnaweb.mvc_rh.repository.PaisRepository;

@Controller
@RequestMapping("regioes")
public class RegiaoController {

	@Autowired
	private RegiaoRepository regiaoRepository;

	@Autowired
	private PaisRepository paisRepository;
	
	@Autowired
	private ListOfValueBuilder listOfValueBuilder;

	@GetMapping()
	public String list(Model model) {
		List<Regiao> regioes = regiaoRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
		model.addAttribute("regioes", regioes);
		return "regiao/list";
	}

	@GetMapping("add")
	public String create(Model model) {
		
		model.addAttribute("regiao", new FormRegiao());
		model.addAttribute("lovPaises", 
				listOfValueBuilder.getLovPaises());
		return "regiao/form";
	}

	@PostMapping("save")
	public String save(@ModelAttribute FormRegiao regiao) {		
		Pais pais =
				Optional.ofNullable(regiao.getIdPais())
				.map(id -> paisRepository.getReferenceById(id))
				.orElse(null);						

		Regiao entity = regiao.toModel(pais);
		regiaoRepository.save(entity);
		return "redirect:/regioes";
	}

	@GetMapping("update/{id}")
	public String update(@PathVariable Long id, Model model) {
		Regiao entity = regiaoRepository.findById(id).orElse(new Regiao());

		FormRegiao regiao = new FormRegiao().toForm(entity);
		model.addAttribute("regiao", regiao);
		model.addAttribute("lovPaises", 
				listOfValueBuilder.getLovPaises());		
		return "regiao/form";
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable Long id) {
		regiaoRepository.deleteById(id);
		return "redirect:/regioes";
	}

}
