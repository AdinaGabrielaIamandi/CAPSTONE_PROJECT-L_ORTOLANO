package com.epicbe.lortolano.service;

import java.util.List;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.epicbe.lortolano.model.Venditore;
import com.epicbe.lortolano.repository.VenditoreRepository;
import jakarta.persistence.EntityExistsException;

@Service
public class VenditoreService {

	@Autowired
	VenditoreRepository venditoreRepo;
	
	@Autowired
	@Qualifier("VenditoreRandomPIva")
	private ObjectProvider<Venditore> venditoreRandomPIvaProvider;
	
	@Autowired
	@Qualifier("VenditoreRandomNoIva")
	private ObjectProvider<Venditore> venditoreRandomNoIvaProvider;
	
	public Venditore createVenditore(Venditore venditore) {
		venditoreRepo.save(venditore);
		return venditore;
	}

	public void saveVenditoreRandomPIva() {
		createVenditore(venditoreRandomPIvaProvider.getObject());
	}
	
	public void saveVenditoreRandomNoIva() {
		createVenditore(venditoreRandomNoIvaProvider.getObject());
	}

	public Venditore getVenditore(Long id) {
		if (!venditoreRepo.existsById(id)) {
			throw new EntityExistsException("Venditore not exists!!!");
		}
		return venditoreRepo.findById(id).get();
	}
	
	public Venditore getVenditoreRandom() {
		return venditoreRepo.findByVenditoreRandom();
	}
	
	public List<Venditore> getAllVenditoreByIndirizzo(String posizione){
		return (List<Venditore>) venditoreRepo.findByIndirizzo(posizione);
	}

	public String removeVenditore(Long id) {
		if (!venditoreRepo.existsById(id)) {
			throw new EntityExistsException("Venditore not exists!!!");
		}
		venditoreRepo.deleteById(id);
		return "Venditore Deleted!!!";
	}

	public Venditore updateVenditore(Venditore venditore) {
		if (!venditoreRepo.existsById(venditore.getId())) {
			throw new EntityExistsException("Merce not exists!!!");
		}
		venditoreRepo.save(venditore);
		return venditore;
	}

	public List<Venditore> getAllVenditore() {
		return (List<Venditore>) venditoreRepo.findAll();
	}

	public Page<Venditore> getAllVenditorePageable(Pageable pageable) {
		return (Page<Venditore>) venditoreRepo.findAll(pageable);
	}

}
