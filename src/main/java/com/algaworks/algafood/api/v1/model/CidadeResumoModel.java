package com.algaworks.algafood.api.v1.model;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Relation(collectionRelation = "cidadeResumo")
@Getter
@Setter
public class CidadeResumoModel extends RepresentationModel<CidadeResumoModel> {
	
	@ApiModelProperty(example = "1")
	private Long id;
	
	@ApiModelProperty(example = "Nova Andradina")
	private String nome;
	
	@ApiModelProperty(example = "Mato Grosso dos Sul")
	private String estado;
}
