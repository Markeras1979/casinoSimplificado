package com.prueba.casinoSimplificado.dao;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="casino")
public class Casino {
	
	@Id
	@Column(name="id")
    private Integer id;
	
	@Column(name="name")
    private String name;
	
	@JoinTable(name="casino_juego", joinColumns = @JoinColumn(name="casino_id"),inverseJoinColumns = @JoinColumn(name="juego_id", nullable = false))
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Juego> juegos;

}
