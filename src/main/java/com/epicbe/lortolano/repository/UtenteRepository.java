package com.epicbe.lortolano.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.epicbe.lortolano.model.Utente;

public interface UtenteRepository extends CrudRepository<Utente, Long>, PagingAndSortingRepository<Utente, Long> {

	public boolean existsByEmail(String email);
	
	@Query(value="SELECT u FROM Utente u ORDER BY RANDOM() LIMIT 1")
	Utente findByUtenteRandom();
	
}
