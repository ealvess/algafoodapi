package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.exception.ProdutoNaoEncontradoException;
import com.algaworks.algafood.domain.model.Produto;
import com.algaworks.algafood.domain.repository.ProdutoRepository;

@Service
public class CadastroProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Transactional
	public Produto salvar(Produto produto) {
		return produtoRepository.save(produto);
	}
	
//	@Transactional
//	public void excluir(Long produtoId) {
//		try {
//			produtoRepository.deleteById(produtoId);
//			produtoRepository.flush();
//		} catch (EmptyResultDataAccessException e) {
//			throw new ProdutoNaoEncontradoException(produtoId);
//		} catch (DataIntegrityViolationException e) {
//			throw new NegocioException(String.format("Produto não pode ser removido, pois está em uso", produtoId));
//		}
//	}
	
	public Produto buscarOuFalhar(Long restauranteId, Long produtoId) {
		return produtoRepository.findById(restauranteId, produtoId)
				.orElseThrow(() -> new ProdutoNaoEncontradoException(restauranteId, produtoId));
	}
	
}
