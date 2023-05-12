package com.epicbe.lortolano.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.epicbe.lortolano.model.Merce;

public interface MerceRepository extends CrudRepository<Merce, Long>, PagingAndSortingRepository<Merce, Long> {

}
