package com.cafemv.dto;

public class MensagemDTO {
	
	String mensagem;
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public MensagemDTO(String mensagem) {
		super();
		this.mensagem = mensagem;
	}
	
	public MensagemDTO() {
		
	}

}
