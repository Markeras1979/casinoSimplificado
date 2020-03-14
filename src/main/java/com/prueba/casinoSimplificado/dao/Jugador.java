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
	
    //FOREIGN KEY (proveedor_id) REFERENCES proveedor(id)
}
