package com.epicbe.lortolano.configuration;

import java.util.Locale;
import org.springframework.context.annotation.*;
import com.epicbe.lortolano.model.Cliente;
import com.github.javafaker.Faker;

@Configuration
public class ClienteConfiguration {

	@Bean("ClienteConPIVA")
	@Scope("prototype")
	public Cliente clientePIVA() {
		Faker fake = new Faker(new Locale("it-IT"));
		return Cliente.builder().indirizzo(fake.address().fullAddress())
				.partivaIva((long) fake.number().numberBetween(111111111, 99999999)).ragioneSociale(fake.company().bs())
				.nome(fake.name().firstName()).cognome(fake.name().lastName()).email(fake.internet().emailAddress())
				.pec(fake.internet().emailAddress()).build();
	}

	@Bean("ClienteSenzaPIVA")
	@Scope("prototype")
	public Cliente clienteNoPIVA() {
		Faker fake = new Faker(new Locale("it-IT"));
		return Cliente.builder().indirizzo(fake.address().fullAddress()).nome(fake.name().firstName())
				.cognome(fake.name().lastName()).email(fake.internet().emailAddress())
				.build();
	}

}
