package br.com.lp2.apiswithspringboot.javabeans;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Personagem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idPersonagem;
	@JsonProperty("nomePersonagem")
	private String nomePersonagem;
	
	public long getIdPersonagem() {
		return idPersonagem;
	}
	public void setIdPersonagem(long idPersonagem) {
		this.idPersonagem = idPersonagem;
	}
	public String getNomePersonagem() {
		return nomePersonagem;
	}
	public void setNomePersonagem(String nomePersonagem) {
		this.nomePersonagem = nomePersonagem;
	}
	
}
