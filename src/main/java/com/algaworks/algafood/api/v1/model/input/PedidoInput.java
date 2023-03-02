package com.algaworks.algafood.api.v1.model.input;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoInput {

	@ApiModelProperty(example = "1")
	@Valid
	@NotNull
	private RestauranteIdInput restaurante;
	
	@ApiModelProperty(example = "Cartão de crédito", required = true)
	@Valid
	@NotNull
	private FormaPagamentoIdInput formaPagamento;
	
	@ApiModelProperty(example = "Rua Melvin Jones")
	@Valid
	@NotNull
	private EnderecoInput enderecoEntrega;
	
	@Valid
	@NotNull
	@Size(min = 1)
	private List<ItemPedidoInput> itens;
}
