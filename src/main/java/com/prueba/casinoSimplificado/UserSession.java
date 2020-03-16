package com.prueba.casinoSimplificado;

import java.time.Instant;

import com.prueba.casinoSimplificado.dao.Juego;
import com.prueba.casinoSimplificado.dao.Jugador;

public class UserSession {
	
	private Jugador user;
	private Juego juegoSelected;
	private Instant gameBeggining;
	
	
	public Jugador getUser() {
		return user;
	}
	public void setUser(Jugador user) {
		this.user = user;
	}
	public Juego getJuegoSelected() {
		return juegoSelected;
	}
	public void setJuegoSelected(Juego juegoSelected) {
		this.juegoSelected = juegoSelected;
	}
	public Instant getGameBeggining() {
		return gameBeggining;
	}
	public void setGameBeggining(Instant gameBeggining) {
		this.gameBeggining = gameBeggining;
	}
	
	

}
