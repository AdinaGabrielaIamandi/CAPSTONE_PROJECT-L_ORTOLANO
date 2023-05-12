package com.epicbe.lortolano.configuration;

import java.util.Locale;
import org.springframework.context.annotation.*;
import com.epicbe.lortolano.model.Merce;
import com.github.javafaker.Faker;

@Configuration
public class MerceConfiguration {

	@Bean("VerduraRandom")
	@Scope("prototype")
	public Merce verduraRandom() {
		Faker fake = new Faker(new Locale("it-IT"));
		return Merce.builder().tipoMerce(fake.food().vegetable()).quantità((double) fake.number().randomDigitNotZero())
				.prezzoAlKg(Double.parseDouble(fake.commerce().price())).build();
	}

	@Bean("FruttaRandom")
	@Scope("prototype")
	public Merce fruttaRandom() {
		Faker fake = new Faker(new Locale("it-IT"));
		return Merce.builder().tipoMerce(fake.food().fruit()).quantità((double) fake.number().randomDigitNotZero())
				.prezzoAlKg(Double.parseDouble(fake.commerce().price())).build();
	}

}
