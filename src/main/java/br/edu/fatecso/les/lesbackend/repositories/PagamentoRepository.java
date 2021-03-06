package br.edu.fatecso.les.lesbackend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.edu.fatecso.les.lesbackend.domain.Pagamento;

@Repository
public interface PagamentoRepository extends MongoRepository<Pagamento, String> {

}
