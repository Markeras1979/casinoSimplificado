package com.prueba.casinoSimplificado.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.google.gson.Gson;
import com.prueba.casinoSimplificado.dao.Juego;
import com.prueba.casinoSimplificado.service.JuegoService;

@Controller
public class CasinoSimplificadoController {
	
	@Resource
	private Gson gson;
	
	@Resource
	private JuegoService juegoService;
	
	@GetMapping("/enterScreen")
	public String enterScreen(final ModelMap modelmap) {
//		List<Juego> juegos = new ArrayList<Juego>();
//		for (int i = 1; i < 6; i++) {
//			Juego jg = new Juego(i,"JuegoTest"+i,"10%",10,20);
//			juegos.add(jg);
//		}
//		juegoService.saveJuego(juegos);
		modelmap.put("testJuego",gson.toJson(juegoService.retrieveJuegoInfo(1),Juego.class));
		modelmap.put("testJuego2","test modelMap");
		modelmap.put("testJuego3", gson.toJson(juegoService.retrieveAllJuego()));
		return "enterScreen";
	}
	
}
