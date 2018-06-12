package br.edu.fatecso.les.lesbackend.dto;

import java.io.Serializable;

public class FaturamentoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Double totalDinheiro;
	private Double totalCartao;
	private Double totalDebito;
	private Double totalCredito;
	private Double total;
	
	public FaturamentoDTO() {
		
	}

	public FaturamentoDTO(Double totalDinheiro, Double totalCartao, Double totalDebito, Double totalCredito,
			Double total) {
		super();
		this.totalDinheiro = totalDinheiro;
		this.totalCartao = totalCartao;
		this.totalDebito = totalDebito;
		this.totalCredito = totalCredito;
		this.total = total;
	}

	public Double getTotalDinheiro() {
		return totalDinheiro;
	}

	public void setTotalDinheiro(Double totalDinheiro) {
		this.totalDinheiro = totalDinheiro;
	}

	public Double getTotalCartao() {
		return totalCartao;
	}

	public void setTotalCartao(Double totalCartao) {
		this.totalCartao = totalCartao;
	}

	public Double getTotalDebito() {
		return totalDebito;
	}

	public void setTotalDebito(Double totalDebito) {
		this.totalDebito = totalDebito;
	}

	public Double getTotalCredito() {
		return totalCredito;
	}

	public void setTotalCredito(Double totalCredito) {
		this.totalCredito = totalCredito;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
}
