package com.prueba.casinoSimplificado.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.prueba.casinoSimplificado.dao.Jugador;

public interface JugadorRepository extends CrudRepository<Jugador, String> {
	public Optional<Jugador> findByAlias(String alias);
}
