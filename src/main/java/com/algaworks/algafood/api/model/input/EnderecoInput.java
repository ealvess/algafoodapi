package com.algaworks.algafood.api.model.input;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EnderecoInput {
	
	@ApiModelProperty(example = "79750000", required = true)
	@NotBlank
	private String cep;
	
	@ApiModelProperty(example = "Rua Melvin Jones", required = true)
	@NotBlank
	private String logradouro;
	
	@ApiModelProperty(example = "609", required = true)
	@NotBlank
	private String numero;
	
	@ApiModelProperty(example = "Casa dos fundos")
	private String complemento;
	
	@ApiModelProperty(example = "Monte Carlo")
	@NotBlank
	private String bairro;
	
	@Valid
	@NotNull
	private CidadeIdInput cidade;
}
