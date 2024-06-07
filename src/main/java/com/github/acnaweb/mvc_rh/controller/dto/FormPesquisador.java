package com.github.acnaweb.mvc_rh.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import com.github.acnaweb.mvc_rh.model.Pesquisador;
import com.github.acnaweb.mvc_rh.model.Regiao;

public class FormPesquisador {
	private Long id;
	private String nome;
	private LocalDate dataNascimento;
	private BigDecimal salario;
	private Long idRegiao;
	

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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Long getIdRegiao() {
		return idRegiao;
	}

	public void setIdRegiao(Long idRegiao) {
		this.idRegiao = idRegiao;
	}

	public FormPesquisador toForm(Pesquisador pesquisador) {
		this.id = pesquisador.getId();
		this.nome = pesquisador.getNome();
		this.dataNascimento = pesquisador.getDataNascimento();
		this.salario = pesquisador.getSalario();
		this.idRegiao = Optional.ofNullable(pesquisador.getRegiao())
				.map(r -> r.getId())
				.orElse(null);
		return this;
	}

	public Pesquisador toModel(Regiao regiao) {
		Pesquisador pesquisador = new Pesquisador();
		pesquisador.setId(this.getId());
		pesquisador.setNome(this.getNome());
		pesquisador.setDataNascimento(this.getDataNascimento());
		pesquisador.setRegiao(regiao);
		pesquisador.setSalario(this.getSalario());
		return pesquisador;
	}

}
