package com.epicbe.lortolano.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.epicbe.lortolano.model.Venditore;

public interface VenditoreRepository
		extends CrudRepository<Venditore, Long>, PagingAndSortingRepository<Venditore, Long> {

}
