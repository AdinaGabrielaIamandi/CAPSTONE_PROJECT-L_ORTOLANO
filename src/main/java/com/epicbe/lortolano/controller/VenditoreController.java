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
import com.epicbe.lortolano.model.Venditore;
import com.epicbe.lortolano.service.VenditoreService;

@CrossOrigin(origins = "*", maxAge = 360000000)
@RestController
@RequestMapping("/api/venditori")
public class VenditoreController {

	@Autowired
	VenditoreService venditoreService;

	@GetMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<List<Venditore>>(venditoreService.getAllVenditore(), HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(venditoreService.getVenditore(id), HttpStatus.OK);
	}

	@GetMapping("/pageable")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Page<Venditore>> getAllPage(Pageable pageable) {
		return new ResponseEntity<Page<Venditore>>(venditoreService.getAllVenditorePageable(pageable), HttpStatus.OK);
	}
	
	@GetMapping("/partenome/{posizione}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getclientiPerNomeParte(@PathVariable("posizione") String posizione){
		return new ResponseEntity<>(venditoreService.getAllVenditoreByIndirizzo(posizione), HttpStatus.OK);
	}

	@PostMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> createCliente(@RequestBody Venditore venditore) {
		return new ResponseEntity<Venditore>(venditoreService.createVenditore(venditore), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<String> deleteCliente(@PathVariable Long id) {
		return new ResponseEntity<String>(venditoreService.removeVenditore(id), HttpStatus.OK);
	}

	@PutMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> updateUser(@RequestBody Venditore venditore) {
		return new ResponseEntity<Venditore>(venditoreService.updateVenditore(venditore), HttpStatus.CREATED);
	}

}
