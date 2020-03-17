package com.prueba.casinoSimplificado.controller;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.prueba.casinoSimplificado.UserSession;
import com.prueba.casinoSimplificado.dao.Casino;
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
	
	@Resource
	UserSession userSession;
	
	
	Instant start;
	
	
	@GetMapping("/enterScreen")
	public String enterScreen(final ModelMap modelmap) {
		
		modelmap.put("proveedores", proveedorService.retrieveAllProveedores());
		return "enterScreen";
	}
	
	
	@PostMapping("/chooseGame")
	public String chooseGame(@RequestParam("jugadorInput") String jugadorInput,@RequestParam("proveedorInput") String proveedorInput,final ModelMap modelmap) {
		if(jugadorInput != null && !jugadorInput.isEmpty()) {
			userSession.setUser(jugadorService.findPlayerByNick(jugadorInput));
			if(!userSession.getUser().getId().isEmpty()) {
				//Instant start = Instant.now();
				List<Casino> casinos = casinoService.retrieveAllCasinos();
				modelmap.put("casinos", casinos);
				modelmap.put("casinosNumber", casinos.size());
				modelmap.put("alias", userSession.getUser().getAlias());
			}
		}else {
			return "enterScreen";
		}
		return "chooseGame";
	}
	
	
	@PostMapping("/playGame")
	public String playGame(@RequestParam("juegoSelected") String juegoSelected,@RequestParam("casinosInput") String casinosInput,final ModelMap modelmap) {
		Jugador jugador = userSession.getUser();
		
		userSession.setGameBeggining(Instant.now());		
		userSession.setJuegoSelected(juegoService.retrieveJuegoInfo(Integer.valueOf(juegoSelected)));
		
		modelmap.put("nick", userSession.getUser().getAlias());
		modelmap.put("juegoSelected",userSession.getJuegoSelected());
		modelmap.put("tiempoJuego",userSession.getUser().getTiempo_juego());
		modelmap.put("creditoInicial", userSession.getUser().getCredito());
		
		return "playGame";
	}
	
}
