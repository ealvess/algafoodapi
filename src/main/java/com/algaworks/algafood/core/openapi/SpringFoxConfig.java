package com.algaworks.algafood.core.openapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.OAS_30)
              .select()
                .apis(RequestHandlerSelectors.basePackage("com.algaworks.algafood.api"))
                .build()
              .apiInfo(apiInfo())
              .tags(new Tag("Cidades","Gerencia as cidades"));
    }
    
    public ApiInfo apiInfo() {
    	return new ApiInfoBuilder()
    			.title("AlgaFood API")
    			.description("API aberta para clientes e restaurantes")
    			.version("1")
    			.contact(new Contact("Algaworks", "https://www.algaworks.com", "everton10alves@gmail.com"))
    			.build();
    }

}