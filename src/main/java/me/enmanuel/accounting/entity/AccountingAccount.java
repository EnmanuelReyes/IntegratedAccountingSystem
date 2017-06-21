package me.enmanuel.accounting.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: Enmanuel Reyes
 * Date: 21-Jun-17
 * Time: 2:57 PM
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Data
@NoArgsConstructor
public class    AccountingAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_accounting_account")
    private Integer id;
    private String description;
    @NotNull
    @ManyToOne
    private AccountType accountType;
    private Boolean allowTransactions;
    private Byte level;
    @ManyToOne
    private AccountingAccount majorAccount;
    private BigDecimal balance;
    @NotNull
    @ManyToOne
    private State state;

    public AccountingAccount(Integer id, String description, AccountType accountType, Boolean allowTransactions,
                             Byte level, AccountingAccount majorAccount, BigDecimal balance, State state) {
        this.id = id;
        this.description = description;
        this.accountType = accountType;
        this.allowTransactions = allowTransactions;
        this.level = level;
        this.majorAccount = majorAccount;
        this.balance = balance;
        this.state = state;
    }
}
