package com.epicbe.lortolano.configuration;

import java.util.Locale;
import org.springframework.context.annotation.*;
import com.epicbe.lortolano.model.Venditore;
import com.github.javafaker.Faker;

@Configuration
public class VenditoreConfiguration {

	@Bean("VenditoreRandomPIva")
	@Scope("prototype")
	public Venditore venditoreRandomPIva() {
		Faker fake = new Faker(new Locale("it-IT"));
		return Venditore.builder().indirizzo(fake.address().fullAddress())
				.partivaIva((long) fake.number().numberBetween(111111111, 99999999)).ragioneSociale(fake.company().bs())
				.nome(fake.name().firstName()).cognome(fake.name().lastName()).email(fake.internet().emailAddress())
				.pec(fake.internet().emailAddress()).build();
	}

	@Bean("VenditoreRandomNoIva")
	@Scope("prototype")
	public Venditore venditoreRandomNoIva() {
		Faker fake = new Faker(new Locale("it-IT"));
		return Venditore.builder().indirizzo(fake.address().fullAddress()).nome(fake.name().firstName())
				.cognome(fake.name().lastName()).email(fake.internet().emailAddress()).build();
	}

}
