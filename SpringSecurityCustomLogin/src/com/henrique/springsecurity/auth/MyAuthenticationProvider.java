package com.henrique.springsecurity.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {

		String name;
		String password;
		List<GrantedAuthority> grantedAuths;
			name = auth.getName();
			String login = (String) auth.getPrincipal();
			password = auth.getCredentials().toString();

			System.out.println("|----- MyAuthenticationManager -----------");
			System.out.println("nome: " + name);
			System.out.println("login: " + login);
			System.out.println("password: " + password);

			grantedAuths = new ArrayList<>();
			grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));

			//throw new BadCredentialsException("asdasdasdadasd");
			return new UsernamePasswordAuthenticationToken(name, password, grantedAuths);


	}

	@Override
	public boolean supports(Class<?> auth) {
		return auth.equals(UsernamePasswordAuthenticationToken.class);
	}

}
