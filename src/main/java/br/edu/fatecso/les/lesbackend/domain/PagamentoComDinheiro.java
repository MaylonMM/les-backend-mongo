package br.edu.fatecso.les.lesbackend.domain;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("PagamentoComDinheiro")
public class PagamentoComDinheiro extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	private Double valor;
	
	public PagamentoComDinheiro() {
		
	}

	public PagamentoComDinheiro(String id, Double valor) {
		super(id);
		this.valor = valor;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
