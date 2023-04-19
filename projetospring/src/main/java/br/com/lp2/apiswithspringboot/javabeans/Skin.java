package br.com.lp2.apiswithspringboot.javabeans;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Skin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idSkin;
	@JsonProperty("nomeSkin")
	private String nomeSkin;
	
	public long getIdSkin() {
		return idSkin;
	}
	public void setIdSkin(long idSkin) {
		this.idSkin = idSkin;
	}
	public String getNomeSkin() {
		return nomeSkin;
	}
	public void setNomeSkin(String nomeSkin) {
		this.nomeSkin = nomeSkin;
	}
}
