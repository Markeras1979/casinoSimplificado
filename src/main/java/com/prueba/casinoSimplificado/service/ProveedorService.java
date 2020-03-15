package com.prueba.casinoSimplificado.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.prueba.casinoSimplificado.dao.Proveedor;
import com.prueba.casinoSimplificado.repository.ProveedorRepository;

@Service
public class ProveedorService {

	@Resource
	private ProveedorRepository proveedorRepository;
	
	public List<Proveedor> retrieveAllProveedores(){
		return (List<Proveedor>) proveedorRepository.findAll();
	}
}
