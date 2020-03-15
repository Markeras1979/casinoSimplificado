package com.prueba.casinoSimplificado.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.prueba.casinoSimplificado.dao.Casino;
import com.prueba.casinoSimplificado.repository.CasinoRepository;

@Service
public class CasinoService {

	@Resource
	private CasinoRepository casinoRepository;
	
	public List<Casino> retrieveAllCasinos() {
		return (ArrayList<Casino>) casinoRepository.findAll();
	}
}
