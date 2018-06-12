package br.edu.fatecso.les.lesbackend.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProdutoInclusoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String mensagem;
	private ProdutoDTO produto;
	private List<ClienteListaDTO> clientes = new ArrayList<>();
	
	public ProdutoInclusoDTO() {
		
	}

	public ProdutoInclusoDTO(String mensagem, ProdutoDTO produto) {
		super();
		this.mensagem = mensagem;
		this.produto = produto;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public ProdutoDTO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
	}

	public List<ClienteListaDTO> getClientes() {
		return clientes;
	}

	public void setClientes(List<ClienteListaDTO> clientes) {
		this.clientes = clientes;
	}
}
