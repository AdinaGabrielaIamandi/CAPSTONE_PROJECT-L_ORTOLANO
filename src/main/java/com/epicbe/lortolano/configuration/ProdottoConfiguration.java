package com.epicbe.lortolano.configuration;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import com.epicbe.lortolano.model.Prodotto;
import com.epicbe.lortolano.model.Utente;
import com.epicbe.lortolano.service.UtenteService;
import com.github.javafaker.Faker;

@Configuration
public class ProdottoConfiguration {

	@Autowired
	UtenteService utenteService;

	@Bean("CreateVerdura")
	@Scope("prototype")
	public Prodotto createVerdura(String tipoMerce, Double quantità, String prezzoAlKg, Utente utente) {
		return Prodotto.builder().tipoMerce(tipoMerce).quantità(quantità).prezzoAlKg(prezzoAlKg).utente(utente)
				.build();
	}

	@Bean("VerduraRandom")
	@Scope("prototype")
	public Prodotto verduraRandom() {
		Faker fake = new Faker(new Locale("it-IT"));
		return Prodotto.builder().tipoMerce(fake.food().vegetable())
				.quantità((double) fake.number().randomDigitNotZero()).prezzoAlKg(fake.commerce().price(0.10, 10))
				.utente(utenteService.getClienteRandom()).build();
	}
	
	@Bean("CreateFrutta")
	@Scope("prototype")
	public Prodotto createFrutta(String tipoMerce, Double quantità, String prezzoAlKg, Utente utente) {
		return Prodotto.builder().tipoMerce(tipoMerce).quantità(quantità).prezzoAlKg(prezzoAlKg).utente(utente)
				.build();
	}

	@Bean("FruttaRandom")
	@Scope("prototype")
	public Prodotto fruttaRandom() {
		Faker fake = new Faker(new Locale("it-IT"));
		return Prodotto.builder().tipoMerce(fake.food().fruit()).quantità((double) fake.number().randomDigitNotZero())
				.prezzoAlKg(fake.commerce().price(0.10, 10)).utente(utenteService.getClienteRandom()).build();
	}

}
