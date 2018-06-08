package br.edu.fatecso.les.lesbackend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.fatecso.les.lesbackend.domain.ListaDeCompras;

@Repository
public interface ListaDeComprasRepository extends MongoRepository<ListaDeCompras, String> {
	
	@Query("{ 'produto.codigo' : ?0 }")
	ListaDeCompras findByProduto(Integer codigo);
}
