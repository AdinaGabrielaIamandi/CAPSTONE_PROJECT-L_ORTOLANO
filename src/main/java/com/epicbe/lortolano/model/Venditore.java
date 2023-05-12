package com.epicbe.lortolano.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

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

	@Column(nullable = false, unique = true, length = 11)
	private Long partivaIva;

	@Column(nullable = true, unique = true)
	private String ragioneSociale;

	@Column(nullable = true)
	private String nome;

	@Column(nullable = true)
	private String cognome;

	@OneToMany(mappedBy = "venditore", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnoreProperties({ "venditore" })
	private List<Merce> merceInVendita;

	@OneToMany(mappedBy = "venditore", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnoreProperties({ "venditore" })
	private List<RicevutaDiPagamento> ricevuteDiPagamaneto;

}
