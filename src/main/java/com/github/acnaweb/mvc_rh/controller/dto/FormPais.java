package com.github.acnaweb.mvc_rh.controller.dto;

import com.github.acnaweb.mvc_rh.model.Pais;

public class FormPais {
	private Long id;
	private String nome;

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

	public FormPais toForm(Pais pais) {
		this.id = pais.getId();
		this.nome = pais.getNome();
		return this;
	}

	public Pais toModel() {
		Pais pais = new Pais();
		pais.setId(this.getId());
		pais.setNome(this.getNome());
		return pais;
	}

}
