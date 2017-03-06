package com.netradius.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * @author Kevin Hawkins
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				// Setup basic authentication
				.formLogin().disable()
				.logout().disable()
				.httpBasic()

				// Make sure the session management remains stateless
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

				// Disable some security mechanisms that don't make sense for this application
				.and()
				.headers().disable()
				.csrf().disable();
	}
}
