package com.prueba.casinoSimplificado.dao;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="casino")
public class Casino {
	
	@Id
	@Column(name="id")
    private Integer id;
	
	@Column(name="name")
    private String name;
	
	@JoinTable(name="casino_juego", joinColumns = @JoinColumn(name="casino_id"),inverseJoinColumns = @JoinColumn(name="juego_id", nullable = false))
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public List<Juego> juegos;

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

	public List<Juego> getJuegos() {
		return juegos;
	}

	public void setJuegos(List<Juego> juegos) {
		this.juegos = juegos;
	}

}
