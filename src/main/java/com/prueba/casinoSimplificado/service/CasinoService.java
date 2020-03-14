package com.prueba.casinoSimplificado.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.prueba.casinoSimplificado.repository.CasinoRepository;

@Service
public class CasinoService {

	@Resource
	private CasinoRepository casinoRepository;
}
