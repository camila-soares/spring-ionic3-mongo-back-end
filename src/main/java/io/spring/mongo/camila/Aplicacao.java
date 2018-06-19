/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.spring.mongo.camila;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 *
 * @author Nataniel Paiva <nataniel.paiva@gmail.com>
 */
@SpringBootApplication
public class Aplicacao {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Aplicacao.class, args);
    }

    @Bean
    public CorsFilter corsFilter(){
    	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    	CorsConfiguration config = new CorsConfiguration();
    	config.setAllowCredentials(true);
    	config.addAllowedOrigin("*");
    	config.addAllowedHeader("*");
    	config.addAllowedMethod("GET");
    	config.addAllowedMethod("PUT");
    	config.addAllowedMethod("POST");
    	config.addAllowedMethod("OPTIONS");
    	config.addAllowedMethod("DELETE");
    	source.registerCorsConfiguration("/**", config);
		return new CorsFilter();
    	
    }
}