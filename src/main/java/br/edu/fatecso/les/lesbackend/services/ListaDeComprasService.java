package br.edu.fatecso.les.lesbackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecso.les.lesbackend.domain.ListaDeCompras;
import br.edu.fatecso.les.lesbackend.repositories.ListaDeComprasRepository;
import br.edu.fatecso.les.lesbackend.services.exceptions.ObjectNotFoundException;

@Service
public class ListaDeComprasService {
	
	@Autowired
	private ListaDeComprasRepository repo;
	
	public List<ListaDeCompras> findAll() {
		return repo.findAll();
	}
	
	public ListaDeCompras findById(String id) {
		Optional<ListaDeCompras> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public ListaDeCompras insert(ListaDeCompras obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public ListaDeCompras update(ListaDeCompras obj) {
		ListaDeCompras newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(ListaDeCompras newObj, ListaDeCompras obj) {
		newObj.setProduto(obj.getProduto());
		newObj.setClientes(obj.getClientes());
	}
	
	public ListaDeCompras findByProduto(Integer codigo) {
		return repo.findByProdutoCodigo(codigo);
	}
}
