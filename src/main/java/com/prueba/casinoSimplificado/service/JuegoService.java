package com.prueba.casinoSimplificado.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.prueba.casinoSimplificado.dao.Juego;
import com.prueba.casinoSimplificado.repository.JuegoRepository;

@Service
public class JuegoService {

	@Resource
	private JuegoRepository juegoRepo;
	
	public Juego retrieveJuegoInfo(Integer id) {
		 return  juegoRepo.findById(id).orElse(new Juego(1,"Brisca", "25%", 20, 200));
	}
	
	public List<Juego> retrieveAllJuego(){
		return (ArrayList<Juego>) juegoRepo.findAll();
	}
	
	public void saveJuego(List<Juego> juegos) {
		juegoRepo.saveAll(juegos);
	}
}
