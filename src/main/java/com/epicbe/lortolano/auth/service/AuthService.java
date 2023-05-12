package com.epicbe.lortolano.auth.service;

import com.epicbe.lortolano.auth.payload.LoginDto;
import com.epicbe.lortolano.auth.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
