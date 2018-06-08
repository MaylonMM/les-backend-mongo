package br.edu.fatecso.les.lesbackend.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecso.les.lesbackend.domain.Cliente;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> findAll() {
		Cliente c1 = new Cliente("1", "Maria da Silva", "maria@gmail.com", "30345060");
		Cliente c2 = new Cliente("2", "José Cravo", "jose@gmail.com", "998305468");
		
		List<Cliente> list = new ArrayList<>();
		list.addAll(Arrays.asList(c1, c2));
		
		return ResponseEntity.ok().body(list);
	}
}
