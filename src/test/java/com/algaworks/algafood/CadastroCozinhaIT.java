package com.algaworks.algafood;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CadastroCozinhaIT {
	
	@LocalServerPort
	private int port;
	
	@Test
	public void deveRetornarStatus200_QuandoConsultarCozinhas() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		given()//dado que
			.basePath("/cozinhas")//o caminho é cozinhas
			.port(port)//na porta 8080
			.accept(ContentType.JSON)//o accept é json
		.when()//quando
			.get()///fizer uma requisição get no que foi informado acima
		.then()//então
			.statusCode(HttpStatus.OK.value());//o codigo de status tem que ser 200
	}
	
	@Test
	public void deveConter4Cozinhas_QuandoConsultarCozinhas() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		given()//dado que
			.basePath("/cozinhas")//o caminho é cozinhas
			.port(port)//na porta 8080
			.accept(ContentType.JSON)//o accept é json
		.when()//quando
			.get()///fizer uma requisição get no que foi informado acima
		.then()//então
			.body("", hasSize(4))
			.body("nome", hasItems("Indiana", "Tailandesa"));//o codigo de status tem que ser 200
	}
	
}
