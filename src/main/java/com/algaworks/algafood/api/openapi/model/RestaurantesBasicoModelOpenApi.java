package com.algaworks.algafood.api.openapi.model;

import java.util.List;

import org.springframework.hateoas.Links;

import com.algaworks.algafood.api.model.RestauranteBasicoModel;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("RestaurantesBasicoModel")
@Data
public class RestaurantesBasicoModelOpenApi {

	private RestauranteEmbeddedModelOpenApi _embedded;
	private Links _links;
	
	@ApiModel("RestauranteEmbeddedModelOpenApi")
	@Data
	public class RestauranteEmbeddedModelOpenApi{
		private List<RestauranteBasicoModel> restaurantes;
	}
}
