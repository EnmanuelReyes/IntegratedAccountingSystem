package me.enmanuel.accounting.service;

import me.enmanuel.accounting.entity.AccountingEntry;
import me.enmanuel.accounting.entity.Origin;
import me.enmanuel.accounting.entity.Transaction;
import me.enmanuel.accounting.repository.AccountingEntryRepository;
import me.enmanuel.accounting.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: enmanuelreyes
 * Date: 7/7/17
 * Time: 11:10 PM
 */
@Service
public class AccountingEntryService {

    @Autowired
    AccountingEntryRepository accountingEntryRepository;

    @Autowired
    TransactionRepository transactionRepository;

    public AccountingEntry save(AccountingEntry accountingEntry) {
        validate(accountingEntry);
        accountingEntry.setDate(LocalDateTime.now());
        for (Transaction transaction : accountingEntry.getTransactions()) {
            transaction.setAccountingEntry(accountingEntry);
        }
        List<Transaction> transactions= accountingEntry.getTransactions();
        accountingEntry.setTransactions(null);
        accountingEntryRepository.save(accountingEntry);

        transactionRepository.save(transactions);
        return accountingEntry;
    }

    public void validate(AccountingEntry accountingEntry) {
        if (CollectionUtils.isEmpty(accountingEntry.getTransactions())) {
            throw new RuntimeException("Debe haber por lo menos una transaccion");
        }
        boolean hasDebit = false;
        boolean hasCredit = false;
        for (Transaction transaction : accountingEntry.getTransactions()) {
            if (transaction.getOrigin() == Origin.DEBIT) {
                hasDebit = true;
            }

            if (transaction.getOrigin() == Origin.CREDIT) {
                hasCredit = true;
            }
        }

        if (hasDebit && !hasCredit) {
            throw new RuntimeException("Debe haber por lo menos una transaccion de Credito");
        }
        if (hasCredit && !hasDebit) {
            throw new RuntimeException("Debe haber por lo menos una transaccion de Debito");
        }
    }
}
