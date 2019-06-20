package com.example.dto;

import java.io.Serializable;

public class PeopleDto implements Serializable {
   
	private static final long serialVersionUID = 2492247794949955482L;

	private String nome;
	
	private String cognome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
		
}
