package com.prueba.casinoSimplificado.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.prueba.casinoSimplificado.dao.Jugada;
import com.prueba.casinoSimplificado.repository.JugadaRepository;

@Service
public class JugadaService {

	@Resource
	private JugadaRepository jugadaRepository;
	
	public void save(Jugada jugada) {
		jugadaRepository.save(jugada);
	}
}
