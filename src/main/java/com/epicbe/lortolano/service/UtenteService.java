package com.epicbe.lortolano.service;

import java.util.List;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.epicbe.lortolano.model.Utente;
import com.epicbe.lortolano.repository.UtenteRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class UtenteService {
	
	@Autowired
	UtenteRepository clienteRepo;
	
	@Autowired
	@Qualifier("UtenteConPIVA")
	private ObjectProvider<Utente> randomClienteConIVAProvider;
	
	@Autowired
	@Qualifier("UtenteSenzaPIVA")
	private ObjectProvider<Utente> randomClienteSenzaIVAProvider;
	
	public Utente createCliente(Utente cliente) {
		if(clienteRepo.existsByEmail(cliente.getEmail())) {
			throw new EntityExistsException("Email exist!!!");
		} else {
			clienteRepo.save(cliente);
		}
		return cliente;
	}
	
	public void saveClienteRandomConPIva() {		
		 createCliente(randomClienteConIVAProvider.getObject());
	}
	
	public void saveClienteRandomSenzaPIva() {		
		 createCliente(randomClienteSenzaIVAProvider.getObject());
	}
	
	public Utente getCliente(Long id) {
		if(!clienteRepo.existsById(id)) {
			throw new EntityExistsException("Cliente not exists!!!");
		}
		return clienteRepo.findById(id).get();
	}
	
	public Utente getClienteRandom() {
		return clienteRepo.findByUtenteRandom();
	}
	
	public String removeCliente(Long id) {
		if(!clienteRepo.existsById(id)) {
			throw new EntityExistsException("Cliente not exists!!!");
		}
		clienteRepo.deleteById(id);
		return "Cliente Deleted!!!";
	}
	
	public Utente updateCliente(Utente Cliente) {
		if(!clienteRepo.existsById(Cliente.getId())) {
			throw new EntityExistsException("Cliente not exists!!!");
		}
		clienteRepo.save(Cliente);
		return Cliente;
	}
	
	public List<Utente> getAllCliente() {
		return (List<Utente>) clienteRepo.findAll();
	}
	
	public Page<Utente> getAllClientePageable(Pageable pageable) {
		return (Page<Utente>) clienteRepo.findAll(pageable);
	}


}
