package com.epicbe.lortolano.model;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "venditori")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Venditore {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String indirizzo;

	@Column(unique = true, length = 11)
	private Long partivaIva;

	@Column(unique = true)
	private String ragioneSociale;

	@Column(nullable = true)
	private String nome;

	@Column(nullable = true)
	private String cognome;
	
	@Column(nullable = false)
	private String email;

	@Column(nullable = true, unique = true)
	private String pec;
	
	@OneToMany(mappedBy = "venditore")
	private List<Prodotto> prodotti;

}
