package com.prueba.casinoSimplificado.dao;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="juego")
public class Juego {
	
	public Juego() {}
		
	public Juego(Integer id, String nombre, String premio_probabilidad, Integer apuesta_min, Integer apuesta_max) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.premio_probabilidad = premio_probabilidad;
		this.apuesta_min = apuesta_min;
		this.apuesta_max = apuesta_max;
	}

	@Id
	@Column(name="id")
    private Integer id;
	
	@Column(name="nombre")
	public String nombre;
	
	@Column(name="premio_probabilidad")
	private String premio_probabilidad;
	
	@Column(name="apuesta_min")
	private Integer apuesta_min;
	
	@Column(name="apuesta_max")
	private Integer apuesta_max;
	
	@ManyToMany(mappedBy = "juegos",fetch = FetchType.LAZY)
	private List<Casino> casinos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPremio_probabilidad() {
		return premio_probabilidad;
	}

	public void setPremio_probabilidad(String premio_probabilidad) {
		this.premio_probabilidad = premio_probabilidad;
	}

	public Integer getApuesta_min() {
		return apuesta_min;
	}

	public void setApuesta_min(Integer apuesta_min) {
		this.apuesta_min = apuesta_min;
	}

	public Integer getApuesta_max() {
		return apuesta_max;
	}

	public void setApuesta_max(Integer apuesta_max) {
		this.apuesta_max = apuesta_max;
	}

	public List<Casino> getCasinos() {
		return casinos;
	}

	public void setCasinos(List<Casino> casinos) {
		this.casinos = casinos;
	}
}
