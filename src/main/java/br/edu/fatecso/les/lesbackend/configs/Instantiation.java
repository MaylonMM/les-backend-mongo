package br.edu.fatecso.les.lesbackend.configs;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.edu.fatecso.les.lesbackend.domain.Cliente;
import br.edu.fatecso.les.lesbackend.domain.ItemPedido;
import br.edu.fatecso.les.lesbackend.domain.ListaDeCompras;
import br.edu.fatecso.les.lesbackend.domain.Pagamento;
import br.edu.fatecso.les.lesbackend.domain.PagamentoComCartao;
import br.edu.fatecso.les.lesbackend.domain.PagamentoComDinheiro;
import br.edu.fatecso.les.lesbackend.domain.Pedido;
import br.edu.fatecso.les.lesbackend.domain.Produto;
import br.edu.fatecso.les.lesbackend.domain.enums.TipoPagamento;
import br.edu.fatecso.les.lesbackend.dto.ClienteListaDTO;
import br.edu.fatecso.les.lesbackend.repositories.ClienteRepository;
import br.edu.fatecso.les.lesbackend.repositories.ListaDeComprasRepository;
import br.edu.fatecso.les.lesbackend.repositories.PagamentoRepository;
import br.edu.fatecso.les.lesbackend.repositories.PedidoRepository;
import br.edu.fatecso.les.lesbackend.repositories.ProdutoRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private ListaDeComprasRepository listaDeComprasRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		clienteRepository.deleteAll();
		produtoRepository.deleteAll();
		listaDeComprasRepository.deleteAll();
		pedidoRepository.deleteAll();
		pagamentoRepository.deleteAll();
		
		Cliente c1 = new Cliente(null, "Maria da Silva", "maria@gmail.com", "30356874");
		Cliente c2 = new Cliente(null, "José Cravo", "jose@gmail.com", "998305687");
		
		clienteRepository.saveAll(Arrays.asList(c1, c2));
		
		Produto p1 = new Produto(1000, "Caneta", 0.60, 1.30, 830.00, 120.00);
		Produto p2 = new Produto(1001, "Cola Branca", 0.65, 1.40, 25.00, 4.00);
		Produto p3 = new Produto(1002, "Lapis", 0.43, 1.00, 723.00, 120.00);
		Produto p4 = new Produto(1003, "Caderno", 14.60, 29.90, 8.00, 0.00);
		Produto p5 = new Produto(1004, "Mochila", 35.00, 74.90, 10.00, 0.00);
		Produto p6 = new Produto(1005, "TNT", 0.92, 2.00, 83.50, 15.00);
		Produto p7 = new Produto(1006, "Borracha", 0.86, 1.80, 0.00, 0.00);
		Produto p8 = new Produto(1007, "Caderneta", 2.50, 5.00, 0.00, 0.00);
		
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8));
		
		ListaDeCompras lista1 = new ListaDeCompras(null, p7);
		ListaDeCompras lista2 = new ListaDeCompras(null, p8);
		
		lista2.getClientes().add(new ClienteListaDTO(c2));
		
		listaDeComprasRepository.saveAll(Arrays.asList(lista1, lista2));
		
		ItemPedido item1 = new ItemPedido(3.00, p1);
		ItemPedido item2 = new ItemPedido(1.00, p4);
		ItemPedido item3 = new ItemPedido(1.00, p5);
		
		Pagamento pg1 = new PagamentoComDinheiro(null, 50.00);
		Pagamento pg2 = new PagamentoComCartao(null, TipoPagamento.CREDITO, 1, 58.70);
		
		pagamentoRepository.saveAll(Arrays.asList(pg1, pg2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse(sdf.format(System.currentTimeMillis())), false);
		ped1.getItens().addAll(Arrays.asList(item1, item2, item3));
		ped1.getPagamentos().addAll(Arrays.asList(pg1, pg2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1));
	}
}
