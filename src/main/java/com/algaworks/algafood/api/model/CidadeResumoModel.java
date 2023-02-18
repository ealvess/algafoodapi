package com.algaworks.algafood.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeResumoModel {
	
	@ApiModelProperty(example = "1")
	private Long id;
	
	@ApiModelProperty(example = "Nova Andradina")
	private String nome;
	
	@ApiModelProperty(example = "Mato Grosso dos Sul")
	private String estado;
}
