package com.epicbe.lortolano.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.epicbe.lortolano.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>, PagingAndSortingRepository<Cliente, Long> {

	public boolean existsByEmail(String email);
	
	@Query(value="SELECT c FROM Cliente c ORDER BY RANDOM() LIMIT 1")
	Cliente findByClienteRandom();
	
}
