package com.epicbe.lortolano.service;

import java.util.List;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.epicbe.lortolano.model.RicevutaDiPagamento;
import com.epicbe.lortolano.repository.RicevutaDiPagamentoRepository;
import jakarta.persistence.EntityExistsException;

@Service
public class RicevutaDiPagamentoService {

	@Autowired
	RicevutaDiPagamentoRepository ricevutaRepo;

	@Autowired
	@Qualifier("RicevutaRandom")
	private ObjectProvider<RicevutaDiPagamento> randomRicevutaProvider;

	public RicevutaDiPagamento createRicevuta(RicevutaDiPagamento ricevuta) {
		ricevutaRepo.save(ricevuta);
		return ricevuta;
	}

	public void saveRicevutaRandom() {
		createRicevuta(randomRicevutaProvider.getObject());
	}

	public RicevutaDiPagamento getRicevuta(Long id) {
		if (!ricevutaRepo.existsById(id)) {
			throw new EntityExistsException("Ricevuta not exists!!!");
		}
		return ricevutaRepo.findById(id).get();
	}

	public String removeRicevuta(Long id) {
		if (!ricevutaRepo.existsById(id)) {
			throw new EntityExistsException("Ricevuta not exists!!!");
		}
		ricevutaRepo.deleteById(id);
		return "Ricevuta Deleted!!!";
	}

	public RicevutaDiPagamento updateRicevuta(RicevutaDiPagamento ricevuta) {
		if (!ricevutaRepo.existsById(ricevuta.getId())) {
			throw new EntityExistsException("Merce not exists!!!");
		}
		ricevutaRepo.save(ricevuta);
		return ricevuta;
	}

	public List<RicevutaDiPagamento> getAllRicevuta() {
		return (List<RicevutaDiPagamento>) ricevutaRepo.findAll();
	}

	public Page<RicevutaDiPagamento> getAllRicevutaPageable(Pageable pageable) {
		return (Page<RicevutaDiPagamento>) ricevutaRepo.findAll(pageable);
	}

}
