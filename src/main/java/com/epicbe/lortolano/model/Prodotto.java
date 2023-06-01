package com.epicbe.lortolano.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prodotti")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Prodotto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String tipoMerce;

	@Column(nullable = false)
	private Double quantità;

	@Column(nullable = false)
	private String prezzoAlKg;
	
	@ManyToOne
	@JoinColumn(name = "utente_id")
	private Utente utente;

}
