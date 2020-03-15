package com.prueba.casinoSimplificado.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.prueba.casinoSimplificado.dao.Jugador;
import com.prueba.casinoSimplificado.repository.JugadorRepository;

@Service
public class JugadorService {

	@Resource
	private JugadorRepository jugadorRepository;
	
	public Jugador findPlayerByNick(String nick) {
		return jugadorRepository.findByAlias(nick).orElse(new Jugador());
	}
}
