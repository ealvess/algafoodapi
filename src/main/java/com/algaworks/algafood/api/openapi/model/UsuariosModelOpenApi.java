package com.algaworks.algafood.api.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.model.UsuarioModel;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("UsuariosModel")
@Data
public class UsuariosModelOpenApi {

	private UsuarioEmbeddedModelOpenApi _embedded;
	private Links _links;
	
	@ApiModel("UsuarioEmbeddedModelOpenApi")
	@Data
	public class UsuarioEmbeddedModelOpenApi{
		private List<UsuarioModel> usuarios;
	}
}
