package com.github.acnaweb.mvc_rh.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "regioes")
public class Regiao extends AbstractEntity<Long> {

	@Column(nullable = false, length = 50, unique = true)
	private String nome;

	@ManyToOne
	@JoinColumn(name = "id_pais_fk")
	private Pais pais;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	
	
	
}
