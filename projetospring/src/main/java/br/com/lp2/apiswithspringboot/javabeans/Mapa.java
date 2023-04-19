package br.com.lp2.apiswithspringboot.javabeans;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mapa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idMapa;
	@JsonProperty("nomeMapa")
	private String nomeMapa;
	
	public long getIdMapa() {
		return idMapa;
	}
	public void setIdMapa(long idMapa) {
		this.idMapa = idMapa;
	}
	public String getNomeMapa() {
		return nomeMapa;
	}
	public void setNomeMapa(String nomeMapa) {
		this.nomeMapa = nomeMapa;
	}
}
