package com.epicbe.lortolano.service;

import java.util.List;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.epicbe.lortolano.model.Cliente;
import com.epicbe.lortolano.repository.ClienteRepository;
import jakarta.persistence.EntityExistsException;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepo;
	
	@Autowired
	@Qualifier("ClienteConPIVA")
	private ObjectProvider<Cliente> randomClienteConIVAProvider;
	
	@Autowired
	@Qualifier("ClienteSenzaPIVA")
	private ObjectProvider<Cliente> randomClienteSenzaIVAProvider;
	
	public Cliente createCliente(Cliente cliente) {
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
	
	public Cliente getCliente(Long id) {
		if(!clienteRepo.existsById(id)) {
			throw new EntityExistsException("Cliente not exists!!!");
		}
		return clienteRepo.findById(id).get();
	}
	
	public Cliente getClienteRandom() {
		return clienteRepo.findByClienteRandom();
	}
	
	public String removeCliente(Long id) {
		if(!clienteRepo.existsById(id)) {
			throw new EntityExistsException("Cliente not exists!!!");
		}
		clienteRepo.deleteById(id);
		return "Cliente Deleted!!!";
	}
	
	public Cliente updateCliente(Cliente Cliente) {
		if(!clienteRepo.existsById(Cliente.getId())) {
			throw new EntityExistsException("Cliente not exists!!!");
		}
		clienteRepo.save(Cliente);
		return Cliente;
	}
	
	public List<Cliente> getAllCliente() {
		return (List<Cliente>) clienteRepo.findAll();
	}
	
	public Page<Cliente> getAllClientePageable(Pageable pageable) {
		return (Page<Cliente>) clienteRepo.findAll(pageable);
	}

}
