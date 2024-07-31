package com.nothing.unified_authentication_service_resource_server;

import java.security.NoSuchAlgorithmException;
import java.time.OffsetDateTime;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Env;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@Configuration
@EnableWebSecurity
@Slf4j
public class UnifiedAuthenticationServiceResourceServerApplication {

   static {
		log.info("UnifiedAuthenticationServiceResourceServerApplication is UP");
	}
	
	public static void main(String[] args) {
		
	}
	
	// This is the resource filterChain to verify jwt tokens for all incoming
	// resource request
	@Bean
	public SecurityFilterChain resourceServerSecurityFilterChain(HttpSecurity http) throws Exception {

		log.info("Initialized inbuilt resourceServerSecurityFilterChain to verify jwt tokens for all incoming resource request");
		
		http.authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
				.oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.decoder(unifiedAuthServiceJwtDecoder())));

		log.info("listening for request.....");

		return http.build();
	}

	// key trust
	@Bean
	public JwtDecoder unifiedAuthServiceJwtDecoder() {
		SecretKey secretKey = null;
		try {
			secretKey = new SecretKeySpec("abcdefghijklmnopqrstuvxwyz12345678".getBytes(),
					Mac.getInstance("HmacSHA256").getAlgorithm());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return NimbusJwtDecoder.withSecretKey(secretKey).build();
	}

}
