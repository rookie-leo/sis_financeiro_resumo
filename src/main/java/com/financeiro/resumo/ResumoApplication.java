package com.financeiro.resumo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ResumoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResumoApplication.class, args);
	}

}
