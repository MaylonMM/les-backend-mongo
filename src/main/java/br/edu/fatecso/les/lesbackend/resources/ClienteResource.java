package br.edu.fatecso.les.lesbackend.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecso.les.lesbackend.domain.Cliente;
import br.edu.fatecso.les.lesbackend.dto.ClienteDTO;
import br.edu.fatecso.les.lesbackend.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ClienteDTO>> findAll() {
		List<Cliente> list = service.findAll();
		List<ClienteDTO> listDto = list.stream().map(x -> new ClienteDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ClienteDTO> findById(@PathVariable String id) {
		Cliente obj = service.findById(id);
		return ResponseEntity.ok().body(new ClienteDTO(obj));
	}
}
