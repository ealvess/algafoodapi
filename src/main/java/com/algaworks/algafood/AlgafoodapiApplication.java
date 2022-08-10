package com.algaworks.algafood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.algaworks.algafood.infrastructure.repository.CustomJpaReporitoryImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaReporitoryImpl.class)
public class AlgafoodapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgafoodapiApplication.class, args);
	}

}
