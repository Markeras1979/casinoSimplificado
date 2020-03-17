package com.prueba.casinoSimplificado.controller;

import java.time.Instant;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.casinoSimplificado.UserSession;
import com.prueba.casinoSimplificado.dao.Jugada;
import com.prueba.casinoSimplificado.dto.SlotDTO;
import com.prueba.casinoSimplificado.juegosAPI.Slot;
import com.prueba.casinoSimplificado.service.JugadaService;

@RestController
public class SlotController {
	@Resource
	UserSession userSession;
	
	@Resource
	JugadaService jugadaService;
	
	@ResponseBody()
	@PostMapping(value = "/jugadaSlot",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public SlotDTO jugadaSlot() {
		Long beggining =userSession.getGameBeggining().toEpochMilli();
		Long now = Instant.now().toEpochMilli();
		SlotDTO retorno = new SlotDTO();
		double diff = (now-beggining)/600;
		retorno.setApuestaMinima(userSession.getJuegoSelected().getApuesta_min());
		Integer credito = userSession.getUser().getCredito();
		if(diff < userSession.getUser().getTiempo_juego() && userSession.getUser().getCredito() >= 
		userSession.getJuegoSelected().getApuesta_min()) {
			
			userSession.getUser().setCredito(userSession.getUser().getCredito()-userSession.getJuegoSelected().getApuesta_min());
			Slot slot = new Slot();
			retorno = slot.getJugada(userSession.getJuegoSelected().getPremio_probabilidad());
			calculatePrize(retorno);
			Jugada jugada = new Jugada();
			jugada.setJuego(userSession.getJuegoSelected());
			jugada.setJugador(userSession.getUser());
			jugada.setResultado(retorno.getPrize()>0?"OK":"KO");
			
			try {
				jugadaService.save(jugada);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}else{
			
			retorno.setPartidaAcabada(true);
			retorno.setPrize(0);
			retorno.setCreditsAmount(userSession.getUser().getCredito());
		}
		
		return retorno;
	}

	private void calculatePrize(SlotDTO retorno) {
		if(retorno.getPrize() > 0) {
			userSession.getUser().setCredito(userSession.getUser().getCredito()+retorno.getPrize());
		}
		retorno.setCreditsAmount(userSession.getUser().getCredito());
	}
	
}
