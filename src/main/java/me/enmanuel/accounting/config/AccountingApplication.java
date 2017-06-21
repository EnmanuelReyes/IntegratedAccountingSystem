package me.enmanuel.accounting.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "me.enmanuel.accounting")
public class AccountingApplication {

	public static void  main(String[] args) {
		SpringApplication.run(AccountingApplication.class, args);
	}
}
