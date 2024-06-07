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

import com.github.acnaweb.mvc_rh.controller.dto.FormPesquisador;
import com.github.acnaweb.mvc_rh.lov.ListOfValueBuilder;
import com.github.acnaweb.mvc_rh.model.Pesquisador;
import com.github.acnaweb.mvc_rh.model.Regiao;
import com.github.acnaweb.mvc_rh.repository.RegiaoRepository;
import com.github.acnaweb.mvc_rh.repository.PesquisadorRepository;

@Controller
@RequestMapping("pesquisadores")
public class PesquisadorController {

	@Autowired
	private PesquisadorRepository pesquisadorRepository;

	@Autowired
	private RegiaoRepository regiaoRepository;
	
	@Autowired
	private ListOfValueBuilder listOfValueBuilder;

	@GetMapping()
	public String list(Model model) {
		List<Pesquisador> pesquisadores = pesquisadorRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
		model.addAttribute("pesquisadores", pesquisadores);
		return "pesquisador/list";
	}

	@PostMapping("save")
	public String save(@ModelAttribute FormPesquisador pesquisador) {
		Regiao regiao = Optional.ofNullable(pesquisador.getIdRegiao())
				.map(id -> regiaoRepository.getReferenceById(id))
				.orElse(null);				
		Pesquisador entity = pesquisador.toModel(regiao);
		pesquisadorRepository.save(entity);
		return "redirect:/pesquisadores";
	}

	@GetMapping("add")
	public String create(Model model) {
		model.addAttribute("pesquisador", new FormPesquisador());
		model.addAttribute("lovRegioes", listOfValueBuilder.getLovRegioes());		
		return "pesquisador/form";
	}

	@GetMapping("update/{id}")
	public String update(@PathVariable Long id, Model model) {
		Pesquisador pesquisador = pesquisadorRepository.findById(id).orElse(new Pesquisador());

		model.addAttribute("pesquisador", new FormPesquisador().toForm(pesquisador));
		model.addAttribute("lovRegioes", listOfValueBuilder.getLovRegioes());		
		
		return "pesquisador/form";
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable Long id) {
		pesquisadorRepository.deleteById(id);
		return "redirect:/pesquisadores";
	}
}
