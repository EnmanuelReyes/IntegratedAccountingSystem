package me.enmanuel.accounting.repository;

import me.enmanuel.accounting.entity.AccountingEntry;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by IntelliJ IDEA.
 * User: Enmanuel Reyes
 * Date: 23-Jun-17
 * Time: 11:16 AM
 */
public interface AccountingEntryRepository extends CrudRepository<AccountingEntry, Integer> {
}
