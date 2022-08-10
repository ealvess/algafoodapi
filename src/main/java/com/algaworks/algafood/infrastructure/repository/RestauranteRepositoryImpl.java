package com.algaworks.algafood.infrastructure.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Restaurante;

@Repository
public class RestauranteRepositoryImpl {

	@PersistenceContext
	private EntityManager manager;
	
	public List<Restaurante> find(String nome, BigDecimal taxaFreteIncial, BigDecimal taxaFreteFinal){
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		
		CriteriaQuery<Restaurante> criteria = builder.createQuery(Restaurante.class);
		
		criteria.from(Restaurante.class); // from Restaurante
		
		
		TypedQuery<Restaurante> query =  manager.createQuery(criteria);
		return query.getResultList();
	}
	
}
