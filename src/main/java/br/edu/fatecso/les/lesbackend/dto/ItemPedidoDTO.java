package br.edu.fatecso.les.lesbackend.dto;

import java.io.Serializable;

public class ItemPedidoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	private Double quantidade;
	
	public ItemPedidoDTO() {
		
	}

	public ItemPedidoDTO(Integer codigo, Double quantidade) {
		super();
		this.codigo = codigo;
		this.quantidade = quantidade;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
}
