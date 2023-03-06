package com.algaworks.algafood.core.web;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedMethods("*");
//			.allowedOrigins("*")
//			.maxAge(30)
	}
	
	@Bean
	public Filter shallowEtagHeaderFilter() {
		//ao receber um requisição, ele gera um hash(etag) e coloca no cabeçaljo da resposta
		//porem tambem verifica se o hash da resposta coincide com a etag que esta no if-none-match 
		//e se for igual retorna um 304 (nada modificado)
		return new ShallowEtagHeaderFilter();
	}
	
}
