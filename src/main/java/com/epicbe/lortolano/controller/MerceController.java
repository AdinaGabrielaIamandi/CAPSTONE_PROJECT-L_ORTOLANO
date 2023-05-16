package com.epicbe.lortolano.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.epicbe.lortolano.model.Merce;
import com.epicbe.lortolano.service.MerceService;

@CrossOrigin(origins = "*", maxAge = 360000)
@RestController
@RequestMapping("/api/merci")
public class MerceController {

	@Autowired
	MerceService merceService;

	@GetMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<List<Merce>>(merceService.getAllMerce(), HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(merceService.getMerce(id), HttpStatus.OK);
	}

	@GetMapping("/pageable")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Page<Merce>> getAllPage(Pageable pageable) {
		return new ResponseEntity<Page<Merce>>(merceService.getAllMercePageable(pageable), HttpStatus.OK);
	}

	@GetMapping("/partenome/{tipo}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getclientiPerNomeParte(@PathVariable("tipo") String tipo) {
		return new ResponseEntity<>(merceService.getAllMerceByTipo(tipo), HttpStatus.OK);
	}

	@PostMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> createCliente(@RequestBody Merce merce) {
		return new ResponseEntity<Merce>(merceService.createMerce(merce), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<String> deleteCliente(@PathVariable Long id) {
		return new ResponseEntity<String>(merceService.removeMerce(id), HttpStatus.OK);
	}

	@PutMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> updateUser(@RequestBody Merce merce) {
		return new ResponseEntity<Merce>(merceService.updateMerce(merce), HttpStatus.CREATED);
	}

}
