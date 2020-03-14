package com.prueba.casinoSimplificado.dao;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
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
	private String nombre;
	
	@Column(name="premio_probabilidad")
	private String premio_probabilidad;
	
	@Column(name="apuesta_min")
	private Integer apuesta_min;
	
	@Column(name="apuesta_max")
	private Integer apuesta_max;
	
	@ManyToMany(mappedBy = "juegos")
	private List<Casino> casinos;
}
