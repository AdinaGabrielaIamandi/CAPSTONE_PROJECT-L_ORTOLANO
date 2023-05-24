package com.epicbe.lortolano.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clienti")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String indirizzo;

	@Column(nullable = true, unique = true, length = 11)
	private Long partivaIva;

	@Column(nullable = true, unique = true)
	private String ragioneSociale;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String cognome;

	@Column(nullable = false)
	private String email;

	@Column(nullable = true, unique = true)
	private String pec;

}
