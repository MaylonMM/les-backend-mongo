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
		Cliente c3 = new Cliente(null, "Ana Silva", "ana@gmail.com", "981569835");
		
		clienteRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Produto p1 = new Produto(1000, "Caneta", 0.60, 1.30, 830.00, 120.00);
		Produto p2 = new Produto(1001, "Cola Branca", 0.65, 1.40, 25.00, 4.00);
		Produto p3 = new Produto(1002, "Lapis", 0.43, 1.00, 723.00, 120.00);
		Produto p4 = new Produto(1003, "Caderno", 14.60, 29.90, 8.00, 0.00);
		Produto p5 = new Produto(1004, "Mochila", 35.00, 74.90, 10.00, 0.00);
		Produto p6 = new Produto(1005, "TNT", 0.92, 2.00, 83.50, 15.00);
		Produto p7 = new Produto(1006, "Borracha", 0.86, 1.80, 0.00, 0.00);
		Produto p8 = new Produto(1007, "Caderneta", 2.50, 5.00, 0.00, 0.00);
		Produto p9 = new Produto(1008, "Branquinho", 1.38, 3.00, 0.00, 2.00);
		
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9));
		
		ListaDeCompras lista1 = new ListaDeCompras(null, p7);
		ListaDeCompras lista2 = new ListaDeCompras(null, p8);
		
		lista2.getClientes().add(new ClienteListaDTO(c2));
		
		listaDeComprasRepository.saveAll(Arrays.asList(lista1, lista2));
		
		ItemPedido item1 = new ItemPedido(3.00, p1);
		ItemPedido item2 = new ItemPedido(1.00, p4);
		ItemPedido item3 = new ItemPedido(1.00, p5);
		
		ItemPedido item4 = new ItemPedido(1.00, p5);
		ItemPedido item5 = new ItemPedido(1.00, p4);
		
		ItemPedido item6 = new ItemPedido(8.00, p1);
		
		ItemPedido item7 = new ItemPedido(15.00, p6);
		
		Pagamento pg1 = new PagamentoComDinheiro(null, 50.00);
		Pagamento pg2 = new PagamentoComCartao(null, TipoPagamento.CREDITO, 1, 58.70);
		
		Pagamento pg3 = new PagamentoComCartao(null, TipoPagamento.DEBITO, null, 104.80);
		
		Pagamento pg4 = new PagamentoComDinheiro(null, 10.40);
		
		Pagamento pg5 = new PagamentoComDinheiro(null, 100.00);
		
		pagamentoRepository.saveAll(Arrays.asList(pg1, pg2, pg3, pg4, pg5));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse(sdf.format(System.currentTimeMillis())), false);
		ped1.getItens().addAll(Arrays.asList(item1, item2, item3));
		ped1.getPagamentos().addAll(Arrays.asList(pg1, pg2));
		
		Pedido ped2 = new Pedido(null, sdf.parse("29/05/2018 18:06"), false);
		ped2.getItens().addAll(Arrays.asList(item4, item5));
		ped2.getPagamentos().addAll(Arrays.asList(pg3));
		
		Pedido ped3 = new Pedido(null, sdf.parse("12/06/2018 16:21"), false);
		ped3.getItens().addAll(Arrays.asList(item6));
		ped3.getPagamentos().addAll(Arrays.asList(pg4));
		
		Pedido ped4 = new Pedido(null, sdf.parse("12/06/2018 16:32"), false);
		ped4.getItens().addAll(Arrays.asList(item7));
		ped4.getPagamentos().addAll(Arrays.asList(pg5));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2, ped3, ped4));
	}
}
