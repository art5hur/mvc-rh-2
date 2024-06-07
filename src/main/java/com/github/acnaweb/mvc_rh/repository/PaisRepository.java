package com.github.acnaweb.mvc_rh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.acnaweb.mvc_rh.model.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {

}
