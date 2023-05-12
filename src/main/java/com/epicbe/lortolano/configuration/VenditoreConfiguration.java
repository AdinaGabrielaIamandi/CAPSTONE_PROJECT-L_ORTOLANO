package com.epicbe.lortolano.configuration;

import java.util.Locale;
import org.springframework.context.annotation.*;
import com.epicbe.lortolano.model.Venditore;
import com.github.javafaker.Faker;

@Configuration
public class VenditoreConfiguration {

	@Bean("VenditoreRandom")
	@Scope("prototype")
	public Venditore venditoreRandom() {
		Faker fake = new Faker(new Locale("it-IT"));
		return Venditore.builder().indirizzo(fake.address().fullAddress())
				.partivaIva((long) fake.number().numberBetween(111111111, 99999999)).ragioneSociale(fake.company().bs())
				.nome(fake.name().firstName()).cognome(fake.name().lastName()).build();
	}

}
