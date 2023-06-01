package com.epicbe.lortolano.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.epicbe.lortolano.model.Utente;
import com.epicbe.lortolano.service.UtenteService;

@CrossOrigin(origins = "*", maxAge = 360000000)
@RestController
@RequestMapping("/api/utente")
public class UtenteController {

	@Autowired
	UtenteService clienteService;

	@GetMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<List<Utente>>(clienteService.getAllCliente(), HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(clienteService.getCliente(id), HttpStatus.OK);
	}

	@GetMapping("/pageable")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Page<Utente>> getAllPage(Pageable pageable) {
		return new ResponseEntity<Page<Utente>>(clienteService.getAllClientePageable(pageable), HttpStatus.OK);
	}

	@PostMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> createCliente(@RequestBody Utente cliente) {
		return new ResponseEntity<Utente>(clienteService.createCliente(cliente), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<String> deleteCliente(@PathVariable Long id) {
		return new ResponseEntity<String>(clienteService.removeCliente(id), HttpStatus.OK);
	}

	@PutMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> updateUser(@RequestBody Utente Cliente) {
		return new ResponseEntity<Utente>(clienteService.updateCliente(Cliente), HttpStatus.CREATED);
	}

}
