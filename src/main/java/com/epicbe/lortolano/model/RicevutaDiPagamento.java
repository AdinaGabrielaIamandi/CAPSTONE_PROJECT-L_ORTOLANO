package com.epicbe.lortolano.model;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ricevute_di_pagamento")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RicevutaDiPagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private LocalDate data;

	@Column(nullable = false)
	private Double importo;

	@ManyToOne
	@JsonIgnoreProperties({ "ricevute_di_pagamento" })
	private Venditore venditore;

	@ManyToOne
	@JsonIgnoreProperties({ "ricevute_di_pagamento" })
	private Cliente cliente;
	
}
