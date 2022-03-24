package com.cafemv.dto;

public class CafeDTO {
	
	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private String cafe;

	public CafeDTO(Long id, String nome, String cpf, String cafe) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.cafe = cafe;
	}
	
	
	public CafeDTO() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getCafe() {
		return cafe;
	}


	public void setCafe(String cafe) {
		this.cafe = cafe;
	}
	
	
}

