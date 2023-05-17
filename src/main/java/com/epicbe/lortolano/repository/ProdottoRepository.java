package com.epicbe.lortolano.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.epicbe.lortolano.model.Prodotto;

public interface ProdottoRepository extends CrudRepository<Prodotto, Long>, PagingAndSortingRepository<Prodotto, Long> {
	
	@Query("SELECT p FROM Prodotto p WHERE LOWER(p.tipoMerce) LIKE LOWER('%' || :name || '%')")
	public List<Prodotto> searchByPartName(String name);
	
}
