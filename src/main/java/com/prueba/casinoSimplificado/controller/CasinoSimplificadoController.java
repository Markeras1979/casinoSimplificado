package com.prueba.casinoSimplificado.controller;

import java.time.Instant;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.prueba.casinoSimplificado.dao.Jugador;
import com.prueba.casinoSimplificado.service.CasinoService;
import com.prueba.casinoSimplificado.service.JuegoService;
import com.prueba.casinoSimplificado.service.JugadaService;
import com.prueba.casinoSimplificado.service.JugadorService;
import com.prueba.casinoSimplificado.service.ProveedorService;

@Controller
public class CasinoSimplificadoController {
	
	@Resource
	private Gson gson;
	
	@Resource
	private JuegoService juegoService;
	
	@Resource
	private JugadorService jugadorService;
	
	@Resource
	private CasinoService casinoService;
	
	@Resource
	private ProveedorService proveedorService;
	
	@Resource
	private JugadaService jugadaService;
	
	@GetMapping("/enterScreen")
	public String enterScreen(final ModelMap modelmap) {
		
//		juegoService.saveJuego(juegos);
		//modelmap.put("testJuego",juegoService.retrieveJuegoInfo(1));
		//modelmap.put("testJuego2","test modelMap");
		//modelmap.put("testJuego3", juegoService.retrieveAllJuego());
		modelmap.put("proveedores", proveedorService.retrieveAllProveedores());
//		modelmap.put("casino1Juego1", gson.toJson(casinoService.retrieveAllCasinos().get(0).getJuegos().get(0).getNombre()));
//		modelmap.put("casino1Juego2", gson.toJson(casinoService.retrieveAllCasinos().get(0).getJuegos().get(1).getNombre()));
//		modelmap.put("casino1Juego3", gson.toJson(casinoService.retrieveAllCasinos().get(0).getJuegos().get(2).getNombre()));
//		modelmap.put("casino1Juego4", gson.toJson(casinoService.retrieveAllCasinos().get(0).getJuegos().get(3).getNombre()));
		return "enterScreen";
	}
	
	
	@PostMapping("/chooseGame")
	public String chooseGame(@RequestParam("jugadorInput") String jugadorInput,@RequestParam("proveedorInput") String proveedorInput,final ModelMap modelmap) {
		if(jugadorInput != null && !jugadorInput.isEmpty()) {
			Jugador jugador = jugadorService.findPlayerByNick(jugadorInput);
			if(!jugador.getId().isEmpty()) {
				Instant start = Instant.now();
				modelmap.put("alias", jugador.getAlias());
			}
		}else {
			return "enterScreen";
		}
		return "chooseGame";
	}
	
}
