package me.enmanuel.accounting.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * User: Enmanuel Reyes
 * Date: 23-Jun-17
 * Time: 11:10 AM
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Data
@NoArgsConstructor
public class AccountingEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_accounting_entry")
    private Integer id;
    private String description;
    private Integer auxiliary;
    @NotNull
    @ManyToOne
    private AccountingAccount accountingAccount;
    @NonNull
    @Enumerated(EnumType.STRING)
    private Origin origin;
    private LocalDateTime date;
    private BigDecimal amount;
    @NotNull
    @ManyToOne
    private State state;
}
