package com.prueba.casinoSimplificado.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="jugada")
public class Jugada {
    
	
	@Id
	@Column(name="id")
    private String id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Jugador jugador;
//    jugador_id VARCHAR(50),
//    resultado VARCHAR(8),
//    apuesta BIGINT,
//    FOREIGN KEY (jugador_id) REFERENCES jugador(id)
}
