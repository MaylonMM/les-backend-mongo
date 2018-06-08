package br.edu.fatecso.les.lesbackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecso.les.lesbackend.domain.Cliente;
import br.edu.fatecso.les.lesbackend.dto.ClienteDTO;
import br.edu.fatecso.les.lesbackend.repositories.ClienteRepository;
import br.edu.fatecso.les.lesbackend.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public List<Cliente> findAll() {
		return repo.findAll();
	}
	
	public Cliente findById(String id) {
		Optional<Cliente> cliente = repo.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Cliente insert(Cliente obj) {
		return repo.insert(obj);
	}
	
	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), objDto.getTelefone());
	}
}
