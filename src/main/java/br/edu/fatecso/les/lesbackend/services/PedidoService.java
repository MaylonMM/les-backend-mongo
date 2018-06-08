package br.edu.fatecso.les.lesbackend.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecso.les.lesbackend.domain.Pagamento;
import br.edu.fatecso.les.lesbackend.domain.PagamentoComCartao;
import br.edu.fatecso.les.lesbackend.domain.Pedido;
import br.edu.fatecso.les.lesbackend.domain.enums.TipoPagamento;
import br.edu.fatecso.les.lesbackend.repositories.PagamentoRepository;
import br.edu.fatecso.les.lesbackend.repositories.PedidoRepository;
import br.edu.fatecso.les.lesbackend.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	public List<Pedido> findAll() {
		return repo.findAll();
	}
	
	public Pedido findById(String id) {
		Optional<Pedido> cliente = repo.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setData(new Date());
		for (Pagamento pg : obj.getPagamentos()) {
			if (pg instanceof PagamentoComCartao) {
				if (((PagamentoComCartao) pg).getTipo() == TipoPagamento.DEBITO) {
					((PagamentoComCartao) pg).setParcelas(null);
				}
			}
			pagamentoRepository.save(pg);
		}
		obj = repo.insert(obj);
		return obj;
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public Pedido update(Pedido obj) {
		Pedido newObj = findById(obj.getId());
		updateData(newObj, obj);
		for (Pagamento pg : obj.getPagamentos()) {
			if (pg instanceof PagamentoComCartao) {
				if (((PagamentoComCartao) pg).getTipo() == TipoPagamento.DEBITO) {
					((PagamentoComCartao) pg).setParcelas(null);
				}
			}
			pagamentoRepository.save(pg);
		}
		return repo.save(newObj);
	}
	
	private void updateData(Pedido newObj, Pedido obj) {
		newObj.setOrcamento(obj.getOrcamento());
		newObj.setItens(obj.getItens());
		newObj.setPagamentos(obj.getPagamentos());
	}
}
