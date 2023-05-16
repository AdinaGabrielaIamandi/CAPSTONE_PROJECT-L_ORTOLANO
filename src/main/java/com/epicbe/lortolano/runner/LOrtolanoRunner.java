package com.epicbe.lortolano.runner;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.epicbe.lortolano.auth.entity.Role;
import com.epicbe.lortolano.auth.service.AuthService;
import com.epicbe.lortolano.service.ClienteService;
import com.epicbe.lortolano.service.MerceService;
import com.epicbe.lortolano.service.RicevutaDiPagamentoService;
import com.epicbe.lortolano.service.VenditoreService;

@Component
public class LOrtolanoRunner implements ApplicationRunner {

	@Autowired
	ClienteService clienteService;
	
	@Autowired
	MerceService merceService;
	
	@Autowired
	RicevutaDiPagamentoService ricevutaService;
	
	@Autowired
	VenditoreService venditoreService;
	
	@Autowired
	AuthService authService;
	
	private static Set<Role> userRole;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("Wait for it ...");

	}

}
