package me.enmanuel.accounting.repository;

import me.enmanuel.accounting.entity.AccountingAccount;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by IntelliJ IDEA.
 * User: Enmanuel Reyes
 * Date: 21-Jun-17
 * Time: 6:18 PM
 */
public interface AccountingAccountRepository extends CrudRepository<AccountingAccount, Integer> {
}
