
package com.github.acnaweb.mvc_rh.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pesquisadores")
public class Pesquisador extends AbstractEntity<Long> {

	@Column(name = "nome_pesquisador", nullable = false, length = 60)
	private String nome;

	@Column(nullable = true, columnDefinition = "DATE")
	private LocalDate dataNascimento;

	//trocar dps - exemplo numérico
	@Column(nullable = true, columnDefinition = "NUMERIC(15,2)")
	private BigDecimal salario;

	@ManyToOne
	@JoinColumn(name = "regiao_id_fk", nullable = true)
	private Regiao regiao;

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

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

	

	

}
