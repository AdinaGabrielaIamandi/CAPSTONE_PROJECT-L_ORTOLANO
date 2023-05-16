package com.epicbe.lortolano.service;

import java.util.List;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.epicbe.lortolano.model.Merce;
import com.epicbe.lortolano.repository.MerceRepository;
import jakarta.persistence.EntityExistsException;

@Service
public class MerceService {
	
	@Autowired
	MerceRepository merceRepo;
	
	@Autowired
	@Qualifier("VerduraRandom")
	ObjectProvider<Merce> randomVerdureProvider;
	
	@Autowired
	@Qualifier("FruttaRandom")
	ObjectProvider<Merce> randomFruttaProvider;
	
	public Merce createMerce(Merce merce) {
		merceRepo.save(merce);
		return merce;
	}
	
	public void saveVerdure() {
		createMerce(randomVerdureProvider.getObject());
	}
	
	public void saveFruttaRandom() {
		createMerce(randomFruttaProvider.getObject());
	}
	
	public Merce getMerce(Long id) {
		if(!merceRepo.existsById(id)) {
			throw new EntityExistsException("Merce not exists!!!");
		}
		return merceRepo.findById(id).get();
	}
	
	public List<Merce> getMerceRandom() {
		return merceRepo.findByMerceRandom();
	}
	
	public List<Merce> getAllMerceByTipo(String tipo){
		return (List<Merce>) merceRepo.searchByPartName(tipo);
	}
	
	public String removeMerce(Long id) {
		if(!merceRepo.existsById(id)) {
			throw new EntityExistsException("Merce not exists!!!");
		}
		merceRepo.deleteById(id);
		return "Cliente Deleted!!!";
	}
	
	public Merce updateMerce(Merce merce) {
		if(!merceRepo.existsById(merce.getId())) {
			throw new EntityExistsException("Merce not exists!!!");
		}
		merceRepo.save(merce);
		return merce;
	}
	
	public List<Merce> getAllMerce() {
		return (List<Merce>) merceRepo.findAll();
	}
	
	public Page<Merce> getAllMercePageable(Pageable pageable) {
		return (Page<Merce>) merceRepo.findAll(pageable);
	}

}
