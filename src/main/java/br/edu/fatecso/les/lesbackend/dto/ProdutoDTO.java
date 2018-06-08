package br.edu.fatecso.les.lesbackend.dto;

import java.io.Serializable;

import br.edu.fatecso.les.lesbackend.domain.Produto;

public class ProdutoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	private String descricao;
	private Double valorCusto;
	private Double valorVenda;
	private Double qtdeEstoque;
	private Double estoqueMin;
	
	public ProdutoDTO() {
		
	}
	
	public ProdutoDTO(Produto obj) {
		codigo = obj.getCodigo();
		descricao = obj.getDescricao();
		valorCusto = obj.getValorCusto();
		valorVenda = obj.getValorVenda();
		qtdeEstoque = obj.getQtdeEstoque();
		estoqueMin = obj.getEsqueMin();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValorCusto() {
		return valorCusto;
	}

	public void setValorCusto(Double valorCusto) {
		this.valorCusto = valorCusto;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Double getQtdeEstoque() {
		return qtdeEstoque;
	}

	public void setQtdeEstoque(Double qtdeEstoque) {
		this.qtdeEstoque = qtdeEstoque;
	}

	public Double getEstoqueMin() {
		return estoqueMin;
	}

	public void setEstoqueMin(Double estoqueMin) {
		this.estoqueMin = estoqueMin;
	}
}
