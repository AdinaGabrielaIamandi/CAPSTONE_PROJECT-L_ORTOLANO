package com.epicbe.lortolano.configuration;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import com.epicbe.lortolano.model.Prodotto;
import com.epicbe.lortolano.service.VenditoreService;
import com.github.javafaker.Faker;

@Configuration
public class ProdottoConfiguration {
	
	@Autowired
	VenditoreService venditoreService;

	@Bean("VerduraRandom")
	@Scope("prototype")
	public Prodotto verduraRandom() {
		Faker fake = new Faker(new Locale("it-IT"));
		return Prodotto.builder().tipoMerce(fake.food().vegetable()).quantità((double) fake.number().randomDigitNotZero())
				.prezzoAlKg(fake.commerce().price(0.10,10)).venditore(venditoreService.getVenditoreRandom()).build();
	}

	@Bean("FruttaRandom")
	@Scope("prototype")
	public Prodotto fruttaRandom() {
		Faker fake = new Faker(new Locale("it-IT"));
		return Prodotto.builder().tipoMerce(fake.food().fruit()).quantità((double) fake.number().randomDigitNotZero())
				.prezzoAlKg(fake.commerce().price(0.10,10)).venditore(venditoreService.getVenditoreRandom()).build();
	}

}
