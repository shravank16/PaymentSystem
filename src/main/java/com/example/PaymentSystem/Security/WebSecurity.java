package com.example.PaymentSystem.Security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors()
		.and()
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/api/users").hasRole("Manager")
		.antMatchers("/api/users/").hasRole("Manager")
		.antMatchers("/api/biller").hasRole("Manager")
		.antMatchers("/api/bill").hasRole("Manager")
		.antMatchers("/api/bill/get").hasRole("Manager")
		.antMatchers("/api/bill").hasRole("Manager")
		.antMatchers("/api/user").hasRole("User")
		.antMatchers("api/bill/").hasRole("User")		
		.anyRequest().authenticated()
		.and().httpBasic();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
        .withUser("user")
        .password("{noop}user")
        .roles("User")
        .and()
        .withUser("manager")
        .password("{noop}manager")
        .roles("Manager");
	}
	
}
