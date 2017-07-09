package me.enmanuel.accounting.repository;

import me.enmanuel.accounting.entity.Auxiliary;
import me.enmanuel.accounting.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by IntelliJ IDEA.
 * User: enmanuelreyes
 * Date: 6/29/17
 * Time: 6:45 PM
 */
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
}
