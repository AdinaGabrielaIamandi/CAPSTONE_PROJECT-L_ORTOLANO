package com.epicbe.lortolano.runner;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.epicbe.lortolano.auth.entity.ERole;
import com.epicbe.lortolano.auth.entity.Role;
import com.epicbe.lortolano.auth.repository.RoleRepository;
import com.epicbe.lortolano.auth.repository.UserRepository;
import com.epicbe.lortolano.auth.service.AuthService;
import com.epicbe.lortolano.service.ClienteService;
import com.epicbe.lortolano.service.MerceService;
import com.epicbe.lortolano.service.VenditoreService;

@Component
public class LOrtolanoRunner implements ApplicationRunner {

	@Autowired
	ClienteService clienteService;
	
	@Autowired
	MerceService merceService;
	
	@Autowired
	VenditoreService venditoreService;
	
	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthService authService;
	
	private static Set<Role> userRole;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("Wait for it ...");
		
		//SETTA RUOLI ADMIN/USER IN DB
		//setRoleDefault();
		
		//REGISTRARSI QUI TRAMITE ENDPOINT
		
		//IMPORTARE I COMUNI DA CSV QUI DA POSTMAN
		
		//IMPORTARE LE PROVINCE DA CSV QUI DA POSTMAN
		
		//CREA ENTITA DI DEFAULT NEL DB	
		//starterDB();

	}
	
	private void starterDB() {

		for (int i = 0; i<10; i++) {
			clienteService.saveClienteRandomConPIva();
			clienteService.saveClienteRandomSenzaPIva();
		}
		
		for (int i = 0; i<20; i++) {
			venditoreService.saveVenditoreRandomNoIva();
			venditoreService.saveVenditoreRandomPIva();
		}
		
		for (int i = 0; i<130; i++) {
			merceService.saveFruttaRandom();
			merceService.saveVerdure();
		}

	}
	
	private void setRoleDefault() {

		Role user = new Role();
		user.setRoleName(ERole.ROLE_USER);
		roleRepository.save(user);

		userRole = new HashSet<Role>();
		userRole.add(user);
	}
	
	

}
