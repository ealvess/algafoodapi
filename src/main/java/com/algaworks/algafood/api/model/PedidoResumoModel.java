package com.algaworks.algafood.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

//@JsonFilter("pedidoFilter")
@Getter
@Setter
public class PedidoResumoModel {

	@ApiModelProperty(example = "1")
	private String codigo;
	
	@ApiModelProperty(example = "298.90")
    private BigDecimal subtotal;
	
	@ApiModelProperty(example = "10.0")
    private BigDecimal taxaFrete;
	
	@ApiModelProperty(example = "308.90")
    private BigDecimal valorTotal;
	
	@ApiModelProperty(example = "CRIADO")
    private String status;
	
	@ApiModelProperty(example = "2022-02-18T20:34:04Z")
    private OffsetDateTime dataCriacao;
	
    private RestauranteResumoModel restaurante;
    private UsuarioModel cliente;
	
}
