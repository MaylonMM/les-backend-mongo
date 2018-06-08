package br.edu.fatecso.les.lesbackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatecso.les.lesbackend.domain.Produto;
import br.edu.fatecso.les.lesbackend.dto.ProdutoDTO;
import br.edu.fatecso.les.lesbackend.repositories.ProdutoRepository;
import br.edu.fatecso.les.lesbackend.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;

	public List<Produto> findAll() {
		return repo.findAll();
	}

	public Produto findById(Integer codigo) {
		Optional<Produto> obj = repo.findById(codigo);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Produto insert(Produto obj) {
		return repo.insert(obj);
	}

	public void delete(Integer codigo) {
		findById(codigo);
		repo.deleteById(codigo);
	}

	public Produto update(Produto obj) {
		Produto newObj = findById(obj.getCodigo());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Produto newObj, Produto obj) {
		newObj.setCodigo(obj.getCodigo());
		newObj.setDescricao(obj.getDescricao());
		newObj.setValorCusto(obj.getValorCusto());
		newObj.setValorVenda(obj.getValorVenda());
		newObj.setQtdeEstoque(obj.getQtdeEstoque());
		newObj.setEsqueMin(obj.getEsqueMin());
	}

	public Produto fromDTO(ProdutoDTO objDto) {
		return new Produto(objDto.getCodigo(), objDto.getDescricao(), objDto.getValorCusto(), objDto.getValorVenda(), objDto.getQtdeEstoque(), objDto.getEstoqueMin());
	}
}
