package com.epicbe.lortolano.configuration;

import java.util.Locale;
import org.springframework.context.annotation.*;
import com.epicbe.lortolano.model.Utente;
import com.github.javafaker.Faker;

@Configuration
public class UtenteConfiguration {

	@Bean("CreaUtenteConPIVA")
	@Scope("prototype")
	public Utente creaClienteIVA(String indirizzo, Long pIva, String ragioneSociale, String nome, String cognome,
			String email, String pec) {
		return Utente.builder().indirizzo(indirizzo).partivaIva(pIva).ragioneSociale(ragioneSociale).nome(nome)
				.cognome(cognome).email(email).pec(pec).build();
	}

	@Bean("UtenteConPIVA")
	@Scope("prototype")
	public Utente clientePIVA() {
		Faker fake = new Faker(new Locale("it-IT"));
		return Utente.builder().indirizzo(fake.address().fullAddress())
				.partivaIva((long) fake.number().numberBetween(111111111, 99999999)).ragioneSociale(fake.company().bs())
				.nome(fake.name().firstName()).cognome(fake.name().lastName()).email(fake.internet().emailAddress())
				.pec(fake.internet().emailAddress()).build();
	}

	@Bean("CreaUtenteSenzaPIVA")
	@Scope("prototype")
	public Utente creaClienteSenzaIVA(String indirizzo, String nome, String cognome, String email) {
		return Utente.builder().indirizzo(indirizzo).nome(nome).cognome(cognome).email(email).build();
	}

	@Bean("UtenteSenzaPIVA")
	@Scope("prototype")
	public Utente clienteNoPIVA() {
		Faker fake = new Faker(new Locale("it-IT"));
		return Utente.builder().indirizzo(fake.address().fullAddress()).nome(fake.name().firstName())
				.cognome(fake.name().lastName()).email(fake.internet().emailAddress()).build();
	}

}
