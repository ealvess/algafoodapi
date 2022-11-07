package com.algaworks.algafood.api.controller.openapi;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.GrupoModel;
import com.algaworks.algafood.api.model.input.GrupoInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Grupos")
public interface GrupoControllerOpenApi {

	@ApiOperation("Lista os grupos")
	public List<GrupoModel> listar();
	
	@ApiOperation("Busca um grupo por ID")
	@ApiResponses({ 
		@ApiResponse(code = 400, message = "ID do grupo inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "Grupo não encontrado", response = Problem.class) })
	public GrupoModel buscar(@PathVariable Long grupoId);
	
	@ApiOperation("Cadastra um grupo")
	@ApiResponses({ @ApiResponse(code = 201, message = "Grupo cadastrado") })
	public GrupoModel adicionar(
			@ApiParam(name = "corpo", value = "Representação de uma nova cidade") @RequestBody @Valid GrupoInput grupoInput);
	
	@ApiOperation("Atualiza um grupo por ID")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "Grupo atualizado"),
		@ApiResponse(code = 404, message = "Grupo não encontrado", response = Problem.class) })
	public GrupoModel atualizar(
			@ApiParam(value = "ID de um grupo", example = "1") @PathVariable Long grupoId, 
			@ApiParam(name = "corpo", value = "Representação de um grupo com novos dados") @RequestBody @Valid GrupoInput grupoInput);
	
	@ApiOperation("Remove(deleta) um grupo por ID")
	@ApiResponses({ @ApiResponse(code = 204, message = "Grupo excluído"),
			@ApiResponse(code = 404, message = "Grupo não encontrado", response = Problem.class) })
	public void remover(
			@ApiParam(value = "ID de um grupo", example = "1") @PathVariable Long grupoId);
}
