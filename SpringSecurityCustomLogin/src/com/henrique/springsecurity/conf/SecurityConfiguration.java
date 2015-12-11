package com.henrique.springsecurity.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	@Autowired
	private AuthenticationSuccessHandler successHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.
				authorizeRequests().
				antMatchers("/secured/**").
				hasRole("USER").
				antMatchers("/admin/**").
				hasRole("ADMIN").
				antMatchers("/**").
				permitAll().
				anyRequest().
				authenticated().
			and().
				formLogin().
				loginPage("/login").
				successHandler(successHandler).
			and().
				authenticationProvider(authenticationProvider).
				csrf().
				disable();
//		and().
//			exceptionHandling().
//			accessDeniedHandler(accessDeniedHandler).
//			authenticationEntryPoint(authenticationEntryPoint).

	}
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder authBuilder) throws Exception {
//		authBuilder.authenticationProvider(authenticationProvider);
//	}
	
	
}
