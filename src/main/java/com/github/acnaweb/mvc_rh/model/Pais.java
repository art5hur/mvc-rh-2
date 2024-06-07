package com.github.acnaweb.mvc_rh.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "paises")
public class Pais extends AbstractEntity<Long> {

	@Column(nullable = false, length = 60, unique = true)
	private String nome;

	@OneToMany(mappedBy = "pais")
	private List<Pais> paises;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Pais> getPaises() {
		return paises;
	}

	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}

	

}
