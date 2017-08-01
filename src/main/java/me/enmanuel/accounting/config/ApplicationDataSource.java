package me.enmanuel.accounting.config;

import me.enmanuel.accounting.entity.*;
import me.enmanuel.accounting.repository.AccountTypeRepository;
import me.enmanuel.accounting.repository.AccountingAccountRepository;
import me.enmanuel.accounting.repository.AuxiliaryRepository;
import me.enmanuel.accounting.repository.StateRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: Enmanuel Reyes
 * Date: 21-Jun-17
 * Time: 3:50 PM
 */
@Configuration
@EnableJpaRepositories(basePackages = "me.enmanuel.accounting.repository")
@EntityScan(basePackages = "me.enmanuel.accounting.entity")
public class ApplicationDataSource {

}
