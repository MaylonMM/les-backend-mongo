package br.edu.fatecso.les.lesbackend.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "produto")
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer codigo;
	private String descricao;
	private Double valorCusto;
	private Double valorVenda;
	private Double qtdeEstoque;
	private Double estoqueMin;
	
	public Produto() {
		
	}

	public Produto(Integer codigo, String descricao, Double valorCusto, Double valorVenda, Double qtdeEstoque,
			Double estoqueMin) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.valorCusto = valorCusto;
		this.valorVenda = valorVenda;
		this.qtdeEstoque = qtdeEstoque;
		this.estoqueMin = estoqueMin;
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

	public Double getEsqueMin() {
		return estoqueMin;
	}

	public void setEsqueMin(Double esqueMin) {
		this.estoqueMin = esqueMin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Produto other = (Produto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
