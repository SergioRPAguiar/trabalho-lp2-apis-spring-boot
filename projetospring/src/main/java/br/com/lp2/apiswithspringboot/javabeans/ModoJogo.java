package br.com.lp2.apiswithspringboot.javabeans;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ModoJogo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idModoJogo;
	@JsonProperty("nomeModoJogo")
	private String nomeModoJogo;
	
	public long getIdModoJogo() {
		return idModoJogo;
	}
	public void setIdModoJogo(long idModoJogo) {
		this.idModoJogo = idModoJogo;
	}
	public String getNomeModoJogo() {
		return nomeModoJogo;
	}
	public void setNomeModoJogo(String nomeModoJogo) {
		this.nomeModoJogo = nomeModoJogo;
	}
	
}
