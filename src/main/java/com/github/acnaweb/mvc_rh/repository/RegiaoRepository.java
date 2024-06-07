package com.github.acnaweb.mvc_rh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.acnaweb.mvc_rh.model.Regiao;

@Repository
public interface RegiaoRepository extends JpaRepository<Regiao, Long> {

}
