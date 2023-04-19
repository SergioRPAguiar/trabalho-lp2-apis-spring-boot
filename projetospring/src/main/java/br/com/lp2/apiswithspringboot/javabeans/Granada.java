package br.com.lp2.apiswithspringboot.javabeans;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Granada {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idGranada;
	@JsonProperty("nomeGranada")
	private String nomeGranada;
	
	public long getIdGranada() {
		return idGranada;
	}
	public void setIdGranada(long idGranada) {
		this.idGranada = idGranada;
	}
	public String getNomeGranada() {
		return nomeGranada;
	}
	public void setNomeGranada(String nomeGranada) {
		this.nomeGranada = nomeGranada;
	}
	
}
