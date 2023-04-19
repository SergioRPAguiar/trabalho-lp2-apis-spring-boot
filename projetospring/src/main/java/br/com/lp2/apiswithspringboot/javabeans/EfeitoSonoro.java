package br.com.lp2.apiswithspringboot.javabeans;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EfeitoSonoro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idEfeitoSonoro;
	@JsonProperty("nomeEfeitoSonoro")
	private String nomeEfeitoSonoro;
	
	public long getIdEfeitoSonoro() {
		return idEfeitoSonoro;
	}
	public void setIdEfeitoSonoro(long idEfeitoSonoro) {
		this.idEfeitoSonoro = idEfeitoSonoro;
	}
	public String getNomeEfeitoSonoro() {
		return nomeEfeitoSonoro;
	}
	public void setNomeEfeitoSonoro(String nomeEfeitoSonoro) {
		this.nomeEfeitoSonoro = nomeEfeitoSonoro;
	}
}
