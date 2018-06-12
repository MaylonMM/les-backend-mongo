package br.edu.fatecso.les.lesbackend.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecso.les.lesbackend.domain.Pagamento;
import br.edu.fatecso.les.lesbackend.domain.PagamentoComCartao;
import br.edu.fatecso.les.lesbackend.domain.PagamentoComDinheiro;
import br.edu.fatecso.les.lesbackend.domain.Pedido;
import br.edu.fatecso.les.lesbackend.domain.enums.TipoPagamento;
import br.edu.fatecso.les.lesbackend.dto.FaturamentoDTO;
import br.edu.fatecso.les.lesbackend.repositories.PedidoRepository;

@Service
public class FaturamentoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public FaturamentoDTO faturamentoTotal(Date inicio, Date fim) {
		fim = new Date(fim.getTime() + 23 * 60 * 60 * 1000 + 59 * 60 * 1000 + 59 * 1000 + 999);
		List<Pedido> list = repo.findByDataBetween(inicio, fim);
		
		Double totalDinheiro = 0.00;
		Double totalCartao = 0.00;
		Double totalDebito = 0.00;
		Double totalCredito = 0.00;
		Double total = 0.00;
		
		for (Pedido ped : list) {
			if (!ped.getOrcamento()) {
				total = total + ped.getTotal();
				
				for (Pagamento pg : ped.getPagamentos()) {
					if (pg instanceof PagamentoComDinheiro) {
						totalDinheiro = totalDinheiro + ((PagamentoComDinheiro) pg).getValor();
					} else {
						totalCartao = totalCartao + ((PagamentoComCartao) pg).getValor();
						
						if (((PagamentoComCartao) pg).getTipo() == TipoPagamento.DEBITO) {
							totalDebito = totalDebito + ((PagamentoComCartao) pg).getValor();
						} else {
							totalCredito = totalCredito + ((PagamentoComCartao) pg).getValor();
						}
					}
				}
			}
		}
		FaturamentoDTO obj = new FaturamentoDTO(totalDinheiro, totalCartao, totalDebito, totalCredito, total);
		
		return obj;
	}
}
