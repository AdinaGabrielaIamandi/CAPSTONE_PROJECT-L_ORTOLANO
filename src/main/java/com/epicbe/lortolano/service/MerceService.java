package com.epicbe.lortolano.service;

import java.util.List;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.epicbe.lortolano.model.Prodotto;
import com.epicbe.lortolano.repository.ProdottoRepository;
import jakarta.persistence.EntityExistsException;

@Service
public class MerceService {
	
	@Autowired
	ProdottoRepository merceRepo;
	
	@Autowired
	@Qualifier("VerduraRandom")
	ObjectProvider<Prodotto> randomVerdureProvider;
	
	@Autowired
	@Qualifier("FruttaRandom")
	ObjectProvider<Prodotto> randomFruttaProvider;
	
	public Prodotto createMerce(Prodotto merce) {
		merceRepo.save(merce);
		return merce;
	}
	
	public void saveVerdure() {
		createMerce(randomVerdureProvider.getObject());
	}
	
	public void saveFruttaRandom() {
		createMerce(randomFruttaProvider.getObject());
	}
	
	public Prodotto getMerce(Long id) {
		if(!merceRepo.existsById(id)) {
			throw new EntityExistsException("Merce not exists!!!");
		}
		return merceRepo.findById(id).get();
	}
	
	public List<Prodotto> getAllMerceByTipo(String tipo){
		return (List<Prodotto>) merceRepo.searchByPartName(tipo);
	}
	
	public String removeMerce(Long id) {
		if(!merceRepo.existsById(id)) {
			throw new EntityExistsException("Merce not exists!!!");
		}
		merceRepo.deleteById(id);
		return "Cliente Deleted!!!";
	}
	
	public Prodotto updateMerce(Prodotto merce) {
		if(!merceRepo.existsById(merce.getId())) {
			throw new EntityExistsException("Merce not exists!!!");
		}
		merceRepo.save(merce);
		return merce;
	}
	
	public List<Prodotto> getAllMerce() {
		return (List<Prodotto>) merceRepo.findAll();
	}
	
	public Page<Prodotto> getAllMercePageable(Pageable pageable) {
		return (Page<Prodotto>) merceRepo.findAll(pageable);
	}

}
