package com.epicbe.lortolano.configuration;

import java.time.LocalDate;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import com.epicbe.lortolano.model.RicevutaDiPagamento;
import com.epicbe.lortolano.service.ClienteService;
import com.epicbe.lortolano.service.MerceService;
import com.epicbe.lortolano.service.VenditoreService;
import com.github.javafaker.Faker;

@Configuration
public class RicevutaDiPagamentoConfiguration {
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	VenditoreService venditoreService;
	
	@Autowired
	MerceService merceService;

	@Bean("RicevutaRandom")
	@Scope("prototype")
	public RicevutaDiPagamento ricevutaRandom() {
		Faker fake = new Faker(new Locale("it-IT"));
		long minDay = LocalDate.of(2020, 1, 1).toEpochDay();
	    long maxDay = LocalDate.of(2023, 12, 31).toEpochDay();
	    long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
	    LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
		return RicevutaDiPagamento.builder()
				.data(randomDate)
				.importo(fake.number().randomDouble(2, 0, 1000))
				.venditore(venditoreService.getVenditoreRandom())
				.cliente(clienteService.getClienteRandom())
				.merceVenduta(merceService.getMerceRandom())
				.build();
	}

}
