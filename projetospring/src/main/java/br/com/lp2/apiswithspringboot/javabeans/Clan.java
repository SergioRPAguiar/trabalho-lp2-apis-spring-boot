package br.com.lp2.apiswithspringboot.javabeans;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Clan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idClan;
	@JsonProperty("nomeClan")
	private String nomeClan;
	
	public long getIdClan() {
		return idClan;
	}
	public void setIdClan(long idClan) {
		this.idClan = idClan;
	}
	public String getNomeClan() {
		return nomeClan;
	}
	public void setNomeClan(String nomeClan) {
		this.nomeClan = nomeClan;
	}
	
}
