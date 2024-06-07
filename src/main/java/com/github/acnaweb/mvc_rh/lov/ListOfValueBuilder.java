package com.github.acnaweb.mvc_rh.lov;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.github.acnaweb.mvc_rh.repository.RegiaoRepository;
import com.github.acnaweb.mvc_rh.repository.PaisRepository;

@Component
public class ListOfValueBuilder {
	
	@Autowired
	private PaisRepository paisRepository;

	@Autowired
	private RegiaoRepository regiaoRepository;

	public List<ListOfValue> getLovPaises() {			
		return paisRepository
				.findAll(Sort.by(Sort.Direction.ASC, "nome"))
				.stream()
				.map(p -> new ListOfValue(p.getId(), p.getNome()))
				.toList();
	}

	public List<ListOfValue> getLovRegioes() {
		return regiaoRepository
				.findAll(Sort.by(Sort.Direction.ASC, "nome"))
				.stream()
				.map(r -> new ListOfValue(r.getId(), r.getNome()))
				.toList();
	}

}
