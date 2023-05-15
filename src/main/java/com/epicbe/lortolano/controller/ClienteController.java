package com.epicbe.lortolano.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.epicbe.lortolano.model.Cliente;
import com.epicbe.lortolano.service.ClienteService;

@CrossOrigin(origins = "*", maxAge = 360000)
@RestController
@RequestMapping("/api/clienti")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@GetMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<List<Cliente>>(clienteService.getAllCliente(), HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(clienteService.getCliente(id), HttpStatus.OK);
	}

	@GetMapping("/pageable")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Page<Cliente>> getAllPage(Pageable pageable) {
		return new ResponseEntity<Page<Cliente>>(clienteService.getAllClientePageable(pageable), HttpStatus.OK);
	}

	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> createCliente(@RequestBody Cliente Cliente) {
		return new ResponseEntity<Cliente>(clienteService.createCliente(Cliente), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteCliente(@PathVariable Long id) {
		return new ResponseEntity<String>(clienteService.removeCliente(id), HttpStatus.OK);
	}

	@PutMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateUser(@RequestBody Cliente Cliente) {
		return new ResponseEntity<Cliente>(clienteService.updateCliente(Cliente), HttpStatus.CREATED);
	}

}
