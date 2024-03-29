package com.algaworks.algafood.api.v1.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Relation(collectionRelation = "pedidoResumo")
@Getter
@Setter
public class PedidoResumoModel extends RepresentationModel<PedidoResumoModel> {

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
    private RestauranteApenasNomeModel restauranteApenasNome;
    private UsuarioModel cliente;   
	
}
