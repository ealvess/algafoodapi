package com.algaworks.algafood.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Pedido;

@Service
public class FluxoPedidoService {

	@Autowired
	private EmissaoPedidoService emissaoPedidoService;
	
	@Transactional
	public void confirmar(Long pedidoId) {
		Pedido pedido =	emissaoPedidoService.buscarOuFalhar(pedidoId);
		
		pedido.confirmar();
		pedido.setDataConfirmacao(OffsetDateTime.now());
	}
	
	@Transactional
	public void cancelamento(Long pedidoId) {
		Pedido pedido = emissaoPedidoService.buscarOuFalhar(pedidoId);
		
		pedido.cancelar();
		pedido.setDataCancelamento(OffsetDateTime.now());
	}
	
	@Transactional
	public void entregue(Long pedidoId) {
		Pedido pedido = emissaoPedidoService.buscarOuFalhar(pedidoId);
		
		pedido.entregar();
		pedido.setDataEntrega(OffsetDateTime.now());
	}
}
