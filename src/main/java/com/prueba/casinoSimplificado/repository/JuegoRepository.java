package com.prueba.casinoSimplificado.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prueba.casinoSimplificado.dao.Juego;

@Repository
public interface JuegoRepository extends CrudRepository<Juego,Integer> {

}
