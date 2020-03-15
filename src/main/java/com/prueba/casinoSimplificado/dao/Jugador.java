package com.prueba.casinoSimplificado.dao;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="jugador")
public class Jugador {
	@Id
	@Column(name="id")
    private String id;
	
	@Column(name="alias")
	private String alias;
	
	@Column(name="tiempo_juego")
	private Integer tiempo_juego;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Proveedor proveedor;
	
	@OneToMany(mappedBy = "jugador", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Jugada> jugadas;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Integer getTiempo_juego() {
		return tiempo_juego;
	}

	public void setTiempo_juego(Integer tiempo_juego) {
		this.tiempo_juego = tiempo_juego;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public List<Jugada> getJugadas() {
		return jugadas;
	}

	public void setJugadas(List<Jugada> jugadas) {
		this.jugadas = jugadas;
	}
	
    //FOREIGN KEY (proveedor_id) REFERENCES proveedor(id)
}
