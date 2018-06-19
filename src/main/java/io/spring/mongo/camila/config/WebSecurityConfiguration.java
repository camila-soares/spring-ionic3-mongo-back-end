package io.spring.mongo.camila.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import io.spring.mongo.camila.service.DetailService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DetailService detailService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
		authenticationManagerBuilder.userDetailsService(detailService);
	}
	
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
	
	public void configure(WebSecurity security) throws Exception {
		security.ignoring().antMatchers(HttpMethod.OPTIONS, "/**")
						   .antMatchers(HttpMethod.GET, "/public/**");
	}
}
