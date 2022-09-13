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
	public void confirmar(String codigoPedido) {
		Pedido pedido =	emissaoPedidoService.buscarOuFalhar(codigoPedido);
		
		pedido.confirmar();
		pedido.setDataConfirmacao(OffsetDateTime.now());
	}
	
	@Transactional
	public void cancelamento(String codigoPedido) {
		Pedido pedido = emissaoPedidoService.buscarOuFalhar(codigoPedido);
		
		pedido.cancelar();
		pedido.setDataCancelamento(OffsetDateTime.now());
	}
	
	@Transactional
	public void entregue(String codigoPedido) {
		Pedido pedido = emissaoPedidoService.buscarOuFalhar(codigoPedido);
		
		pedido.entregar();
		pedido.setDataEntrega(OffsetDateTime.now());
	}
}
