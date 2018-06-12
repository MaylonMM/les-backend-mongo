package br.edu.fatecso.les.lesbackend.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.fatecso.les.lesbackend.domain.Pedido;

@Repository
public interface PedidoRepository extends MongoRepository<Pedido, String> {
	
	@Query("{ $and: [ { data: {$gte: ?0} }, { data: { $lte: ?1} } ] }")
	List<Pedido> findByDataBetween(Date dataInicio, Date dataFim);
}
