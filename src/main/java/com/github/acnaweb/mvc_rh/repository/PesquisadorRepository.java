package com.github.acnaweb.mvc_rh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.acnaweb.mvc_rh.model.Pesquisador;

@Repository
public interface PesquisadorRepository extends JpaRepository<Pesquisador, Long> {

}
