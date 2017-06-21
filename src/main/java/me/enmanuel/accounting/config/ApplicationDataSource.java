package me.enmanuel.accounting.config;

import me.enmanuel.accounting.entity.AccountType;
import me.enmanuel.accounting.entity.AccountingAccount;
import me.enmanuel.accounting.entity.Origin;
import me.enmanuel.accounting.entity.State;
import me.enmanuel.accounting.repository.AccountTypeRepository;
import me.enmanuel.accounting.repository.AccountingAccountRepository;
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

    @Bean
    public CommandLineRunner initStatuses(StateRepository stateRepository) {
        return (args) -> {
            stateRepository.save(State.ACTIVE);
        };
    }

    @Bean
    public CommandLineRunner initAccountTypes(AccountTypeRepository accountTypeRepository) {
        return (args) -> {
            accountTypeRepository.save(new AccountType(1, "Activos", Origin.CREDIT, State.ACTIVE));
            accountTypeRepository.save(new AccountType(2, "Pasivos", Origin.CREDIT, State.ACTIVE));
            accountTypeRepository.save(new AccountType(3, "Capital", Origin.CREDIT, State.ACTIVE));
            accountTypeRepository.save(new AccountType(4, "Ingresos", Origin.CREDIT, State.ACTIVE));
            accountTypeRepository.save(new AccountType(5, "Costos", Origin.CREDIT, State.ACTIVE));
            accountTypeRepository.save(new AccountType(6, "Gastos", Origin.CREDIT, State.ACTIVE));
        };
    }

    @Bean
    public CommandLineRunner initAccountingAccounts(AccountingAccountRepository accountingAccountRepository) {
        return (args) -> {
            accountingAccountRepository.save(new AccountingAccount(1, "Activos", new AccountType(1), false, (byte)1,
                    null, BigDecimal.ZERO, State.ACTIVE));
        };
    }

}
