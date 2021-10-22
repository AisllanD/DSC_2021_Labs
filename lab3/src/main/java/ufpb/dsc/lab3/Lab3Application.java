package ufpb.dsc.lab3;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import ufpb.dsc.lab3.filtro.TokenFilter;

@SpringBootApplication
public class Lab3Application {

	@Bean
	public FilterRegistrationBean<TokenFilter> filterJwt() {
		FilterRegistrationBean<TokenFilter> filterRB = new FilterRegistrationBean<TokenFilter>();
		filterRB.setFilter(new TokenFilter());
		filterRB.addUrlPatterns("/auth/api/usuarios/*");
		return filterRB;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Lab3Application.class, args);
	}

}
