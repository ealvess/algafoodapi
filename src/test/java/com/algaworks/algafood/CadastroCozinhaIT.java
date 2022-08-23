package com.algaworks.algafood;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
class CadastroCozinhaIT {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private Flyway flyway;
	
	@BeforeEach
	public void setUp() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.port = port;
		RestAssured.basePath = "/cozinhas";
		
		flyway.migrate();
	}
	
	@Test
	public void deveRetornarStatus200_QuandoConsultarCozinhas() {	
		given()//dado que
			.accept(ContentType.JSON)//o accept é json
		.when()//quando
			.get()///fizer uma requisição get no que foi informado acima
		.then()//então
			.statusCode(HttpStatus.OK.value());//o codigo de status tem que ser 200
	}
	
	@Test
	public void deveConter4Cozinhas_QuandoConsultarCozinhas() {
		given()//dado que
			.accept(ContentType.JSON)//o accept é json
		.when()//quando
			.get()///fizer uma requisição get no que foi informado acima
		.then()//então
			.body("", hasSize(4))
			.body("nome", hasItems("Indiana", "Tailandesa"));//o codigo de status tem que ser 200
	}
	
	@Test
	public void deveRetornarStatus201_QuandoCadastrarCozinha() {
		given()
			.body("{ \"nome\": \"Chinesa\"}")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.CREATED.value());
	}
	
	
	
}
