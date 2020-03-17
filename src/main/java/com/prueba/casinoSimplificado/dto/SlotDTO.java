package com.prueba.casinoSimplificado.dto;

public class SlotDTO {
	
	private String slot1;
	private String slot2;
	private String slot3;
	private Integer prize;
	private Integer creditsAmount;
	private Integer apuestaMinima;
	private Boolean partidaAcabada;
	
	public String getSlot1() {
		return slot1;
	}
	public void setSlot1(String slot1) {
		this.slot1 = slot1;
	}
	public String getSlot2() {
		return slot2;
	}
	public void setSlot2(String slot2) {
		this.slot2 = slot2;
	}
	public String getSlot3() {
		return slot3;
	}
	public void setSlot3(String slot3) {
		this.slot3 = slot3;
	}
	public Integer getPrize() {
		return prize;
	}
	public void setPrize(Integer prize) {
		this.prize = prize;
	}
	public Boolean getPartidaAcabada() {
		return partidaAcabada;
	}
	public void setPartidaAcabada(Boolean partidaAcabada) {
		this.partidaAcabada = partidaAcabada;
	}
	public Integer getCreditsAmount() {
		return creditsAmount;
	}
	public void setCreditsAmount(Integer creditsAmount) {
		this.creditsAmount = creditsAmount;
	}
	public Integer getApuestaMinima() {
		return apuestaMinima;
	}
	public void setApuestaMinima(Integer apuestaMinima) {
		this.apuestaMinima = apuestaMinima;
	}
	
	
}
