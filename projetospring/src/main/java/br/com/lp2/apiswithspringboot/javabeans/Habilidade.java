package br.com.lp2.apiswithspringboot.javabeans;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Habilidade {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idHabilidade;
	@JsonProperty("nomeHabilidade")
	private String nomeHabilidade;
	
	public long getIdHabilidade() {
		return idHabilidade;
	}
	public void setIdHabilidade(long idHabilidade) {
		this.idHabilidade = idHabilidade;
	}
	public String getNomeHabilidade() {
		return nomeHabilidade;
	}
	public void setNomeHabilidade(String nomeHabilidade) {
		this.nomeHabilidade = nomeHabilidade;
	}
	
}
