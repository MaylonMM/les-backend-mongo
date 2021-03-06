package br.edu.fatecso.les.lesbackend.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pedido")
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private Date data;
	private Boolean orcamento;
	
	private List<ItemPedido> itens = new ArrayList<>();
	private List<Pagamento> pagamentos = new ArrayList<>();
	
	public Pedido() {
		
	}

	public Pedido(String id, Date data, Boolean orcamento) {
		super();
		this.id = id;
		this.data = data;
		this.orcamento = orcamento;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Boolean getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Boolean orcamento) {
		this.orcamento = orcamento;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}
	
	public Double getTotal() {
		Double total = 0.00;
		for (ItemPedido ip : getItens()) {
			total = total + ip.getSubTotal();
		}
		return total;
	}
	
	public Double getTroco() {
		Double valorTotalDado = 0.00;
		for (Pagamento pg : getPagamentos()) {
			if (pg instanceof PagamentoComDinheiro) {
				valorTotalDado = valorTotalDado + ((PagamentoComDinheiro) pg).getValor();
			}
			if (pg instanceof PagamentoComCartao) {
				valorTotalDado = valorTotalDado + ((PagamentoComCartao) pg).getValor();
			}
		}
		return valorTotalDado - getTotal();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
