package me.enmanuel.accounting.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: enmanuelreyes
 * Date: 6/29/17
 * Time: 6:41 PM
 */
@Entity
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@Data
@RequiredArgsConstructor
@Table(name = "`transaction`")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_transaction")
    @ApiModelProperty(hidden = true)
    private Integer id;

    @NotNull
    @ManyToOne
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    @JoinColumn(name = "id_accounting_entry", referencedColumnName = "id_accounting_entry", nullable = false)
    private AccountingEntry accountingEntry;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_accounting_account", referencedColumnName = "id_accounting_account", nullable = false)
    private AccountingAccount accountingAccount;

    @NonNull
    @Enumerated(EnumType.STRING)
    private Origin origin;
    private BigDecimal amount;
}
