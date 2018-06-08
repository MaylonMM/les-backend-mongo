package br.edu.fatecso.les.lesbackend.domain;

import br.edu.fatecso.les.lesbackend.domain.enums.TipoPagamento;

public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	private Integer tipo;
	private Integer parcelas;
	private Double valor;
	
	public PagamentoComCartao() {
		
	}

	public PagamentoComCartao(String id, TipoPagamento tipo, Integer parcelas, Double valor) {
		super(id);
		this.tipo = (tipo == null) ? null : tipo.getCod();
		this.parcelas = parcelas;
		this.valor = valor;
	}

	public TipoPagamento getTipo() {
		return TipoPagamento.toEnum(tipo);
	}

	public void setTipo(TipoPagamento tipo) {
		this.tipo = tipo.getCod();
	}

	public Integer getParcelas() {
		return parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
