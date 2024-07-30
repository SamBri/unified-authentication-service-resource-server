package com.nothing.unified_authentication_service_resource_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
@EnableWebSecurity
public class UnifiedAuthenticationServiceResourceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnifiedAuthenticationServiceResourceServerApplication.class, args);
	}
	
	

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http
	        .authorizeHttpRequests(authorize -> authorize
	            .anyRequest().authenticated()
	        )
	        .oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()));
	    return http.build();
	}


}
