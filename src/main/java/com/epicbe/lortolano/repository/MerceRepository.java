package com.epicbe.lortolano.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.epicbe.lortolano.model.Merce;

public interface MerceRepository extends CrudRepository<Merce, Long>, PagingAndSortingRepository<Merce, Long> {

	@Query(value="SELECT m FROM Merce m ORDER BY RANDOM() LIMIT 10")
	List<Merce> findByMerceRandom();
	
	@Query("SELECT m FROM Merce m WHERE LOWER(m.tipoMerce) LIKE LOWER('%' || :name || '%')")
	public List<Merce> searchByPartName(String name);
	
}
