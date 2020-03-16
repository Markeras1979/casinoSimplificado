package com.prueba.casinoSimplificado.dto;

public class RuletaDTO {

	private Integer numero;
	private String color;
	private Boolean win;
	private Boolean partidaAcabada;
	
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Boolean getWin() {
		return win;
	}
	public void setWin(Boolean win) {
		this.win = win;
	}
	public Boolean getPartidaAcabada() {
		return partidaAcabada;
	}
	public void setPartidaAcabada(Boolean partidaAcabada) {
		this.partidaAcabada = partidaAcabada;
	}
	
	
}
