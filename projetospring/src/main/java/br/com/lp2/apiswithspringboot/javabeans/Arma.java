package br.com.lp2.apiswithspringboot.javabeans;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Arma {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idArma;
	@JsonProperty("nomeArma")
	private String nomeArma;
	
	public long getIdArma() {
		return idArma;
	}
	public void setIdArma(long idArma) {
		this.idArma = idArma;
	}
	public String getNomeArma() {
		return nomeArma;
	}
	public void setNomeArma(String nomeArma) {
		this.nomeArma = nomeArma;
	}
	
	
}


