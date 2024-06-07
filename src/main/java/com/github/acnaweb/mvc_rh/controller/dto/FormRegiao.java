package com.github.acnaweb.mvc_rh.controller.dto;

import java.util.Optional;
import com.github.acnaweb.mvc_rh.model.Pais;
import com.github.acnaweb.mvc_rh.model.Regiao;

public class FormRegiao {
	private Long id;
	private String nome;
	private Long idPais;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getIdPais() {
		return idPais;
	}

	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}

	public FormRegiao toForm(Regiao regiao) {
		this.id = regiao.getId();
		this.nome = regiao.getNome();	
		this.idPais = Optional.ofNullable(regiao.getPais())
				.map(p -> p.getId())
				.orElse(null);		
		return this;
	}

	public Regiao toModel(Pais pais) {
		Regiao regiao = new Regiao();
		regiao.setId(this.getId());
		regiao.setNome(this.getNome());
		regiao.setPais(pais);
		return regiao;
	}

}
