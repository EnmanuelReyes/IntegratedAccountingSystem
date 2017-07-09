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

    @Bean
    public CommandLineRunner initStatuses(StateRepository stateRepository) {
        return (args) -> {
            stateRepository.save(State.ACTIVE);
        };
    }


    @Bean
    public CommandLineRunner initAuxiliaries(AuxiliaryRepository auxiliaryRepository) {
        return (args) -> {
            auxiliaryRepository.save(new Auxiliary(1,   "Contabilidad", State.ACTIVE));
            auxiliaryRepository.save(new Auxiliary(2,   "Nomina", State.ACTIVE));
            auxiliaryRepository.save(new Auxiliary(3,   "Facturacion", State.ACTIVE));
            auxiliaryRepository.save(new Auxiliary(4,   "Inventario", State.ACTIVE));
            auxiliaryRepository.save(new Auxiliary(5,   "Cuentas x Cobrar", State.ACTIVE));
            auxiliaryRepository.save(new Auxiliary(6,   "Cuentas x Pagar", State.ACTIVE));
            auxiliaryRepository.save(new Auxiliary(7,   "Compras", State.ACTIVE));
            auxiliaryRepository.save(new Auxiliary(8,   "Activos Fijos", State.ACTIVE));
            auxiliaryRepository.save(new Auxiliary(9,   "Cheques", State.ACTIVE));
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
            accountingAccountRepository.save(new AccountingAccount(1, "Activos",
                    new AccountType(1), false, (byte)1, null, BigDecimal.ZERO, State.ACTIVE));

            accountingAccountRepository.save(new AccountingAccount(2, "Efectivo en caja y banco",
                    new AccountType(1), false, (byte)2, new AccountingAccount(1), BigDecimal.ZERO, State.ACTIVE));

            accountingAccountRepository.save(new AccountingAccount(3, "Caja Chica",
                    new AccountType(1), true, (byte)3, new AccountingAccount(2), BigDecimal.ZERO, State.ACTIVE));

            accountingAccountRepository.save(new AccountingAccount(4, "Cuenta Corriente Banco x",
                    new AccountType(1), true, (byte)3,  new AccountingAccount(3), BigDecimal.ZERO, State.ACTIVE));

            accountingAccountRepository.save(new AccountingAccount(5, "Inventarios y Mercancias",
                    new AccountType(1), false, (byte)2, new AccountingAccount(1), BigDecimal.ZERO, State.ACTIVE));

            accountingAccountRepository.save(new AccountingAccount(6, "Inventario",
                    new AccountType(1), true, (byte)3, new AccountingAccount(5), BigDecimal.ZERO, State.ACTIVE));

            accountingAccountRepository.save(new AccountingAccount(7, "Cuentas x Cobrar",
                    new AccountType(1), false, (byte)2, new AccountingAccount(1), BigDecimal.ZERO, State.ACTIVE));

            accountingAccountRepository.save(new AccountingAccount(8, "Cuentas x Cobrar Cliente X",
                    new AccountType(1), true, (byte)3, new AccountingAccount(7), BigDecimal.ZERO, State.ACTIVE));

            accountingAccountRepository.save(new AccountingAccount(12, "Ventas",
                    new AccountType(4), false, (byte)2, new AccountingAccount(1), BigDecimal.ZERO, State.ACTIVE));

//            accountingAccountRepository.save(new AccountingAccount(13, "Ingresos x Ventas",
//                    new AccountType(4), true, (byte)3, new AccountingAccount(12), BigDecimal.ZERO, State.ACTIVE));
//



            accountingAccountRepository.save(new AccountingAccount(47, "Gastos",
                    new AccountType(6), false, (byte)1, null, BigDecimal.ZERO, State.ACTIVE));
            accountingAccountRepository.save(new AccountingAccount(48, "Gastos Administrativos",
                    new AccountType(6), false, (byte)2, new AccountingAccount(47), BigDecimal.ZERO, State.ACTIVE));
            accountingAccountRepository.save(new AccountingAccount(50, "Gastos Generales",
                    new AccountType(6), true, (byte)3,  new AccountingAccount(48), BigDecimal.ZERO, State.ACTIVE));



            accountingAccountRepository.save(new AccountingAccount(65, "Gasto depreciación Activos Fijos",
                    new AccountType(6), false, (byte)2, new AccountingAccount(47), BigDecimal.ZERO, State.ACTIVE));
            accountingAccountRepository.save(new AccountingAccount(66, "Depreciación Acumulada Activos Fijos",
                    new AccountType(6), true, (byte)3, new AccountingAccount(65), BigDecimal.ZERO, State.ACTIVE));
//
//          accountingAccountRepository.save(new AccountingAccount(70, "Salarios y Sueldos Empleados",
//                    new AccountType(1), true, (byte)3, new AccountingAccount(18), BigDecimal.ZERO, State.ACTIVE));

//            accountingAccountRepository.save(new AccountingAccount(71, "Gastos de Nomina Empresa",
//                    new AccountType(1), true, (byte)3, new AccountingAccount(2), BigDecimal.ZERO, State.ACTIVE));
//            accountingAccountRepository.save(new AccountingAccount(80, "Compra de Mercancias",
//                    new AccountType(1), true, (byte)3, new AccountingAccount(2), BigDecimal.ZERO, State.ACTIVE));
//            accountingAccountRepository.save(new AccountingAccount(81, "Cuentas x Pagar",
//                    new AccountType(1), true, (byte)3, new AccountingAccount(2), BigDecimal.ZERO, State.ACTIVE));

//            accountingAccountRepository.save(new AccountingAccount(82, "Cuentas x Pagar Proveedor X",
//                    new AccountType(1), true, (byte)3, new AccountingAccount(2), BigDecimal.ZERO, State.ACTIVE));

            accountingAccountRepository.save(new AccountingAccount(83, "Cuentas Cheques en Banco X",
                    new AccountType(1), true, (byte)3, new AccountingAccount(3), BigDecimal.ZERO, State.ACTIVE));



        };
    }

}
