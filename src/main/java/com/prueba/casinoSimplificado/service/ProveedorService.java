package com.prueba.casinoSimplificado.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.prueba.casinoSimplificado.repository.ProveedorRepository;

@Service
public class ProveedorService {

	@Resource
	private ProveedorRepository proveedorRepository;
}
