package com.epicbe.lortolano.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "merci")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Merce {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String tipoMerce;

	@Column(nullable = false)
	private Double quantità;

	@Column(nullable = false)
	private Double prezzoAlKg;

	@ManyToOne
	@JsonIgnoreProperties({ "merci" })
	private Venditore venditore;

}
