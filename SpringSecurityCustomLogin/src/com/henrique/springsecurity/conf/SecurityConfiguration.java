package com.henrique.springsecurity.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.util.concurrent.FailureCallback;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	@Autowired
	private AuthenticationSuccessHandler successHandler;
	
	@Autowired
	private AuthenticationFailureHandler failureHandler;
	
	@Autowired
	private AccessDeniedHandler accessDeniedHandler;
	
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
				failureHandler(failureHandler).
			and().
				exceptionHandling().
				accessDeniedHandler(accessDeniedHandler).
			and().
				authenticationProvider(authenticationProvider);
		

	}
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder authBuilder) throws Exception {
//		authBuilder.authenticationProvider(authenticationProvider);
//	}
	
	
}
