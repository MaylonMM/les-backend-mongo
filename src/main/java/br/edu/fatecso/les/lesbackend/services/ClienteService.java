package br.edu.fatecso.les.lesbackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecso.les.lesbackend.domain.Cliente;
import br.edu.fatecso.les.lesbackend.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public List<Cliente> findAll() {
		return repo.findAll();
	}
}
