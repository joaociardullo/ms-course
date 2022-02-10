package com.devjoao.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//Essa clase serve para configurar e acessar outro projeto com RestTemplate e tem que ser o Bean
@Configuration
public class AppConfig {

	@Bean
	public RestTemplate restTamplate() {
		return new RestTemplate();
	}
}
