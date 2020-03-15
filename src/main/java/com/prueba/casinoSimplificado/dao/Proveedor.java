package com.prueba.casinoSimplificado.dao;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="proveedor")
public class Proveedor {
	
	@Id
	@Column(name="id")
    private Integer id;
	
	@Column(name="name")
    private String name;
	
	@OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Jugador> jugadores;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
}
