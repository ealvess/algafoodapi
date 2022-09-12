package com.algaworks.algafood.domain.model;

public enum StatusPedido {

	CRIADO("Criado"),
	CONFIRMADO("Confirmado"),
	ENTREGUE("Entregue"),
	CANCELADO("Cancelado");
	
	private String descricao;
	
	private StatusPedido(String desricao) {
		this.descricao = desricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}