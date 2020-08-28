package com.github.gustavolara.ifmt.cobrancaifmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class CobrancaifmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(CobrancaifmtApplication.class, args);
	}

	@Bean
	public FixedLocaleResolver localResolver(){
		return new FixedLocaleResolver(new Locale("pt","BR"));
	}
}
