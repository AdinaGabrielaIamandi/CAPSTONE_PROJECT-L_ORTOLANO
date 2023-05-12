package com.epicbe.lortolano.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.epicbe.lortolano.model.RicevutaDiPagamento;

public interface RicevutaDiPagamentoRepository
		extends CrudRepository<RicevutaDiPagamento, Long>, PagingAndSortingRepository<RicevutaDiPagamento, Long> {

}
