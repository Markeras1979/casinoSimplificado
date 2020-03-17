package com.prueba.casinoSimplificado.controller;

import java.time.Instant;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.casinoSimplificado.UserSession;
import com.prueba.casinoSimplificado.dao.Jugada;
import com.prueba.casinoSimplificado.dto.RuletaDTO;
import com.prueba.casinoSimplificado.juegosAPI.Ruleta;
import com.prueba.casinoSimplificado.service.JugadaService;

@RestController
public class RuletaController {
	
	@Resource
	UserSession userSession;
	
	@Resource
	JugadaService jugadaService;
	
	@ResponseBody()
	@PostMapping(value = "/jugadaRuleta",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public RuletaDTO jugadaRuleta(@RequestBody() final RuletaDTO params) {
		Long beggining =userSession.getGameBeggining().toEpochMilli();
		Long now = Instant.now().toEpochMilli();
		RuletaDTO retorno = new RuletaDTO();
		double diff = (now-beggining)/600;
		
		if(diff < userSession.getUser().getTiempo_juego()) {
			Ruleta ruleta = new Ruleta();
			retorno = ruleta.getJugada(Integer.valueOf(params.getNumero()), params.getColor(), userSession.getJuegoSelected().getPremio_probabilidad());
			Jugada jugada = new Jugada();
			jugada.setJuego(userSession.getJuegoSelected());
			jugada.setJugador(userSession.getUser());
			jugada.setResultado(retorno.getWin()? "OK":"KO");
			
			try {
				jugadaService.save(jugada);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		}else {
			retorno.setPartidaAcabada(true);
			retorno.setColor("");
			retorno.setNumero(0);
			retorno.setWin(false);
		}
		
		

		return retorno;
	}
	
}
