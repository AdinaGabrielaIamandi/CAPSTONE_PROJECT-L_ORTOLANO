package com.epicbe.lortolano.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.epicbe.lortolano.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>, PagingAndSortingRepository<Cliente, Long> {

	public boolean existsByEmail(String email);
	
}
