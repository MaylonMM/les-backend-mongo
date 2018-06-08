package br.edu.fatecso.les.lesbackend.configs;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.edu.fatecso.les.lesbackend.domain.Cliente;
import br.edu.fatecso.les.lesbackend.repositories.ClienteRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public void run(String... args) throws Exception {
		clienteRepository.deleteAll();
		
		Cliente c1 = new Cliente(null, "Maria da Silva", "maria@gmail.com", "30356874");
		Cliente c2 = new Cliente(null, "José Cravo", "jose@gmail.com", "998305687");
		
		clienteRepository.saveAll(Arrays.asList(c1, c2));
	}
	
	
}
