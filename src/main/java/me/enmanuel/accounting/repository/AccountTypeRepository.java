package me.enmanuel.accounting.repository;

import me.enmanuel.accounting.entity.AccountType;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by IntelliJ IDEA.
 * User: Enmanuel Reyes
 * Date: 21-Jun-17
 * Time: 3:51 PM
 */
public interface AccountTypeRepository extends CrudRepository<AccountType, Integer> {
}
