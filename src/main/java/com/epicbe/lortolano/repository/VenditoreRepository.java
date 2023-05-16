package com.epicbe.lortolano.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.epicbe.lortolano.model.Venditore;

public interface VenditoreRepository
		extends CrudRepository<Venditore, Long>, PagingAndSortingRepository<Venditore, Long> {
	
	@Query(value="SELECT v FROM Venditore v ORDER BY RANDOM() LIMIT 1")
	Venditore findByVenditoreRandom();
	
	@Query(value="SELECT v FROM Venditore v WHERE LOWER(v.indirizzo) LIKE LOWER('%' || :posizione || '%')")
	List<Venditore> findByIndirizzo(String posizione);

}
